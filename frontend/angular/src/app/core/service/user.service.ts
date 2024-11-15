import { inject, Injectable } from '@angular/core';
import { User } from '../models/user.models';
import { BehaviorSubject, map } from 'rxjs';
import { PersistenceService } from './persistence.service';
import { HttpService } from './http.service';
import { MatSnackBar } from '@angular/material/snack-bar';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  private _snackBar = inject(MatSnackBar);

  // creo il BehaviorSubject di un array di users che mi verrà dato dalla chiamata get http che mi restituisce tutti gli utenti
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
          this.users$.next([...users]);
          this._snackBar.open("Utente aggiunto!", "", {horizontalPosition : "center", verticalPosition : "top", duration : 2000});
        },
        error : (err) => {
          console.log(err);
        }
      })
    }

    editUser(newuser : User){
      const saveState = this.users$.getValue();
      if(saveState.find((user)=>user.cf.toUpperCase()===newuser.cf.toLocaleUpperCase())){
      const userIndex=saveState.findIndex((user)=>user.cf===newuser.cf);
      saveState[userIndex] = { ...newuser}
      this.users$.next([... saveState])
      this._snackBar.open("User modify successfully!", "", {horizontalPosition : "center", verticalPosition : "top", duration : 2000});
      } else {
        this._snackBar.open("Error: the user don't exist!", "", {horizontalPosition : "center", verticalPosition : "top", duration : 2000});
      }
    }

    deleteUser(cf: string){
      this.httpService.deleteUser(cf).subscribe({
        next:()=>{
          let users=this.users$.getValue();
          users=users.filter((user)=>user.cf.toUpperCase()!==cf.toUpperCase());
          this.users$.next(users);
        },
        error:(err)=>{console.log(err);}
      });
    }


}
