import { Component } from '@angular/core';


@Component({
  selector: 'app-tabellaorari',
  templateUrl: './tabellaorari.component.html',
  styleUrl: './tabellaorari.component.css'
})


export class TabellaorariComponent {
  

  displayedColumns: string[] = ['day', 'schedule', 'entrance', 'leaving', 'holidays', 'permit'];
orari =[
    {id: "1", entrance : "8:00", leaving : "18:00", day: "11/11/2024", holidays : "x", permits : 2, in : "8:00", out : "16:00"},
    {id: "2", entrance : " ", leaving : " ", day: "12/11/2024", holidays : "V", permits : "2:00", in : "8:00", out : "18:00"},
    {id: "3", entrance : "8:00", leaving : "18:00", day: "13/11/2024", holidays : "x", permits : "2:00", in : "8:00", out : "18:00"},
    {id: "4", entrance : "8:00", leaving : "18:00", day: "14/11/2024", holidays : "x", permits : "2:00", in : "8:00", out : "18:00"},
    {id: "5", entrance : "8:00", leaving : "18:00", day: "15/11/2024", holidays : "x", permits : "2:00", in : "8:00", out : "18:00"},
    {id: "6", entrance : "8:00", leaving : "18:00", day: "16/11/2024", holidays : "x", permits : "2:00", in : "8:00", out : "18:00"},
    {id: "7", entrance : "8:00", leaving : "18:00", day: "17/11/2024", holidays : "x", permits : "2:00", in : "8:00", out : "18:00"},
  ];
    
  

  
  
}
