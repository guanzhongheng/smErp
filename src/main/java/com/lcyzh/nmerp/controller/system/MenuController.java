package com.lcyzh.nmerp.controller.system;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.lcyzh.nmerp.common.utils.Global;
import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.controller.system.util.UserUtils;
import com.lcyzh.nmerp.entity.sys.Menu;
import com.lcyzh.nmerp.service.security.SystemService;
import com.lcyzh.nmerp.utils.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 项目名称：nm-erp
 * 类 名 称：MenuController
 * 类 描 述：TODO
 * 创建时间：2019/7/1 5:01 PM
 * 创 建 人：guan
 */
@Controller
@RequestMapping("sys/menu")
public class MenuController extends BaseController {

    @RequestMapping(value = "tree")
    public String tree() {
        return "modules/sys/menuTree";
    }

    @Autowired
    private SystemService systemService;

    @ModelAttribute("menu")
    public Menu get(@RequestParam(required=false) String id) {
        if (StringUtils.isNotBlank(id)){
            return systemService.getMenu(id);
        }else{
            return new Menu();
        }
    }

    @RequestMapping(value = {"list", ""})
    public String list(Model model) {
        List<Menu> list = Lists.newArrayList();
        List<Menu> sourcelist = systemService.findAllMenu();
        Menu.sortList(list, sourcelist, Menu.getRootId(), true);
        model.addAttribute("list", list);
        return "modules/sys/menuList";
    }

    @RequestMapping(value = "form")
    public String form(Menu menu, Model model) {
        if (menu.getParent()==null||menu.getParent().getId()==null){
            menu.setParent(new Menu(Menu.getRootId()));
        }
        menu.setParent(systemService.getMenu(menu.getParent().getId()));
        // 获取排序号，最末节点排序号+30
        if (StringUtils.isBlank(menu.getId())){
            List<Menu> list = Lists.newArrayList();
            List<Menu> sourcelist = systemService.findAllMenu();
            Menu.sortList(list, sourcelist, menu.getParentId(), false);
            if (list.size() > 0){
                menu.setSort(list.get(list.size()-1).getSort() + 30);
            }
        }
        model.addAttribute("menu", menu);
        return "modules/sys/menuForm";
    }

    @RequestMapping(value = "save")
    public String save(Menu menu, Model model, RedirectAttributes redirectAttributes) {
        if(!UserUtils.getUser().isAdmin()){
            addMessage(redirectAttributes, "越权操作，只有超级管理员才能添加或修改数据！");
            return "redirect:/sys/menu/?repage";
        }
        if (!beanValidator(model, menu)){
            return form(menu, model);
        }
        systemService.saveMenu(menu);
        addMessage(redirectAttributes, "保存菜单'" + menu.getName() + "'成功");
        return "redirect:/sys/menu/";
    }

    @RequestMapping(value = "delete")
    public String delete(Menu menu, RedirectAttributes redirectAttributes) {
        if(Global.isDemoMode()){
            addMessage(redirectAttributes, "演示模式，不允许操作！");
            return "redirect:/sys/menu/";
        }
//		if (Menu.isRoot(id)){
//			addMessage(redirectAttributes, "删除菜单失败, 不允许删除顶级菜单或编号为空");
//		}else{
        systemService.deleteMenu(menu);
        addMessage(redirectAttributes, "删除菜单成功");
//		}
        return "redirect:/sys/menu/";
    }

    @RequestMapping(value = "treeselect")
    public String treeselect(String parentId, Model model) {
        model.addAttribute("parentId", parentId);
        return "modules/sys/menuTreeselect";
    }

    /**
     * 批量修改菜单排序
     */
    @RequestMapping(value = "updateSort")
    public String updateSort(String[] ids, Integer[] sorts, RedirectAttributes redirectAttributes) {
        if(Global.isDemoMode()){
            addMessage(redirectAttributes, "演示模式，不允许操作！");
            return "redirect:" + adminPath + "/sys/menu/";
        }
        for (int i = 0; i < ids.length; i++) {
            Menu menu = new Menu(ids[i]);
            menu.setSort(sorts[i]);
            systemService.updateMenuSort(menu);
        }
        addMessage(redirectAttributes, "保存菜单排序成功!");
        return "redirect:/sys/menu/";
    }

    /**
     * isShowHide是否显示隐藏菜单
     * @param extId
     * @param isShowHide
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "treeData")
    public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, @RequestParam(required=false) String isShowHide, HttpServletResponse response) {
        List<Map<String, Object>> mapList = Lists.newArrayList();
        List<Menu> list = systemService.findAllMenu();
        for (int i=0; i<list.size(); i++){
            Menu e = list.get(i);
            if (StringUtils.isBlank(extId) || (extId!=null && !extId.equals(e.getId()) && e.getParentIds().indexOf(","+extId+",")==-1)){
                if(isShowHide != null && isShowHide.equals("0") && e.getIsShow().equals("0")){
                    continue;
                }
                Map<String, Object> map = Maps.newHashMap();
                map.put("id", e.getId());
                map.put("pId", e.getParentId());
                map.put("name", e.getName());
                mapList.add(map);
            }
        }
        return mapList;
    }
}
