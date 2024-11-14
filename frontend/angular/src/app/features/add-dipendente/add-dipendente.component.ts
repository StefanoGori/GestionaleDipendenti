import { Component } from '@angular/core';


@Component({
  selector: 'app-add-dipendente',
  templateUrl: './add-dipendente.component.html',
  styleUrl: './add-dipendente.component.css'
})
export class AddDipendenteComponent {
  name: string="";
  surname: string="";
  cf: string="";
  pwd: string="";
  holidays: number=0;
  permits: number=0;
  admin: boolean=false;



}
