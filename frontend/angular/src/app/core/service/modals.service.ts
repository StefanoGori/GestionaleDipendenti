import { ComponentType } from '@angular/cdk/portal';
import { inject, Injectable } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';

@Injectable({
  providedIn: 'root'
})
export class ModalsService {
  #dialogService = inject(MatDialog)

  openModal(component: ComponentType<unknown>, data:any=null){
    return this.#dialogService.open(component, {
      width: '900px',
      height: 'auto',
      data
    }).afterClosed();
  }
  constructor() { }
}
