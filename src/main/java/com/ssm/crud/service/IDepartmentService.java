package com.ssm.crud.service;

import com.ssm.crud.domain.Department;

import java.util.List;

public interface IDepartmentService {

    Department getDepartmentById(Integer id);

    List<Department> listDepartments();
}
