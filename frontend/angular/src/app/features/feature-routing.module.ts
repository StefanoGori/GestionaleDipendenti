import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AdminComponent } from './admin/admin.component';
import { DipendenteComponent } from './dipendente/dipendente.component';


const routes: Routes = [
    {
        path:'',
        pathMatch: 'full',
        redirectTo:'login'
    },
    {
        path: 'login',
        component: LoginComponent,
    },
    {
        path: 'admin',
        component: AdminComponent,
    },
    {
        path: 'dipendente',
        component: DipendenteComponent
    }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FeatureRoutingModule { }