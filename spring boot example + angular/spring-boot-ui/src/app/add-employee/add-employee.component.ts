import { Component, OnInit } from '@angular/core';
import { Employee } from '../model/employee';
import { EmployeeService } from '../services/employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.scss']
})
export class AddEmployeeComponent implements OnInit {

  constructor(public employeeService:EmployeeService, private route:Router) { }
  employee:Employee=new Employee();
  ngOnInit() {

  }
  save(){
    this.employeeService.save(this.employee).subscribe(data=>{
      console.info(data);
      this.route.navigateByUrl('manage-employee');
    });
  }
}
