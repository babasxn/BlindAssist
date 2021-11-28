package com.babasxn.blindassist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.babasxn.blindassist.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void AddReminder(View view)
    {
        EditText editTextDate = (EditText) findViewById(R.id.editTextDate);
        EditText editTextTitle = (EditText) findViewById(R.id.editTextTextPersonName);
        EditText editTextTime = (EditText) findViewById(R.id.editTextTextTime);



        String message= "Your Next Reminder is " + editTextTitle.getText().toString() + " which is on " +
                editTextDate.getText().toString() + " at " + editTextTime.getText().toString();
        Intent intent = new Intent(this, outputActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}