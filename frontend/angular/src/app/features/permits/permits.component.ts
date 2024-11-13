import { Component, Inject } from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-permits',
  templateUrl: './permits.component.html',
  styleUrl: './permits.component.css'
})
export class PermitsComponent {
  SelectHours: number | null =null;

  constructor(
    public dialogRef: MatDialogRef<PermitsComponent>,
    @Inject(MAT_DIALOG_DATA) public data: {permits: number}
  ) { 
    this.SelectHours = data.permits || null;
  }

  onConfirm(): void{
    console.log(this.SelectHours);
    this.dialogRef.close(this.SelectHours);
  }

  onCancel():void{
    this.dialogRef.close();
  }

}
