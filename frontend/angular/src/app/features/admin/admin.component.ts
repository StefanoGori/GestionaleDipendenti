import { Component } from '@angular/core';

export interface Dipendenti{
  cf: string;
  name: string;
  surname: string;
  daysoff: number;
  permits: number;
}

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent {
  
    constructor() { }

    dipendenti: Dipendenti[] = [
      {cf: "CF1", name: "Name1", surname: "Surname1", daysoff: 0, permits: 0},
      {cf: "CF2", name: "Name2", surname: "Surname2", daysoff: 0, permits: 0},
      {cf: "CF3", name: "Name3", surname: "Surname3", daysoff: 0, permits: 0},
      {cf: "CF4", name: "Name4", surname: "Surname4", daysoff: 0, permits: 0},
      {cf: "CF5", name: "Name5", surname: "Surname5", daysoff: 0, permits: 0},
      {cf: "CF6", name: "Name6", surname: "Surname6", daysoff: 0, permits: 0},
      {cf: "CF7", name: "Name7", surname: "Surname7", daysoff: 0, permits: 0},
      {cf: "CF8", name: "Name8", surname: "Surname8", daysoff: 0, permits: 0},
    ];

    displayedColumns: string[] = ['cf', 'name', 'surname', 'daysoff', 'permits'];
    dataSource = this.dipendenti;
}
