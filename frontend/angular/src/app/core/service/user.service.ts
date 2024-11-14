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

    addUser(user : User){
      this.httpService.addUser(user).subscribe({
        next : () => {
          let users = this.users$.getValue(); 
          users.push(user);
          this.users$.next(users);
          // aggingere funzione per modale
        },
        error : (err) => {
          console.log(err);
        }
      })
    }

    editUser(cf: string, newName: string, newSurname:string, newAdmin:boolean, newHolidays:number, newPermission:number, newPwd:string){
      let users=this.users$.getValue();
      const userIndex=users.findIndex((user)=>user.cf===cf);
      if(userIndex==-1){
        throw new Error("Utente non trovato");
      }
      users[userIndex].name=newName;
      users[userIndex].surname=newSurname;
      users[userIndex].admin=newAdmin;
      users[userIndex].holidays=newHolidays;
      users[userIndex].permits=newPermission;
      users[userIndex].pwd=newPwd;

      this.httpService.editUser(users[userIndex]).subscribe({
        next:()=>{
          this.users$.next(users);
        },
        error:(err)=>{console.log(err);}
      });
    }

    deleteUser(cf: string){
      this.httpService.deleteUser(cf).subscribe({
        next:()=>{
          let users=this.users$.getValue();
          users=users.filter((user)=>user.cf!==cf);
          this.users$.next(users);
        },
        error:(err)=>{console.log(err);}
      });
    }



}
