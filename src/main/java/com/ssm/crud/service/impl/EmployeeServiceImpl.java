package com.ssm.crud.service.impl;

import com.ssm.crud.domain.Employee;
import com.ssm.crud.mapper.EmployeeMapper;
import com.ssm.crud.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> listEmployees() {
        return employeeMapper.listEmployees();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeMapper.getEmployeeById(id);
    }

    @Override
    public void insertEmployee(Employee employee) {
        employeeMapper.insertEmployee(employee);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeMapper.deleteEmployeeById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
    }

    @Override
    public void updateEmployeeWithoutName(Employee employee) {
        employeeMapper.updateEmployeeWithoutName(employee);
    }

    @Override
    public boolean checkEmp(String empName) {
        Employee employee = employeeMapper.getEmployeeByName(empName);
        return employee == null;
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        employeeMapper.deleteBatch(ids);
    }
}
