import { NgModule } from '@angular/core';
import {CommonModule } from '@angular/common';
import {MatIconModule} from '@angular/material/icon';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {MatListModule} from '@angular/material/list';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatInputModule} from '@angular/material/input';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatTableModule} from '@angular/material/table';
import {MatCardModule} from '@angular/material/card';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import { MatDialogActions, MatDialogContent } from '@angular/material/dialog';
import {MatDatepickerModule} from '@angular/material/datepicker';






@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MatToolbarModule, 
    MatIconModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatListModule,
    MatCheckboxModule,
    MatInputModule,
    MatSnackBarModule,
    MatFormFieldModule,
    MatGridListModule,
    MatTableModule,
    MatCardModule,
    MatSlideToggleModule,
    MatDialogContent,
    MatDialogActions,
    MatDatepickerModule
  ],
  exports: [
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatListModule,
    MatCheckboxModule,
    MatInputModule,
    MatSnackBarModule,
    MatFormFieldModule,
    MatGridListModule,
    MatTableModule,
    MatCardModule,
    MatSlideToggleModule,
    MatDialogContent,
    MatDialogActions,
    MatDatepickerModule
  ],
})
export class MaterialModule { }
