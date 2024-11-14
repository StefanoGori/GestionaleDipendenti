import { Component, inject, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTable, MatTableDataSource } from '@angular/material/table';
import { UserService } from '../../core/service/user.service';
import { DipendenteComponent } from '../dipendente/dipendente.component';
import { async, filter, toArray } from 'rxjs';
import { User } from '../../core/models/user.models';
import { AddDipendenteComponent } from '../add-dipendente/add-dipendente.component';
import { MatDialog } from '@angular/material/dialog';
import { DeleteDipendenteComponent } from '../delete-dipendente/delete-dipendente.component';
import { EditDipendenteComponent } from '../edit-dipendente/edit-dipendente.component';
import { TimeTableService } from '../../core/service/timetable.service';


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent {
    constructor(public dialog: MatDialog) { }
    name: string="";
    surname: string="";
    userService=inject(UserService);
    timeTableService=inject(TimeTableService);
    users$=this.userService.allUsers;

    displayedColumns: string[] = ['cf', 'name', 'surname', 'daysoff', 'permits', 'edit'];

    //Paginator
    pageSize=3;
    pageIndex=0;
    pageSizeOptions=[5,10,25,100];

    dataSource = new MatTableDataSource();
    ngOnInit(){
      this.users$.subscribe({
        next: (value)=>{this.dataSource.data=value}
      });
   
    }

    @ViewChild(MatPaginator) paginator!: MatPaginator;

    ngAfterViewInit(){
      this.dataSource.paginator = this.paginator;
    }

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

    searchDipendente(name:string, surname:string){
      // this.isSearchPerformed = true;
      // this.filteredDipendente = this.users$.pipe(
      //   filter((user:User)=>user.name.toLowerCase()===name.toLowerCase() && user.surname.toLowerCase()===surname.toLowerCase())
      // )
    }

    resetSearch(){
      this.isSearchPerformed = false;
    }

    //aggiunta dipendente
    openAddDipendente(){
      const dialogRef=this.dialog.open(AddDipendenteComponent,{
        width: '500px',
        height: '250px'
      });
      dialogRef.afterClosed().subscribe(result=>{
      });
    }

    openDeleteDipendente(){
      const dialogRef=this.dialog.open(DeleteDipendenteComponent,{
        width: '500px',
        height: '250px'
      });
      dialogRef.afterClosed().subscribe(result=>{
      });
    }

    openEditDipendente(){
      const dialogRef=this.dialog.open(EditDipendenteComponent,{
        width: '500px',
        height: '250px'
      });
      dialogRef.afterClosed().subscribe(result=>{
      });
    }
}
