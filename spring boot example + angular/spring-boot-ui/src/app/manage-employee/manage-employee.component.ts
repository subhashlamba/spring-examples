import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../services/employee.service';
import { Router, NavigationExtras } from '@angular/router';

@Component({
  selector: 'app-manage-employee',
  templateUrl: './manage-employee.component.html',
  styleUrls: ['./manage-employee.component.scss']
})
export class ManageEmployeeComponent implements OnInit {

  employees:any;


  ngOnInit() {
  }
  constructor(private employeeService:EmployeeService, private router:Router){
    this.loadEmployees();
 }
 loadEmployees(){
   this.employeeService.getEmployeeList().subscribe(employees=>{
     this.employees = employees;
 })
 }
 onDelete(id){
   this.employeeService.deleteEmployee(id).subscribe(data=>{
     alert('deleted success');
     this.loadEmployees();
   })
 }
 onEdit(employee){
  let navigationExtras: NavigationExtras = {
    queryParams: {
        "employeeId": employee.employeeId,
    }
};
   this.router.navigate(['edit-employee'],navigationExtras);
 }
}
