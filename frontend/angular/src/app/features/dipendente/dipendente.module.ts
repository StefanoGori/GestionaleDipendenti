import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DipendenteComponent } from './dipendente.component';
import { SharedModule } from '../../shared/shared.module';



@NgModule({
  declarations: [DipendenteComponent],
  imports: [
    CommonModule,
    SharedModule,
  ]
})
export class DipendenteModule { }
