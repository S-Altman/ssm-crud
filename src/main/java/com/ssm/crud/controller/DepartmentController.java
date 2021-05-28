package com.ssm.crud.controller;

import com.ssm.crud.domain.Department;
import com.ssm.crud.domain.Msg;
import com.ssm.crud.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("/depts")
    @ResponseBody
    public Msg listDepts(){
        List<Department> depts = departmentService.listDepartments();
        return Msg.success().add("depts", depts);
    }
}
