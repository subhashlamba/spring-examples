package com.javadeveloperzone.controller;

import com.javadeveloperzone.model.Employee;
import com.javadeveloperzone.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
/**
 * Created by JavaDeveloperZone on 19-07-2017.
 */
@RestController     // for rest response
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // to add new employee
    @RequestMapping(value = "save",method = RequestMethod.POST)     // or user @GetMapping
    public Employee save(Employee employee){
        return employeeService.save(employee);
    }

    // list of all employee
    @RequestMapping(value = "listEmployee",method = RequestMethod.GET)   // or use @GetMapping
    public java.util.List<Employee> listEmployee() {
        return employeeService.findAll();
    }

    // delete specific employee using employee id
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)        // or use @DeleteMapping
    public void delete(@RequestParam("id")long id){
         employeeService.delete(id);
    }

    // search employee start with name
    @RequestMapping(value = "startWithName/{name}")
    public java.util.List<Employee> findByName(@PathVariable("name")String name){
        return employeeService.findEmployeeByEmployeeNameStartingWith(name);
    }

    // search employee by role
    @RequestMapping(value = "findByRole/{role}")
    public java.util.List<Employee> findByRole(@PathVariable("role")String role){
        return employeeService.findEmployeeByEmployeeRole(role);
    }

    @RequestMapping(value = "/query")
    public java.util.List<Employee> test(){
        //return employeeService.findByCriteria("Jone");
        // return employeeService.findByCriteria("Jo","ADMIN");
        // return  employeeService.findByLikeCriteria("info");
        // return employeeService.findByLikeAndBetweenCriteria(null,0,0);
        return  employeeService.findByPagingCriteria("Jone", new PageRequest(0,10));
    }
}
