package com.ssm.crud.mapper.com.ssm.crud.service.impl;

import com.ssm.crud.domain.Department;
import com.ssm.crud.domain.Employee;
import com.ssm.crud.service.IDepartmentService;
import com.ssm.crud.service.IEmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ServiceTest {

    @Autowired
    private IDepartmentService departmentService;

    @Autowired
    private IEmployeeService employeeService;

    @Test
    public void test1(){
        List<Department> departments = departmentService.listDepartments();
        System.out.println(departments);

        List<Employee> employees = employeeService.listEmployees();
        System.out.println(employees);
    }

}
