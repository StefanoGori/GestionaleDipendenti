import { Injectable } from '@angular/core';

import { User } from '../models/user.models';

@Injectable({
    providedIn: 'root'
})
export class PersistenceService {



    constructor() { }

    saveStorage(users: User[]){
        
        // trasformo i dati in un json (stringify il valore che passi diventa una stringa)
        const serializedUsers = JSON.stringify(users); 
        // setta i dati dal local storage e passi come valore la chiave (come chiamarli) e i dati
        localStorage.setItem("users", serializedUsers) 
    }

    retrieveFromStorage(){
        const stringUsers = localStorage.getItem("users");
        if(stringUsers){
            return JSON.parse(stringUsers);
    } 
}
}
