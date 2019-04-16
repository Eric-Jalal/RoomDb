package com.example.testrelationroom.Repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.testrelationroom.Data.PersonDatabase;
import com.example.testrelationroom.Entities.Person;
import com.example.testrelationroom.Usecases.PhoneDao;
import com.example.testrelationroom.Data.PhoneNumbers;
import com.example.testrelationroom.Usecases.PersonDao;

import java.util.List;

public class PersonRepository {
    private PersonDao personDao;
    private PhoneDao phoneDao;
    private LiveData<List<Person>> allPersons;
    private LiveData<List<PhoneNumbers>> allPhoneNumbers;

    public PersonRepository(Application application) {
        PersonDatabase personDatabase = PersonDatabase.getInstance(application);
        personDao = personDatabase.personDao();
        phoneDao = personDatabase.phoneDao();
        allPersons = personDao.getAllPersons();
        allPhoneNumbers = phoneDao.getAllPhones();
    }

    public long insertPerson(Person person) {
        InsertPersonAsyncTask insertPersonAsyncTask =new InsertPersonAsyncTask(personDao);
        insertPersonAsyncTask.execute(person);
        return insertPersonAsyncTask.id;
    }

    public void updatePerson(Person person) {
        new UpdatePersonAsyncTask(personDao).execute(person);
    }

    public void deletePerson(Person person) {
        new DeletePersonAsyncTask(personDao).execute(person);
    }

    public void deleteAllPersons() {
        new DeleteAllPersonAsyncTask(personDao).execute();
    }

    public LiveData<List<Person>> getAllPersons() {
        return allPersons;
    }


    public void insertPhone(PhoneNumbers phone) {
        new InsertPhoneAsyncTask(phoneDao).execute(phone);
    }

    public void updatePhone(PhoneNumbers phone) {
        new UpdatePhoneAsyncTask(phoneDao).execute(phone);
    }

    public void deletePhone(PhoneNumbers phone) {
        new DeletePhoneAsyncTask(phoneDao).execute(phone);
    }

    public void deleteAllPhones() {
        new DeleteAllPhoneAsyncTask(phoneDao).execute();
    }

    public LiveData<List<PhoneNumbers>> getAllPhoneNumbers() {
        return allPhoneNumbers;
    }

    private static class InsertPersonAsyncTask extends AsyncTask<Person, Void, Void> {
        private PersonDao personDao;
        public long id;

        public InsertPersonAsyncTask(PersonDao personDao) {
            this.personDao = personDao;
        }

        @Override
        protected Void doInBackground(Person... persons) {
            id = personDao.insert(persons[0]);
            return null;
        }
    }


    private static class UpdatePersonAsyncTask extends AsyncTask<Person, Void, Void> {
        private PersonDao personDao;

        public UpdatePersonAsyncTask(PersonDao personDao) {
            this.personDao = personDao;
        }

        @Override
        protected Void doInBackground(Person... persons) {
            personDao.update(persons[0]);
            return null;
        }
    }


    private static class DeletePersonAsyncTask extends AsyncTask<Person, Void, Void> {
        private PersonDao personDao;

        public DeletePersonAsyncTask(PersonDao personDao) {
            this.personDao = personDao;
        }

        @Override
        protected Void doInBackground(Person... persons) {
            personDao.delete(persons[0]);
            return null;
        }
    }


    private static class DeleteAllPersonAsyncTask extends AsyncTask<Void, Void, Void> {
        private PersonDao personDao;

        public DeleteAllPersonAsyncTask(PersonDao personDao) {
            this.personDao = personDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            personDao.deleteAllPersons();
            return null;
        }
    }



    private static class InsertPhoneAsyncTask extends AsyncTask<PhoneNumbers, Void, Void> {
        private PhoneDao phoneDao;

        public InsertPhoneAsyncTask(PhoneDao phoneDao) {
            this.phoneDao = phoneDao;
        }

        @Override
        protected Void doInBackground(PhoneNumbers... phones) {
            phoneDao.insert(phones[0]);
            return null;
        }
    }


    private static class UpdatePhoneAsyncTask extends AsyncTask<PhoneNumbers, Void, Void> {
        private PhoneDao phoneDao;

        public UpdatePhoneAsyncTask(PhoneDao phoneDao) {
            this.phoneDao = phoneDao;
        }

        @Override
        protected Void doInBackground(PhoneNumbers... phones) {
            phoneDao.update(phones[0]);
            return null;
        }
    }


    private static class DeletePhoneAsyncTask extends AsyncTask<PhoneNumbers, Void, Void> {
        private PhoneDao phoneDao;

        public DeletePhoneAsyncTask(PhoneDao phoneDao) {
            this.phoneDao = phoneDao;
        }

        @Override
        protected Void doInBackground(PhoneNumbers... phones) {
            phoneDao.delete(phones[0]);
            return null;
        }
    }


    private static class DeleteAllPhoneAsyncTask extends AsyncTask<Void, Void, Void> {
        private PhoneDao phoneDao;

        public DeleteAllPhoneAsyncTask(PhoneDao phoneDao) {
            this.phoneDao = phoneDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            phoneDao.deleteAllphones();
            return null;
        }
    }
}
