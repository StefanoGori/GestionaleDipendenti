import { Component, inject } from '@angular/core';
import { UserService } from '../../core/service/user.service';
import { MatDialogRef } from '@angular/material/dialog';
import { FormControl, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-add-dipendente',
  templateUrl: './add-dipendente.component.html',
  styleUrl: './add-dipendente.component.css'
})
export class AddDipendenteComponent {
  dialogRef= inject(MatDialogRef);

  formModal= new FormGroup({
    cf : new FormControl('', [Validators.required, Validators.minLength(16), Validators.maxLength(16) ]),
    name : new FormControl('', [Validators.required]),
    surname : new FormControl('',  [Validators.required]),
    admin : new FormControl(false, []),
    holidays : new FormControl(0, [Validators.required, Validators.min(0)]),
    permits : new FormControl(0, [Validators.required, Validators.min(0)]),
    pwd : new FormControl('', [Validators.required]),
  })

  onSubmit(){
    if(this.formModal.invalid){ return console.log("Errore nell'aggiunta")}
    console.log(this.formModal.value);
    this.dialogRef.close(this.formModal.value);
  }

  closeModal(){
    this.dialogRef.close();
  }
}