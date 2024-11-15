import { Component, inject, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTable, MatTableDataSource } from '@angular/material/table';
import { UserService } from '../../core/service/user.service';
import { DipendenteComponent } from '../dipendente/dipendente.component';
import { async, BehaviorSubject, combineLatestWith, filter, map, toArray } from 'rxjs';
import { User } from '../../core/models/user.models';
import { ModalNewUserComponent } from '../modal-new-user/modal-new-user.component';
import { MatDialog } from '@angular/material/dialog';
import { DeleteDipendenteComponent } from '../delete-dipendente/delete-dipendente.component';
import { TimeTableService } from '../../core/service/timetable.service';
import { FormControl, FormGroup } from '@angular/forms';
import { ScheduleModalComponent } from '../schedule-modal/schedule-modal.component';


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent {
    constructor(public dialog: MatDialog) { }
    inputname: string="";
    inputsurname: string="";
    userService=inject(UserService);
    timeTableService=inject(TimeTableService);
    users$=this.userService.allUsers;
    currentUser: null | User =null;

    currentDipendente : null | string= null;
    
    displayedColumns: string[] = ['cf', 'name', 'surname', 'daysoff', 'permits', 'edit'];

    //Paginator
    pageSize=5;
    pageIndex=0;
    pageSizeOptions=[5,10,25,100];

    dataSource = new MatTableDataSource();
    ngOnInit(){
      this.users$.pipe(toArray()).subscribe({
        next: (users)=>{
          this.dataSource.data=users;
          this.dataSource.paginator = this.paginator;
        },
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

    // searchDipendente(inputname:string, inputsurname:string){
    //   this.isSearchPerformed = true;
    //   this.filteredDipendente = this.users$.pipe(
    //     map(users => users.filter((user)=>
    //       user.name?.toLowerCase().includes(inputname.toLowerCase()) && 
    //       user.surname?.toLowerCase().includes(inputsurname.toLowerCase())
    //   )));
    // }

    resetSearch(){
      this.isSearchPerformed = false;
    }

    //aggiunta dipendente
    AddDipendente(){
      const dialogRef=this.dialog.open(ModalNewUserComponent,{
        width: '900px',
        height: 'auto'
      });
      dialogRef.afterClosed().subscribe({
        next: (result) => result ? this.userService.addUser(result) : null,
      });
    }

    // modificare un dipendente
    EditDipendente(user : User){
      const dialogRef=this.dialog.open(ModalNewUserComponent,{
        width: '900px',
        height: 'auto',
        data: user
      });
      dialogRef.afterClosed().subscribe({
        next: (result) => result ? this.userService.editUser(result) : null,
      });
    }   

    //eliminare un dipendente
    DeleteDipendente(cf : string){
      const dialogRef=this.dialog.open(DeleteDipendenteComponent,{
        width: '500px',
        height: '250px'
      });
      dialogRef.afterClosed().subscribe({
        next: (result) => result ? this.userService.deleteUser(cf) : null,
      });
    }

    ShowScheduleDipendente(user: User){
      console.log(user)
      this.currentDipendente=user.cf;

    }

    back(){
      this.currentDipendente=null;
    }

    addSchedule(cf :string){
      
      this.userService.getUser(cf).subscribe(
        (value) => {
          this.currentUser=value;
          this.dialog.open(ScheduleModalComponent,{
            width: '900px',
            height: 'auto',
            data: value
          }).afterClosed().subscribe({
            next: (result) => result ? this.timeTableService.addTimeTable(result, value) : null,
          });

        }
      );

      
    }
}
