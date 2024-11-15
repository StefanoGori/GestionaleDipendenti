import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialModule } from './material.module';
import {MatSelectModule } from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatTabsModule } from '@angular/material/tabs';
import { ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [
  
  ],
  imports: [
    CommonModule, 
    MaterialModule,
    MatFormFieldModule,
    MatSelectModule,
    FormsModule,
    MatPaginatorModule,
    MatTabsModule,
    ReactiveFormsModule

  ],
  exports: [
    MaterialModule,
    MatFormFieldModule,
    MatSelectModule,
    FormsModule,
    MatPaginatorModule,
    MatTabsModule,
    ReactiveFormsModule
  ],
})
export class SharedModule { }
