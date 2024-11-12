import { Component } from '@angular/core';
import {MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-permits',
  templateUrl: './permits.component.html',
  styleUrl: './permits.component.css'
})
export class PermitsComponent {

  constructor(
    public dialogRef: MatDialogRef<PermitsComponent>
  ) { }

  

}
