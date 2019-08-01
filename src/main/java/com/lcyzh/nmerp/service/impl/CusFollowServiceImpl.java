package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.CusFollowDetailMapper;
import com.lcyzh.nmerp.dao.CusFollowMapper;
import com.lcyzh.nmerp.entity.CusFollow;
import com.lcyzh.nmerp.entity.CusFollowDetail;
import com.lcyzh.nmerp.model.vo.CusFollowDetailVo;
import com.lcyzh.nmerp.service.ICusFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Author ljk
 * Date  2019-07-01
 */
@Service
public class CusFollowServiceImpl implements ICusFollowService {
    @Autowired
    private CusFollowMapper cusFollowMapper;
    @Autowired
    private CusFollowDetailMapper cusFollowDetailMapper;


    @Override
    public List<CusFollowDetail> findList(CusFollowDetail vo) {
        if (vo != null) {
            List<CusFollowDetail> list = cusFollowDetailMapper.findList(vo);
            return list;
        }
        return null;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public int save(CusFollowDetailVo vo) {
        int res = -1;
        if (vo != null && vo.getCusCode() != null) {
            Date current = new Date();
            CusFollow cusFollow = new CusFollow();
            cusFollow.setCusCode(vo.getCusCode());
            cusFollow.setLatestFollowTime(vo.getFollowTime());
            cusFollow.setUpdateTime(current);
            res = cusFollowMapper.update(cusFollow);
            if (res > 0) {
                CusFollowDetail followDetail = new CusFollowDetail();
                followDetail.setCusCode(vo.getCusCode());
                followDetail.setEmpCode(vo.getEmpCode());
                followDetail.setFollowTitle(vo.getFollowTitle());
                followDetail.setFollowTime(vo.getFollowTime());
                followDetail.setFollowDetail(vo.getFollowDetail());
                followDetail.setRemark(vo.getRemark());
                followDetail.setCreateTime(current);
                res = cusFollowDetailMapper.insert(followDetail);
            }

        }
        return res;
    }

    @Override
    public List<CusFollow> findList(CusFollow cusFollow) {
        return cusFollowMapper.findList(cusFollow);
    }

    @Override
    public List<CusFollow> findAllList() {
        return cusFollowMapper.findAllList();
    }

    @Override
    public int insert(CusFollow cusFollow) {
        return cusFollowMapper.insert(cusFollow);
    }

    @Override
    public int update(CusFollow cusFollow) {
        return cusFollowMapper.update(cusFollow);
    }

    @Override
    public int delete(CusFollow cusFollow) {
        return cusFollowMapper.delete(cusFollow);
    }

}
