package com.gestionale.entities;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

enum Type{
    Normal,
    Holidays,
    Permits
}

@Entity
@Table(name="attendance")
public class Attendance {
    
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idA;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value="user-attendance")
    @JoinColumn(name="cf", referencedColumnName="cf", nullable = false)
    private User user; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value="hours-attendance")
    @JoinColumn(name="hours", referencedColumnName="id", nullable = false)
    private Hours hours;

    @Column(name="stamped_in")
    @JsonFormat(pattern="HH:mm:ss")
    private LocalTime stamped_in;

    @Column(name="stamped_out")
    @JsonFormat(pattern="HH:mm:ss")
    private LocalTime stamped_out;

    @Enumerated(EnumType.STRING)
    private Type type;

    // ------------------------------------GETTER AND SETTER------------------------------------

    public Long getIdA() {
        return this.idA;
    }

    public void setId(Long idA) {
        this.idA = idA;
    }

    // public User getUser() {
    //     return this.user;
    // }

    public void setUser(User user) {
        this.user = user;
    }

    // public Hours getHours() {
    //     return this.hours;
    // }

    public void setHours(Hours hours) {
        this.hours = hours;
    }

    public LocalTime getStamped_in() {
        return this.stamped_in;
    }

    public void setStamped_in(LocalTime stamped_in) {
        this.stamped_in = stamped_in;
    }

    public LocalTime getStamped_out() {
        return this.stamped_out;
    }

    public void setStamped_out(LocalTime stamped_out) {
        this.stamped_out = stamped_out;
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
