import { Component, inject } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-delete-dipendente',
  templateUrl: './delete-dipendente.component.html',
  styleUrl: './delete-dipendente.component.css'
})
export class DeleteDipendenteComponent {
  dialogRef= inject(MatDialogRef);
  check : boolean = true;

  goAction(newstate : boolean){
    this.check = newstate;
    this.dialogRef.close(this.check);
  }
}
