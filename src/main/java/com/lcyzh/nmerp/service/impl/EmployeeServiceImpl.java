package com.lcyzh.nmerp.service.impl;

import com.lcyzh.nmerp.dao.EmployeeMapper;
import com.lcyzh.nmerp.entity.Employee;
import com.lcyzh.nmerp.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Author ljk
* Date  2019-07-01
*/
@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee get(String id){
        return employeeMapper.get(id);
    }

    @Override
    public List<Employee> findList(Employee employee) {
        return employeeMapper.findList(employee);
    }

    @Override
    public List<Employee> findAllList() {
        return employeeMapper.findAllList();
    }

    @Override
    public int insert(Employee employee) {
        return employeeMapper.insert(employee);
    }

    @Override
    public int insertBatch(List<Employee> employees){
        return employeeMapper.insertBatch(employees);
    }

    @Override
    public int update(Employee employee) {
        return employeeMapper.update(employee);
    }

    @Override
    public int delete(Employee employee) {
        return employeeMapper.delete(employee);
    }

}
