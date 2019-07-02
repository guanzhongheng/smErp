package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.Payment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Author ljk
* Date  2019-07-02
*/
@Repository
public interface PaymentMapper {

    Payment findById(String id);

    List<Payment> findList(Payment payment);

    List<Payment> findAllList();

    int insert(Payment payment);

    int insertBatch(List<Payment> payments);

    int update(Payment payment);

    int delete(Payment payment);

}