package com.ssm.crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.crud.domain.Employee;
import com.ssm.crud.domain.Msg;
import com.ssm.crud.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    //@RequestMapping("/emps")
    //public String listEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model){
    //    PageHelper.startPage(pn, 5);
    //    List<Employee> employeeList = employeeService.listEmployees();
    //    PageInfo<Employee> pageInfo = new PageInfo<>(employeeList);
    //    model.addAttribute("pageInfo", pageInfo);
    //    return "list";
    //}

    @RequestMapping("/emps")
    @ResponseBody
    public Msg listEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn){
        PageHelper.startPage(pn, 5);
        List<Employee> employeeList = employeeService.listEmployees();
        PageInfo<Employee> pageInfo = new PageInfo<>(employeeList);
        return Msg.success().add("pageInfo", pageInfo);
    }

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveEmp(Employee emp){
        employeeService.insertEmployee(emp);
        return Msg.success();
    }

}
