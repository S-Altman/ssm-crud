package com.ssm.crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.crud.domain.Employee;
import com.ssm.crud.domain.Msg;
import com.ssm.crud.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
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
    public Msg saveEmp(@Valid Employee emp, BindingResult result){
        if (result.hasErrors()){
            List<FieldError> errors = result.getFieldErrors();
            HashMap<String, Object> map = new HashMap<>(errors.size());
            errors.forEach(error -> {
                System.out.println("错误的字段名：" + error.getField());
                System.out.println("错误信息：" + error.getDefaultMessage());
                map.put(error.getField(), error.getDefaultMessage());
            });
            return Msg.fail().add("errorFields", map);
        }else{
            employeeService.insertEmployee(emp);
            return Msg.success();
        }
    }

    @RequestMapping("/checkemp")
    @ResponseBody
    public Msg checkEmp(String empName){
        //先判断用户名是否是合法的表达式;
        String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
        if(!empName.matches(regx)){
            return Msg.fail().add("va_msg", "用户名必须是6-16位数字和字母的组合或者2-5位中文");
        }

        //数据库用户名重复校验
        boolean checkEmp = employeeService.checkEmp(empName);
        if(checkEmp){
            return Msg.success();
        }else{
            return Msg.fail().add("va_msg", "用户名已存在");
        }
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getEmp(@PathVariable("id") Integer id){
        Employee employee = employeeService.getEmployeeById(id);
        return Msg.success().add("emp", employee);
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Msg updateEmp(Employee employee){
        employeeService.updateEmployeeWithoutName(employee);
        System.out.println(employee);
        return Msg.success().add("emp", employee);
    }


}
