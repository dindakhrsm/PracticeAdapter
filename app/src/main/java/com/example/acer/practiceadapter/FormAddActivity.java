package com.example.acer.practiceadapter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.acer.practiceadapter.com.example.acer.user.Student;
import com.example.acer.practiceadapter.com.example.acer.user.StudentList2;

/**
 * Created by ACER on 15/10/2016.
 */
public class FormAddActivity extends AppCompatActivity {
    //identify EditText field to enter data
    private EditText idText, nameText, noregText, mailText, phoneText;
    //identifier for content existing student
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        // Find all relevant views that we will need to read user input from
        idText = (EditText) findViewById(R.id.edit_id);
        nameText = (EditText) findViewById(R.id.edit_nama);
        noregText = (EditText) findViewById(R.id.edit_nim);
        mailText = (EditText) findViewById(R.id.edit_email);
        phoneText = (EditText) findViewById(R.id.edit_phone);
        //setup FAB to save new data and cancel
        FloatingActionButton saveButton = (FloatingActionButton) findViewById(R.id.saveActionButton);
        FloatingActionButton cancelButton = (FloatingActionButton) findViewById(R.id.cancelActionButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNewData();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    //method to save new data
		protected void saveNewData(){
        int id = Integer.parseInt(idText.getText().toString());
        String noreg = noregText.getText().toString();
        String name = nameText.getText().toString();
		String mail = mailText.getText().toString();
        String phone = phoneText.getText().toString();
        student = new Student(id, noreg, name, mail, phone);
        StudentList2 studentList2 = StudentList2.getInstance();
        studentList2.addStudent(student);
        Toast success = Toast.makeText(getApplicationContext(), "Successfully Added New Student Data", Toast.LENGTH_SHORT);
        success.show();
        finish();
    }
}