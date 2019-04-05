package com.example.testrelationroom;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonHolder> {
    private List<Person> persons = new ArrayList<>();

    @NonNull
    @Override
    public PersonHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.note_item, viewGroup, false);
        return new PersonHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonHolder personHolder, int i) {
        Person person = persons.get(i);
        personHolder.textViewName.setText(person.getName());
        personHolder.textViewPhoneNumbers.setText("");
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
        notifyDataSetChanged();
    }

    public Person getPersonAt(int position) {
        return persons.get(position);
    }


    public class PersonHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewPhoneNumbers;

        public PersonHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewPhoneNumbers = itemView.findViewById(R.id.text_view_phoneNumbers);

        }
    }

}
