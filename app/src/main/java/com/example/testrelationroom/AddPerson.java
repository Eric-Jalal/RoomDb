package com.example.testrelationroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPerson extends AppCompatActivity {

    public static final String EXTRA_ID =
            "com.example.testrelationroom.EXTRA_ID";
    public static final String EXTRA_name =
            "com.example.testrelationroom.EXTRA_name";
    public static final String EXTRA_phoneNumber =
            "com.example.testrelationroom.EXTRA_phoneNumber";

    private EditText name;
    private EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        name = findViewById(R.id.edit_text_name);
        phone = findViewById(R.id.edit_text_phone_number);

        Button add = findViewById(R.id.button_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePerson();
            }
        });
    }

    private void savePerson() {
        String personName = name.getText().toString();
        String phoneNumber = phone.getText().toString();

        Intent data = new Intent();
        data.putExtra(EXTRA_name, personName);
        data.putExtra(EXTRA_phoneNumber, phoneNumber);

        setResult(RESULT_OK, data); //When an activity exits, it can call setResult(int) to return data back to its parent
        finish();
    }
}
