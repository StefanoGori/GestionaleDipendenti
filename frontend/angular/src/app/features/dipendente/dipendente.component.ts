import { Component, ViewChild, AfterViewInit } from '@angular/core';
import { timestamp } from 'rxjs';
import { format } from 'date-fns';
import { MatDialog } from '@angular/material/dialog';
import { HolidaysComponent } from '../holidays/holidays.component';
import { PermitsComponent } from '../permits/permits.component';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

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
export class DipendenteComponent implements AfterViewInit{

  constructor(public dialog: MatDialog) { }

  orari : Attendance[] =[
      {id: 1, entrance : "8:00", leaving : "18:00", day: "11/11/2024", holidays : false, permits : 2 , in : "8:00", out : "16:00"},
      {id: 2, entrance : "9:00", leaving : "18:00", day: "12/11/2024", holidays : true , permits : 0, in : "8:00", out : "18:00"},
      {id: 3, entrance : "8:00", leaving : "18:00", day: "13/11/2024", holidays : false, permits : 0, in : "8:00", out : "18:00"},
      {id: 4, entrance : "8:00", leaving : "18:00", day: "14/11/2024", holidays : false, permits : 0, in : "8:00", out : "18:00"},
      {id: 5, entrance : "8:00", leaving : "18:00", day: "15/11/2024", holidays : false, permits : 0, in : "", out : ""},
      {id: 6, entrance : "8:00", leaving : "18:00", day: "16/11/2024", holidays : false, permits : 0, in : "", out : ""},
      {id: 7, entrance : "8:00", leaving : "18:00", day: "17/11/2024", holidays : true, permits : 0, in : "", out : ""},
      {id: 8, entrance : "8:00", leaving : "18:00", day: "18/11/2024", holidays : false, permits : 0, in : "", out : ""},
    ];
  
    // Tabella orari
    displayedColumns: string[] = ['day', 'schedule', 'entrance', 'leaving', 'holidays', 'permit'];
    selectedRow: Attendance =  {id: 0, entrance : "", leaving : "", day: "", holidays : false, permits : 0 , in : "", out : ""};


    //paginator
    pageSize = 7;
    pageIndex = 0;

    //inizializzo il dataSource con tutti gli orari
    dataSource=new MatTableDataSource<Attendance>(this.orari);

    //faccio riferimento al paginator
    @ViewChild(MatPaginator) paginator!: MatPaginator;

    //dopo la visualizzazione collega il paginator al dataSource
    ngAfterViewInit(){
      this.dataSource.paginator = this.paginator;
    }

    //metodo per gestire i cambiamenti della pagina
    onPageChange(event:any):void{
      this.pageIndex = event.pageIndex;
      this.pageSize = event.pageSize;
    }



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
    

    // Dialog per aggiungere ferie

    openHolidayDialog(){
      console.log("openHolidayDialog");
      const dialogRef = this.dialog.open(HolidaysComponent, {
        width: '500px',
        height: '250px',
        data:{day: this.selectedRow.day}
      });

      dialogRef.afterClosed().subscribe(result => {
        if(result === 'yes'){
          this.selectedRow.holidays = true;
          console.log("ferie aggiunte");
        }else{
            console.log("ferie non aggiunte");
        }
        
    });
  }

  onConfirm(): void{
    if (this.selectedRow) {
      this.selectedRow.holidays = true;  // Modifica la proprietà delle ferie
      console.log('Ferite aggiunte per il giorno: ', this.selectedRow.day);
    }
  }

  onCancel(){
    console.log('Ferie non aggiunte');
  }

// Dialog per aggiungere permessi

openPermitsDialog(){
  console.log("openPermitsDialog");
  const dialogRef = this.dialog.open(PermitsComponent, {
    width: '500px',
    height: '250px',
    data:{permits: this.selectedRow.permits}
  });
  dialogRef.afterClosed().subscribe(result => {
    if(result!==null && result!==undefined){
      this.selectedRow.permits = result;
      console.log("permessi aggiunti: ", this.selectedRow.permits);
    }else{
      console.log("permessi non aggiunti");
    }
  });
}

}
