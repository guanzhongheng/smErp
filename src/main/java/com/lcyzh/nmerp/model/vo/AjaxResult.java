/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.lcyzh.nmerp.model.vo;

import java.util.LinkedHashMap;


/**
 * @Project : ffprSystem
 * @Description : 通用ajax请求响应数据封装类
 * @Author : wsm
 * @Iteration : 1.0
 * @Date : 2018/10/15  下午4:51
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * wsm          2018/10/15    create
 */
public class AjaxResult {

  private boolean success = true;// 是否成功
  private String errorCode = "0";// 错误代码
  private String msg = "操作成功";// 提示信息
  private LinkedHashMap<String, Object> body = new LinkedHashMap();// 封装json的map

  public LinkedHashMap<String, Object> getBody() {
    return body;
  }

  public void setBody(LinkedHashMap<String, Object> body) {
    this.body = body;
  }

  public void put(String key, Object value) {// 向json中添加属性，在js中访问，请调用data.map.key
    body.put(key, value);
  }

  public void remove(String key) {
    body.remove(key);
  }


  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {// 向json中添加属性，在js中访问，请调用data.msg
    this.msg = msg;
  }


  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorCode() {
    return errorCode;
  }


}
