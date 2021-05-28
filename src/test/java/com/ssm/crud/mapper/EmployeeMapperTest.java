package com.ssm.crud.mapper;

import com.ssm.crud.domain.Department;
import com.ssm.crud.domain.Employee;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper mapper;

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void getEmployeeById() {
        Employee employee = mapper.getEmployeeById(1);
        System.out.println(employee);
    }

    @Test
    public void listEmployees() {
        List<Employee> employeeList = mapper.listEmployees();
        System.out.println(employeeList);
    }

    @Test
    public void insertEmployee() {
        //Employee employee = new Employee();
        //employee.setName("aa");
        //employee.setEmail("dad@qq.com");
        //employee.setGender("男");
        //employee.setDepartment(new Department(1, "开发部"));
        //mapper.insertEmployee(employee);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Department department = new Department(1, null);
        for (int i = 0; i < 1000; i++) {
            String name = UUID.randomUUID().toString().substring(0, 5) + i;
            mapper.insertEmployee(new Employee(null, name, "男", name + "@qq.com", department));
        }

    }

    @Test
    public void deleteEmployeeById() {
        mapper.deleteEmployeeById(2);
    }

    @Test
    public void updateEmployee() {
        Employee employee = mapper.getEmployeeById(1);
        employee.setName("大D");
        mapper.updateEmployee(employee);
    }
}