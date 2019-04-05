package com.example.testrelationroom;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "phone_table",
        foreignKeys = @ForeignKey(
                entity = Person.class,
                parentColumns = "id",
                childColumns = "personID"))
public class PhoneNumbers {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int number;
    private int personID;

    public PhoneNumbers(int id, int number, int personID) {
        this.id = id;
        this.number = number;
        this.personID = personID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }
}
