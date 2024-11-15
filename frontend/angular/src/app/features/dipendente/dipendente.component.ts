import { Component, ViewChild, AfterViewInit, inject } from '@angular/core';
import { timestamp } from 'rxjs';
import { format } from 'date-fns';
import { MatDialog } from '@angular/material/dialog';
import { HolidaysComponent } from '../holidays/holidays.component';
import { PermitsComponent } from '../permits/permits.component';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { TimeTableService } from '../../core/service/timetable.service';
import { UserService } from '../../core/service/user.service';

export interface timeTable{
  id: number;
  entrance : string;
  leaving : string; 
  day: string; 
  holiday: boolean; 
  permits :number; 
  stamped_in :string; 
  stamped_out : string;

}

@Component({
  selector: 'app-dipendente',
  templateUrl: './dipendente.component.html',
  styleUrl: './dipendente.component.css'
})
export class DipendenteComponent implements AfterViewInit{

  constructor(public dialog: MatDialog) { }
  timeTableService=inject(TimeTableService);
  userService=inject(UserService);
  timeTable$=this.timeTableService.allTimeTables;

  //inizializzo il dataSource con tutti gli orari
  dataSource=new MatTableDataSource();
  ngOnInit(){
    this.timeTable$.subscribe({
      next: (value)=>{
        this.dataSource.data=value;
      }, error: (error)=> console.error("Errore:",error)
    });
  }
  
    // Tabella orari
    displayedColumns: string[] = ['day', 'schedule', 'entrance', 'leaving', 'holidays', 'permit'];
    selectedRow: timeTable =  {id: 0, entrance : "", leaving : "", day: "", holiday : false, permits : 0 , stamped_in : "", stamped_out : ""};
    
    
    //paginator
    pageSize = 7;
    pageIndex = 0;

    
    

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

    trackByRow(index: number,row: timeTable): number{
      return row.id;
    }

    // Bottoni di timbratura
    stampEntry(){
      
      // const now = new Date();
      // const timestamp = now.getTime();
      // const formattedDate = now.toLocaleString();
      const now = new Date();
      const formattedDate = format(now, 'HH:mm:ss');
      this.selectedRow.stamped_in=formattedDate;
      console.log("Entrata timbrata alle: ", formattedDate);
      this.timeTableService.editStamped_in(this.selectedRow.id, this.selectedRow.stamped_in);
    }

    stampExit(){
      const now = new Date();
      const formattedTime = format(now, 'HH:mm:ss');
      this.selectedRow.stamped_out=formattedTime;
      console.log("Uscita timbrata alle: ", formattedTime);
      this.timeTableService.editStamped_out(this.selectedRow.id, this.selectedRow.stamped_out);
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
          this.selectedRow.holiday = true;
          this.timeTableService.editHoliday(this.selectedRow.id, this.selectedRow.holiday);
          console.log("ferie aggiunte");
        }else{
            console.log("ferie non aggiunte");
        }
        
    });
  }

  onConfirm(): void{
    if (this.selectedRow) {
      this.selectedRow.holiday = true;  // Modifica la proprietà delle ferie
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
      this.timeTableService.editUsedpermits(this.selectedRow.id, this.selectedRow.permits);
      console.log("permessi aggiunti: ", this.selectedRow.permits);
    }else{
      console.log("permessi non aggiunti");
    }
  });
}

}
