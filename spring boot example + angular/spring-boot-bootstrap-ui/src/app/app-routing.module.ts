import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ManageEmployeeComponent } from './manage-employee/manage-employee.component';
import { EditEmployeeComponent } from './edit-employee/edit-employee.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';

const routes: Routes = [{ path: 'manage-employee', component: ManageEmployeeComponent },
                        {path:'edit-employee',component:EditEmployeeComponent},
                        {path:'add-employee',component:AddEmployeeComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
