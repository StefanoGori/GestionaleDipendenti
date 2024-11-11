import { inject, Injectable } from '@angular/core';
import { User } from '../models/user.models';
import { BehaviorSubject } from 'rxjs';
import { PersistenceService } from './persistence.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  // private user = new BehaviorSubject<User[]>([]);

    private users: User[] = [
    {id:"1", name: "Mario", surname:"Rossi", email: "mariorossi@info.it", admin: false, holidays: 30, permission: 20, pwd: "qwerty"},
    {id:"2", name: "Luigi", surname:"Verdi", email: "luigiverdi@info.it", admin: true, holidays: 303, permission: 2, pwd: "qwerty1"},
    {id:"3", name: "Gigi", surname:"Giuggiolo", email: "gigigiuggiolo@info.it", admin: false, holidays: 40, permission: 0, pwd: "qwerty2"},
  ];

  persistenceService : PersistenceService = inject(PersistenceService);

  constructor() {
    this.users = this.persistenceService.retrieveFromStorage();
    }


    getAllUsers(){
      return this.users;
    }

    addUser(id: string, name: string, surname:string, email:string, pwd:string){
      const user ={
        id: crypto.randomUUID(),
        name: name,
        surname : surname,
        email : email,
        admin : false,
        holidays : 0,
        permission : 0,
        pwd : pwd
      }
      this.users.push(user);
    }



}
