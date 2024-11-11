package com.gestionale.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AttendanceKey implements Serializable {

    @Column(name = "CF")
    private String CF;
    
    @Column(name = "ID")  // Questo sarà l'ID riferito all'entità `Hours`
    private String ID;

    // Costruttori, getters, setters, equals() e hashCode() (obbligatorio)

    public AttendanceKey() {}

    public AttendanceKey(String CF, String ID) {
        this.CF = CF;
        this.ID = ID;
    }

    public String getCF() {
        return CF;
    }

    public void setCF(String CF) {
        this.CF = CF;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttendanceKey that = (AttendanceKey) o;
        return CF.equals(that.CF) && ID.equals(that.ID);
    }

    @Override
    public int hashCode() {
        return 31 * CF.hashCode() + ID.hashCode();
    }
}
