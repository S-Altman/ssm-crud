package com.ssm.crud.service.impl;

import com.ssm.crud.domain.Department;
import com.ssm.crud.mapper.DepartmentMapper;
import com.ssm.crud.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Department getDepartmentById(Integer id) {
        return departmentMapper.getDepartmentById(id);
    }

    @Override
    public List<Department> listDepartments() {
        return departmentMapper.listDepartments();
    }
}
