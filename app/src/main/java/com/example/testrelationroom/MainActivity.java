package com.example.testrelationroom;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int ADD_PERSON_REQUEST = 1;
    private PersonViewModel personViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.button_add_note);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddPerson.class);
                startActivityForResult(intent, ADD_PERSON_REQUEST); //want to get a result back from an activity when it ends
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final PersonAdapter adapter = new PersonAdapter();
        recyclerView.setAdapter(adapter);

        personViewModel = ViewModelProviders.of(this).get(PersonViewModel.class);
        personViewModel.getAllPersons().observe(this, new Observer<List<Person>>() {
            @Override
            public void onChanged(@Nullable List<Person> persons) {
                //every time in live data object changes if the activity is foreground
                //if the activity destroyed this will not hold to this activity
                //update RecyclerView
                adapter.setPersons(persons);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_PERSON_REQUEST && resultCode == RESULT_OK) {
            String name = data.getStringExtra(AddPerson.EXTRA_name);
            String phone = data.getStringExtra(AddPerson.EXTRA_phoneNumber);

            Person person = new Person(0, name);
            long id = personViewModel.insertPerson(person);

            PhoneNumbers phoneNumbers = new PhoneNumbers(0, Integer.parseInt(phone), (int) id);
            personViewModel.insertPhone(phoneNumbers);

            Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show();
        }
    }
}
