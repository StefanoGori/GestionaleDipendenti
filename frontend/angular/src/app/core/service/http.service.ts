import {inject, Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { User } from '../models/user.models';
import { TimeTable } from '../models/timetable.models';
import {text} from 'express';

@Injectable({
    providedIn: 'root'
})
export class HttpService {

    httpClient:HttpClient=inject(HttpClient);

    //Chiamate Http per il dipendente
    getAllUsers(){
        return this.httpClient.get<User[]>('http://localhost:8050/management/employees/all');
    }

    getUser(cf:string){
        return this.httpClient.get<User>('http://localhost:8050/management/employees/'+cf);
    }

    addUser(user:User){
        const headers = {"content-type" : "application/json", responseType:"json"}
        return this.httpClient.post<User>('http://localhost:8050/management/employees/add', user, {'headers':headers});
    }

    deleteUser(cf:string){
        const headers = { responseType:"text"}
        return this.httpClient.delete<string>(`http://localhost:8050/management/employees/delete/${cf}`, {'headers':headers});
    }

    editUser(user:User){
        return this.httpClient.put<User>('http://localhost:8050/management/employees/edit', user);
    }

    //Chiamate Http per i TimeTable
    getAllTimeTables(){
        return this.httpClient.get<TimeTable[]>('http://localhost:8050/management/timetables/all');
    }

    getTimeTable(id:number){
        return this.httpClient.get<TimeTable>('http://localhost:8050/management/timetables/'+id);
    }

    getTimeTableByUserId(name:string,surname:string){
        return this.httpClient.get<TimeTable[]>('http://localhost:8050/management/timetables/readof/'+name+'/'+surname);
    }

    addTimeTable(cf:string, timeTable: TimeTable){
        const headers = {"content-type" : "application/json", responseType:"json"}
        return this.httpClient.post<TimeTable>('http://localhost:8050/management/timetables/add/'+cf, timeTable,{'headers':headers} );
    }

    editTimeTable(timeTable: TimeTable){
        return this.httpClient.put<TimeTable>('http://localhost:8050/management/timetables/edit', timeTable);
    }

    deleteTimeTable(id:number){
        return this.httpClient.delete<TimeTable>('http://localhost:8050/management/timetables/delete/'+id);
    }
}
