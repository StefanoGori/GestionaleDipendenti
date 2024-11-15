import { Component, Inject, inject } from '@angular/core';
import { UserService } from '../../core/service/user.service';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { User } from '../../core/models/user.models';
import { MAT_DATE_LOCALE, provideNativeDateAdapter } from '@angular/material/core';


@Component({
  selector: 'app-modal-new-user',
  templateUrl: './modal-new-user.component.html',
  styleUrl: './modal-new-user.component.css',
  providers: [provideNativeDateAdapter(),{provide: MAT_DATE_LOCALE, useValue: 'it-It'},]
})
export class ModalNewUserComponent {
  dialogRef= inject(MatDialogRef);
  userService = inject(UserService);

  formModal= new FormGroup({
    cf : new FormControl('', [Validators.required, Validators.minLength(16), Validators.maxLength(16)]),
    name : new FormControl('', [Validators.required]),
    surname : new FormControl('',  [Validators.required]),
    admin : new FormControl(false, []),
    holidays : new FormControl(0, [Validators.required, Validators.min(0)]),
    permits : new FormControl(0, [Validators.required, Validators.min(0)]),
    password : new FormControl('', [Validators.required]),
  })


  constructor(@Inject(MAT_DIALOG_DATA) public data: {user: User}) {
    if(data?.user) {
      this.formModal.patchValue(data.user);
    }
  }

  ngOnInit() {
    // Check if user data is present in the dialog data
    if (this.data?.user) {
      this.formModal.controls.cf.setValue(this.data.user.cf);
    }
  }

  onSubmit(){
    if(this.formModal.invalid){ return console.log("Errore nell'aggiunta")}
    this.dialogRef.close(this.formModal.value);
  }

  closeModal(){
    this.dialogRef.close();
  }

  save() {
    if(this.data?.user){
      this.dialogRef.close({id: this.data.user.cf, ...this.formModal.value});
    }else{
      this.dialogRef.close(this.formModal.value)
    }
  }
}