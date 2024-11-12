import { Component } from '@angular/core';
import { timestamp } from 'rxjs';
import { format } from 'date-fns';

export interface Attendance{
  id: number;
  entrance : string;
  leaving : string; 
  day: string; 
  holidays: boolean; 
  permits :number; 
  in :string; 
  out : string;

}

@Component({
  selector: 'app-dipendente',
  templateUrl: './dipendente.component.html',
  styleUrl: './dipendente.component.css'
})
export class DipendenteComponent {


  orari : Attendance[] =[
      {id: 1, entrance : "8:00", leaving : "18:00", day: "11/11/2024", holidays : false, permits : 2 , in : "8:00", out : "16:00"},
      {id: 2, entrance : "9:00", leaving : "18:00", day: "12/11/2024", holidays : true , permits : 0, in : "8:00", out : "18:00"},
      {id: 3, entrance : "8:00", leaving : "18:00", day: "13/11/2024", holidays : false, permits : 0, in : "8:00", out : "18:00"},
      {id: 4, entrance : "8:00", leaving : "18:00", day: "14/11/2024", holidays : false, permits : 0, in : "8:00", out : "18:00"},
      {id: 5, entrance : "8:00", leaving : "18:00", day: "15/11/2024", holidays : false, permits : 0, in : "", out : ""},
      {id: 6, entrance : "8:00", leaving : "18:00", day: "16/11/2024", holidays : false, permits : 0, in : "", out : ""},
      {id: 7, entrance : "8:00", leaving : "18:00", day: "17/11/2024", holidays : true, permits : 0, in : "", out : ""},
    ];
  
    // Tabella orari
    displayedColumns: string[] = ['day', 'schedule', 'entrance', 'leaving', 'holidays', 'permit'];
    selectedRow: Attendance =  {id: 0, entrance : "", leaving : "", day: "", holidays : false, permits : 0 , in : "", out : ""};



    // Bottoni di timbratura
    stampEntry(){
      
      // const now = new Date();
      // const timestamp = now.getTime();
      // const formattedDate = now.toLocaleString();
      const now = new Date();
      const formattedDate = format(now, 'HH:mm:ss');
      this.selectedRow.in=formattedDate;
    }

    stampExit(){
      const now = new Date();
      const formattedTime = format(now, 'HH:mm:ss');
      this.selectedRow.out=formattedTime;
    }


}
