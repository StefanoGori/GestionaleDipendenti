import { Component, inject } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  #router=inject(Router);
  #route=inject(ActivatedRoute);
  constructor(){
    console.log(this.#route.snapshot.data);
  }

  login():void{
    this.#router.navigate(['/admin']);
  }
}
