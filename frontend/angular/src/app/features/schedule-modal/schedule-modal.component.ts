import { Component, inject } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { TimeTableService } from '../../core/service/timetable.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MAT_DATE_LOCALE, provideNativeDateAdapter } from '@angular/material/core';

@Component({
  selector: 'app-schedule-modal',
  templateUrl: './schedule-modal.component.html',
  styleUrl: './schedule-modal.component.css',
  providers: [provideNativeDateAdapter(),{provide: MAT_DATE_LOCALE, useValue: 'it-It'}],
})
export class ScheduleModalComponent {
 
  dialogRef= inject(MatDialogRef);
  timeService = inject(TimeTableService);

  formModalSchedule= new FormGroup({
    day : new FormControl("", [Validators.required]),
    entrance : new FormControl("", [Validators.required]),
    leaving : new FormControl("", [Validators.required]),
  })

  onSubmit(){
    console.log(this.formModalSchedule.controls.day);
    if(this.formModalSchedule.invalid){ return console.log("Errore nell'aggiunta")}
    this.dialogRef.close(this.formModalSchedule.value);
  }

  closeModal(){
    this.dialogRef.close();
  }

}
