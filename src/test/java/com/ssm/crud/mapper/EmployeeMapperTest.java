package com.ssm.crud.mapper;

import com.ssm.crud.domain.Department;
import com.ssm.crud.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper mapper;

    @Test
    public void getEmployeeById() {
        Employee employee = mapper.getEmployeeById(1);
        System.out.println(employee);
    }

    @Test
    public void listEmployees() {
    }

    @Test
    public void insertEmployee() {
        Employee employee = new Employee();
        employee.setName("大d");
        employee.setEmail("dad@qq.com");
        employee.setGender("男");
        employee.setDepartment(new Department(1, "开发部"));
        mapper.insertEmployee(employee);
    }

    @Test
    public void deleteEmployeeById() {
    }

    @Test
    public void updateEmployee() {
        Employee employee = mapper.getEmployeeById(1);
        employee.setName("大D");
        mapper.updateEmployee(employee);
    }
}