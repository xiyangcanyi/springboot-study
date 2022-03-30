package com.zyp.springboot04web.controller;

import com.zyp.springboot04web.dao.DepartmentDao;
import com.zyp.springboot04web.dao.EmployeeDao;
import com.zyp.springboot04web.pojo.Department;
import com.zyp.springboot04web.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
     EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    public String list(Model model){
       Collection<Employee> employees=employeeDao.getAll();
       model.addAttribute("emps",employees);
        return "emp/list";
    }
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }
}
