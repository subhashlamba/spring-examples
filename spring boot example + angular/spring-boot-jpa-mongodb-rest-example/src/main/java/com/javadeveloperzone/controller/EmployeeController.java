package com.javadeveloperzone.controller;

import com.javadeveloperzone.model.Employee;
import com.javadeveloperzone.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * Created by JavaDeveloperZone on 19-07-2017.
 */
@RestController     // for rest response
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // to add new employee
    @RequestMapping(value = "save",method = RequestMethod.POST)     // or user @GetMapping
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    // to update employee
    @RequestMapping(value = "update",method = RequestMethod.POST)     // or user @GetMapping
    public Employee update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

    // list of all employee
    @RequestMapping(value = "findById",method = RequestMethod.GET)   // or use @GetMapping
    public Employee findById(@RequestParam String id) {
        return employeeService.findByEmployeeId(id);
    }


    // list of all employee
    @RequestMapping(value = "list",method = RequestMethod.GET)   // or use @GetMapping
    public java.util.List<Employee> listEmployee() {
        return employeeService.findAll();
    }

    // delete specific employee using employee id
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)        // or use @DeleteMapping
    public void delete(@RequestParam("id")String id){
         employeeService.delete(id);
    }
}
