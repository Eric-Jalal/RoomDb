package com.example.testrelationroom.Usecases;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.testrelationroom.Entities.Person;

import java.util.List;

@Dao
public interface PersonDao {
    @Insert
    long insert(Person person);

    @Update
    void update(Person person);

    @Delete
    void delete(Person person);

    @Query("DELETE FROM person_table")
    void deleteAllPersons();

    @Query("SELECT * FROM person_table ORDER BY name DESC")
    LiveData<List<Person>> getAllPersons();
}