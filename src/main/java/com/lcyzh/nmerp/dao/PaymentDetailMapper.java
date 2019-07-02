package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.PaymentDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-07-02
*/
@Repository
public interface PaymentDetailMapper {

    PaymentDetail findById(String id);

    List<PaymentDetail> findList(PaymentDetail paymentDetail);

    List<PaymentDetail> findAllList();

    int insert(PaymentDetail paymentDetail);

    int insertBatch(List<PaymentDetail> paymentDetails);

    int update(PaymentDetail paymentDetail);

    int delete(PaymentDetail paymentDetail);

}