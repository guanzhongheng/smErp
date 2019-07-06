package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.TBarCodeInfo;
import com.lcyzh.nmerp.model.vo.ConcreteProdVo;
import com.lcyzh.nmerp.model.vo.ProdInvInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TBarCodeInfoMapper {

    List<ProdInvInfoVo> findInvInfoList();

    List<TBarCodeInfo> findList(TBarCodeInfo entry);

    int insert(TBarCodeInfo entry);

    int update(TBarCodeInfo entry);

    int updateBatch(@Param("list") List<TBarCodeInfo> barCodeInfos);

    List<TBarCodeInfo> findBySelectKey(TBarCodeInfo entry);

    TBarCodeInfo findByPrimaryKey(String barCode);

    ConcreteProdVo findDetailByPrimaryKey(String barCode);
}
