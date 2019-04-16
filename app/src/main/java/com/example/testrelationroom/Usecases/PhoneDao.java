package com.example.testrelationroom.Usecases;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.testrelationroom.Data.PhoneNumbers;

import java.util.List;

@Dao
public interface PhoneDao {
    @Insert
    void insert(PhoneNumbers phoneNumber);

    @Update
    void update(PhoneNumbers phoneNumber);

    @Delete
    void delete(PhoneNumbers phoneNumber);

    @Query("DELETE FROM phone_table")
    void deleteAllphones();

    @Query("SELECT * FROM phone_table ORDER BY id DESC")
    LiveData<List<PhoneNumbers>> getAllPhones();


    @Query("SELECT * FROM phone_table WHERE personID = :personID")
    LiveData<List<PhoneNumbers>> loadAllPhonesByPersonId(final int personID);
}
