export interface TimeTable{
    id: number;
    day: string;
    entrance: string;
    leaving: string;
    stamped_in?: string;
    stamped_out?: string;
    holiday: boolean;
    usedpermits:number;
    userId:number;
}