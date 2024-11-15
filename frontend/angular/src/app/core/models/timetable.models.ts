import { User } from "./user.models";

export interface TimeTable{
    id: number;
    day: string;
    entrance: string;
    leaving: string;
    stamped_in?: string;
    stamped_out?: string;
    holiday?: boolean;
    usedpermits:number;
    user: User;
}