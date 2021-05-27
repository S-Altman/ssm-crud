package com.ssm.crud.controller;

import com.ssm.crud.domain.Employee;
import com.ssm.crud.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/emps")
    public String listEmps(Model model){
        List<Employee> employeeList = employeeService.listEmployees();
        model.addAttribute("list", employeeList);
        return "list";
    }

}
