import { Component, inject, Inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import { time } from 'console';

@Component({
  selector: 'app-permits',
  templateUrl: './permits.component.html',
  styleUrl: './permits.component.css'
})
export class PermitsComponent {
  SelectHours: number | null = null;
  permitsForm!: FormGroup;
  isVisible:boolean = false;
  maxPermittedHours: number = 0;
  

  constructor(private fb: FormBuilder,
    public dialogRef: MatDialogRef<PermitsComponent>,
    @Inject(MAT_DIALOG_DATA) public data:any

  ){}

ngOnInit():void{
  this.permitsForm=this.fb.group({
    SelectHours: [null, Validators.required]
  })

  if(this.data?.permits!==undefined){
    this.permitsForm.get('SelectHours')?.setValue(this.data.permits);
  }
}

open(){
  this.isVisible=true;
}

close(){
  this.isVisible=false;
}

onConfirm(){
  this.dialogRef.close(this.permitsForm.get('SelectHours')?.value);

}

onCancel(){
  this.permitsForm.get('SelectHours')?.setValue(null);
  this.dialogRef.close()
}

}
