import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { ModalAddUserComponent } from './modal-add-user/modal-add-user.component';
import { SharedModule } from '../shared.module';



@NgModule({
  declarations: [ModalAddUserComponent],
  imports: [
    CommonModule,
    SharedModule,
    ReactiveFormsModule
  ],
  exports : [SharedModule]
})
export class ModalsModule { }
