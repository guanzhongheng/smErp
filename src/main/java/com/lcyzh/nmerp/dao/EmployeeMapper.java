package com.lcyzh.nmerp.dao;

import com.lcyzh.nmerp.entity.Employee;

import java.util.List;

/**
* Author ljk
* Date  2019-07-01
*/
public interface EmployeeMapper {

    Employee get(String id);

    List<Employee> findList(Employee employee);

    List<Employee> findAllList();

    int insert(Employee employee);

    int insertBatch(List<Employee> employees);

    int update(Employee employee);

    int delete(Employee employee);

}