import { inject, Injectable } from '@angular/core';
import { User } from '../models/user.models';
import { BehaviorSubject, map } from 'rxjs';
import { PersistenceService } from './persistence.service';
import { HttpService } from './http.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  // creo il BehaviorSubject di un array di users che mi verrà dato dalla chiamata get http che mi restituisce tutti gli utenti
  // private user = new BehaviorSubject<User[]>([]);

  //   private users: User[] = [
  //   {cf:"1", name: "Mario", surname:"Rossi", email: "mariorossi@info.it", admin: false, holidays: 30, permission: 20, pwd: "qwerty"},
  //   {cf:"2", name: "Luigi", surname:"Verdi", email: "luigiverdi@info.it", admin: true, holidays: 303, permission: 2, pwd: "qwerty1"},
  //   {cf:"3", name: "Gigi", surname:"Giuggiolo", email: "gigigiuggiolo@info.it", admin: false, holidays: 40, permission: 0, pwd: "qwerty2"},
  // ];

  // persistenceService : PersistenceService = inject(PersistenceService);

  private users$ = new BehaviorSubject<User[]>([]);

  httpService: HttpService = inject(HttpService);

  constructor() {
    // this.users = this.persistenceService.retrieveFromStorage();

    this.httpService.getAllUsers()
    .pipe(
      map(users => users.map(user=>{
        return{...user}
      }))
    ).subscribe({
      next: (value)=>{this.users$.next(value)}
    });
    }

    get allUsers(){
      return this.users$.asObservable();
    }

    // metodo che mi restituisce l'utente loggato 
    // getAuthUser(email: string, psw : string){
    //   if()
      
    // }

    // // metodo che mi restituisce tutti gli utenti
    // getAllUsers(){
    //   return this.users;
    // }

    // addUser(cf: string, name: string, surname:string, email:string, pwd:string){
    //   const user ={
    //     cf: crypto.randomUUID(),
    //     name: name,
    //     surname : surname,
    //     email : email,
    //     admin : false,
    //     holidays : 0,
    //     permission : 0,
    //     pwd : pwd
    //   }
    //   this.users.push(user);
    // }



}
