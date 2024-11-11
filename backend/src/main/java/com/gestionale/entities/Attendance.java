package com.gestionale.entities;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

enum Type{
    Normal,
    Holidays,
    Permits
}

@Entity
@Table(name="attendance")
public class Attendance {

    @EmbeddedId
    @Column()
    private AttendanceKey Id;

    @OneToOne
    @JoinColumn(name="CF", referencedColumnName="CF", insertable = false, updatable = false, nullable = false)
    private User User;

    @OneToOne
    @JoinColumn(name="ID", referencedColumnName="ID", insertable = false, updatable = false, nullable = false)
    private Hours Hours;

    @Column(name="Stamped_In")
    private LocalTime Stamped_In;

    @Column(name="Stamped_Out")
    private LocalTime Stamped_Out;

    @Enumerated(EnumType.STRING)
    private Type Type;

    // ------------------------------------GETTER AND SETTER------------------------------------

    public AttendanceKey getId() {
        return this.Id;
    }

    public void setId(AttendanceKey Id) {
        this.Id = Id;
    }

    public User getUser() {
        return this.User;
    }

    public void setUser(User User) {
        this.User = User;
    }

    public Hours getHours() {
        return this.Hours;
    }

    public void setHours(Hours Hours) {
        this.Hours = Hours;
    }

    public LocalTime getStamped_In() {
        return this.Stamped_In;
    }

    public void setStamped_In(LocalTime Stamped_In) {
        this.Stamped_In = Stamped_In;
    }

    public LocalTime getStamped_Out() {
        return this.Stamped_Out;
    }

    public void setStamped_Out(LocalTime Stamped_Out) {
        this.Stamped_Out = Stamped_Out;
    }

    public Type getType() {
        return this.Type;
    }

    public void setType(Type Type) {
        this.Type = Type;
    }

    
}
