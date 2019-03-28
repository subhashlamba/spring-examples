import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subscribable, Observable } from 'rxjs';
import { Employee } from '../model/employee';
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) { 
    
  }
  public save(employee:Employee):Observable<any>{
    return this.http.post('http://localhost:8080/save',employee);
  }
  public update(employee:Employee):Observable<any>{
    return this.http.post('http://localhost:8080/update',employee);
  }
  public getEmployeeList():Observable<any>{
    return this.http.get('http://localhost:8080/list');
  }
  public deleteEmployee(employeeId:number):Observable<any>{
    return this.http.delete(`http://localhost:8080/delete?id=${employeeId}`)
  }
  public findById(employeeId:number):Observable<any>{
    return this.http.get(`http://localhost:8080/findById?id=${employeeId}`)
  }
}
