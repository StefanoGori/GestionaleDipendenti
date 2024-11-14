import { Component, inject, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTable, MatTableDataSource } from '@angular/material/table';
import { UserService } from '../../core/service/user.service';
import { DipendenteComponent } from '../dipendente/dipendente.component';
import { async, toArray } from 'rxjs';
import { User } from '../../core/models/user.models';


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent {
    constructor() { }
    name: string="";
    surname: string="";
    userService=inject(UserService);
    users$=this.userService.allUsers;

    displayedColumns: string[] = ['cf', 'name', 'surname', 'daysoff', 'permits'];

    //Paginator
    pageSize=10;
    pageIndex=0;
    pageSizeOptions=[5,10,25,100];

    dataSource = this.users$;

    ngOnInit(){
   
    }

    @ViewChild(MatPaginator) paginator!: MatPaginator;

    // ngAfterViewInit(){
    //   this.dataSource.paginator = this.paginator;
    // }

    onPageChange(event: any){
      this.pageIndex = event.pageIndex;
      this.pageSize = event.pageSize;
    }

    filteredDipendente: any;
    isSearchPerformed: boolean = false;

    // searchDipendente() {
    //   this.isSearchPerformed = true;
    //   this.filteredDipendente = this.dipendenti.filter((dipendente) => {
        
    //     return (
    //       dipendente.name.toLowerCase() === this.name.toLowerCase() &&
    //       dipendente.surname.toLowerCase() === this.surname.toLowerCase()
    //     );
        
    //   });
    //   console.log(this.filteredDipendente);
    // }

    resetSearch(){
      this.isSearchPerformed = false;
    }
}
