import { Component, inject, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTable, MatTableDataSource } from '@angular/material/table';
import { UserService } from '../../core/service/user.service';
import { DipendenteComponent } from '../dipendente/dipendente.component';
import { toArray } from 'rxjs';


export interface Dipendenti {
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
    name: string="";
    surname: string="";
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
    userService=inject(UserService);
    users$=this.userService.allUsers;

    displayedColumns: string[] = ['cf', 'name', 'surname', 'daysoff', 'permits'];

    //Paginator
    pageSize=10;
    pageIndex=0;
    pageSizeOptions=[5,10,25,100];

    dataSource = new MatTableDataSource<Dipendenti>(this.dipendenti);

    ngOnInit(){
      console.log(this.users$);
    }

    @ViewChild(MatPaginator) paginator!: MatPaginator;

    ngAfterViewInit(){
      this.dataSource.paginator = this.paginator;
    }

    onPageChange(event: any):void{
      this.pageIndex = event.pageIndex;
      this.pageSize = event.pageSize;
    }

    filteredDipendente: any;
    isSearchPerformed: boolean = false;

    searchDipendente() {
      this.isSearchPerformed = true;
      this.filteredDipendente = this.dipendenti.filter((dipendente) => {
        
        return (
          dipendente.name.toLowerCase() === this.name.toLowerCase() &&
          dipendente.surname.toLowerCase() === this.surname.toLowerCase()
        );
        
      });
      console.log(this.filteredDipendente);
    }

    resetSearch(){
      this.isSearchPerformed = false;
    }
}
