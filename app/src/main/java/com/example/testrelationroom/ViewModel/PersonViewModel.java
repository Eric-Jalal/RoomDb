package com.example.testrelationroom.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.testrelationroom.Entities.Person;
import com.example.testrelationroom.Repositories.PersonRepository;
import com.example.testrelationroom.Data.PhoneNumbers;

import java.util.List;

public class PersonViewModel extends AndroidViewModel {
    private PersonRepository repository;
    private LiveData<List<Person>> allPersons;
    private LiveData<List<PhoneNumbers>> allPhoneNumbers;

    public PersonViewModel(@NonNull Application application) {
        super(application);
        repository = new PersonRepository(application);
        allPersons = repository.getAllPersons();
        allPhoneNumbers = repository.getAllPhoneNumbers();
    }

    public long insertPerson(Person person) {
        return repository.insertPerson(person);
    }

    public void updatePerson(Person person) {
        repository.updatePerson(person);
    }

    public void deletePerson(Person person) {
        repository.deletePerson(person);
    }

    public void deleteAllPersons() {
        repository.deleteAllPersons();
    }

    public LiveData<List<Person>> getAllPersons() {
        return allPersons;
    }



    public void insertPhone(PhoneNumbers phone) {
        repository.insertPhone(phone);
    }

    public void updatePhone(PhoneNumbers phone) {
        repository.updatePhone(phone);
    }

    public void deletePhone(PhoneNumbers phone) {
        repository.deletePhone(phone);
    }

    public void deleteAllPhones() {
        repository.deleteAllPhones();
    }

    public LiveData<List<PhoneNumbers>> getAllPhoneNumbers() {
        return allPhoneNumbers;
    }
}
