import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PagesComponent } from 'src/app/pages/pages.component';
import { ProveedorComponent } from './modulos/proveedor/proveedor.component';

const routes: Routes = [
  {
    path:'',
    component: PagesComponent,
    children: [
      {path:'', component:ProveedorComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
