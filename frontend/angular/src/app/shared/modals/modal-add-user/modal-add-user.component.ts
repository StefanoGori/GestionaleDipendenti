import { Component, inject } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-modal-add-user',
  templateUrl: './modal-add-user.component.html',
  styleUrl: './modal-add-user.component.css'
})
export class ModalAddUserComponent {

  dialogref= inject(MatDialogRef);

  formModal= new FormGroup({
    cf : new FormControl('', [Validators.required]),
    name : new FormControl('', [Validators.required]),
    surname : new FormControl('',  [Validators.required]),
    admin : new FormControl('', [Validators.required]),
    holidays : new FormControl('', [Validators.required]),
    permits : new FormControl('', [Validators.required]),
    pwd : new FormControl('', [Validators.required]),
  })

  onSubmit(){
    if(this.formModal.invalid){return console.log("Errore durante l'aggiunta")}
    this.dialogref.close(this.formModal.value);  }

}
