package com.example.androidlabproject1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Registration registration = new Registration();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void onSubmitClick(View view){
        EditText firstNameBox = (EditText) findViewById(R.id.firstNameBox);
        String firstName = firstNameBox.getText().toString();
        EditText lastNameBox = (EditText) findViewById(R.id.lastNameBox);
        String lastName = lastNameBox.getText().toString();
        EditText resultBox = (EditText) findViewById(R.id.resultBox);
        int examResult =   Integer.parseInt(resultBox.getText().toString());
        TextView displayResult = (TextView) findViewById(R.id.resultDisplay);

        List<String> studentsResult = registration.SaveStudents(firstName , lastName , examResult);
        StringBuilder studentsFormatted = new StringBuilder();
        for(String students: studentsResult){
            studentsFormatted.append(students).append('\n');
        }
        // Display
        displayResult.setText(studentsFormatted);

    }
}