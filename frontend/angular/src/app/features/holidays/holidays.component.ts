import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-holidays',
  templateUrl: './holidays.component.html',
  styleUrl: './holidays.component.css'
})
export class HolidaysComponent {
  
    constructor(
      public dialogRef: MatDialogRef<HolidaysComponent>
    ) { }
  
    onConfirm(): void{
      this.dialogRef.close('yes');
    }

    onCancel():void{
      this.dialogRef.close('no');

    }
}
