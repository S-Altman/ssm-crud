package com.ssm.crud.service;

import com.ssm.crud.domain.Employee;
import com.ssm.crud.mapper.EmployeeMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IEmployeeService {

    List<Employee> listEmployees();

    Employee getEmployeeById(Integer id);

    void insertEmployee(Employee employee);

    void deleteEmployeeById(Integer id);

    void updateEmployee(Employee employee);

    void updateEmployeeWithoutName(Employee employee);

    boolean checkEmp(String empName);
}
