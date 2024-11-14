import { Component, inject } from '@angular/core';
import { UserService } from '../../core/service/user.service';


@Component({
  selector: 'app-add-dipendente',
  templateUrl: './add-dipendente.component.html',
  styleUrl: './add-dipendente.component.css'
})
export class AddDipendenteComponent {
  userService=inject(UserService);
  name: string="";
  surname: string="";
  cf: string="";
  pwd: string="";
  holidays: number=0;
  permits: number=0;
  admin: boolean=false;

  addDipendente(){
    this.userService.addUser(this.cf, this.name, this.surname, this.pwd, this.holidays, this.permits, this.admin);
  }

}
