import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from '../services/employee.service';
import { Employee } from '../model/employee';

@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.scss']
})
export class EditEmployeeComponent implements OnInit {
  employee:Employee
  constructor(private route: ActivatedRoute, 
    private employeeService:EmployeeService,
    private router:Router) { 
    route.queryParams.subscribe(params=>{
      let employeeId  = params["employeeId"];
      this.employeeService.findById(employeeId).subscribe(employee=>{
        this.employee = employee;
      })
    })

  }
  update(){
    this.employeeService.update(this.employee).subscribe(data=>{
      alert('saved success');
      this.router.navigateByUrl('manage-employee');
    })
  }
  ngOnInit() {
  }

}
