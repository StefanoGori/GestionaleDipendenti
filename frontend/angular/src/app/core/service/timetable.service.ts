import {inject, Injectable} from '@angular/core';
import { TimeTable } from '../models/timetable.models';
import { BehaviorSubject, map, of } from 'rxjs';
import {HttpService} from './http.service';
import { User } from '../models/user.models';
import { time } from 'console';

@Injectable({
    providedIn: 'root'
})
export class TimeTableService {
    private timeTables$ = new BehaviorSubject<TimeTable[]>([]);
    private users$= new BehaviorSubject<User[]>([]);
    httpService: HttpService = inject(HttpService);

    constructor() {
        console.log("costruttore")
        this.httpService.getAllTimeTables()
        .pipe(
            map(timeTables=>timeTables.map(timeTable=>{
                return{...timeTable}
            }))
        ).subscribe({
            next: (value)=>{this.timeTables$.next(value)
                console.log(value)
            }
        });
    }

    get allTimeTables(){
        return this.timeTables$.asObservable();
    }

    getOneTimeTable(id: number){
        return this.timeTables$.pipe(
            map(timeTables=>{
                const timeTable=timeTables.find((timeTable)=>timeTable.id===id);
                if(!timeTable){
                    throw new Error("Orario non trovato");
                }
                return timeTable;
            })
        );
        
    }

    getTimeTableByUserCf(cf: string){
        console.log("cf"+ cf)
        return this.timeTables$.pipe(
            map(timeTables=>{
                const timeTable=timeTables.find((timeTable)=>timeTable.user.cf===cf);
                if(!timeTable){
                    throw new Error("Orario non trovato");
                }
                return of (timeTable);
            })
        );
    }

    addTimeTable(timetable : TimeTable, user : User){
    this.httpService.addTimeTable(user.cf, timetable).subscribe({
            next: ()=>{
                let timeTables = this.timeTables$.getValue();
                timeTables.push(timetable);
                this.timeTables$.next(timeTables);
            },
            error: (error)=>{
                console.log(error);
            }
        });
    }

    editTimeTable(id:number, newDay: string, newEntrance:string, newLeaving:string, newStamped_in:string,newStamped_out:string, newHoliday:boolean, newUsedpermits:number, newUser:User){
        let timeTables = this.timeTables$.getValue();
        const timeTableIndex = timeTables.findIndex((timeTable)=>timeTable.id===id);
        if(timeTableIndex==-1){
            throw new Error("Orario non trovato");
        }
        timeTables[timeTableIndex].day = newDay;
        timeTables[timeTableIndex].entrance = newEntrance;
        timeTables[timeTableIndex].leaving = newLeaving;
        timeTables[timeTableIndex].stamped_in = newStamped_in;
        timeTables[timeTableIndex].stamped_out = newStamped_out;
        timeTables[timeTableIndex].holiday = newHoliday;
        timeTables[timeTableIndex].usedpermits = newUsedpermits;
        timeTables[timeTableIndex].user = newUser;

        this.httpService.editTimeTable(timeTables[timeTableIndex]).subscribe({
            next: ()=>{
                this.timeTables$.next(timeTables);
            },
            error: (error)=>{
                console.log(error);
            }
        });
        
    }

    deleteTimeTable(id: number){
        this.httpService.deleteTimeTable(id).subscribe({
            next: ()=>{
                let timeTables = this.timeTables$.getValue();
                timeTables = timeTables.filter((timeTable)=>timeTable.id!==id);
                this.timeTables$.next(timeTables);
            },
            error: (error)=>{
                console.log(error);
            }
        });
    }

    editStamped_in(id: number, newStamped_in: string){
        let timeTables = this.timeTables$.getValue();
        const timeTableIndex = timeTables.findIndex((timeTable)=>timeTable.id===id);
        if(timeTableIndex==-1){
            throw new Error("Orario non trovato");
        }
        timeTables[timeTableIndex].stamped_in = newStamped_in;
        console.log(timeTables[timeTableIndex].stamped_in

        );
        this.httpService.editTimeTable(timeTables[timeTableIndex]).subscribe({
            next: ()=>{
                this.timeTables$.next(timeTables);
            },
            error: (error)=>{
                console.log(error);
            }
        });
    }

    editStamped_out(id: number, newStamped_out: string){
        let timeTables = this.timeTables$.getValue();
        const timeTableIndex = timeTables.findIndex((timeTable)=>timeTable.id===id);
        if(timeTableIndex==-1){
            throw new Error("Orario non trovato");
        }
        timeTables[timeTableIndex].stamped_out = newStamped_out;
        this.httpService.editTimeTable(timeTables[timeTableIndex]).subscribe({
            next: ()=>{
                this.timeTables$.next(timeTables);
            },
            error: (error)=>{
                console.log(error);
            }
        });
    }

    editHoliday(id: number, newHoliday: boolean){
        let timeTables = this.timeTables$.getValue();
        const timeTableIndex = timeTables.findIndex((timeTable)=>timeTable.id===id);
        if(timeTableIndex==-1){
            throw new Error("Orario non trovato");
        }
        timeTables[timeTableIndex].holiday = newHoliday;
        this.httpService.editTimeTable(timeTables[timeTableIndex]).subscribe({
            next: ()=>{
                this.timeTables$.next([...timeTables]);
            },
            error: (error)=>{
                console.log(error);
            }
        });
    }

    editUsedpermits(id: number, newUsedpermits: number){
        let timeTables = this.timeTables$.getValue();
        const timeTableIndex = timeTables.findIndex((timeTable)=>timeTable.id===id);
        if(timeTableIndex==-1){
            throw new Error("Orario non trovato");
        }
        const user = timeTables[timeTableIndex].user;
        const permits = user.permits;
        if(timeTables[timeTableIndex].usedpermits+newUsedpermits>permits){
            throw new Error("Permessi insufficienti");
        }
        timeTables[timeTableIndex].usedpermits += newUsedpermits;
        this.httpService.editTimeTable(timeTables[timeTableIndex]).subscribe({
            next: ()=>{
                this.timeTables$.next(timeTables);
            },
            error: (error)=>{
                console.log(error);
            }
        });
    }
}