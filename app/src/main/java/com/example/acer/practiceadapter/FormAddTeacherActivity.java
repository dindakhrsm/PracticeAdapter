package com.example.acer.practiceadapter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.acer.practiceadapter.com.example.acer.user.Teacher;
import com.example.acer.practiceadapter.com.example.acer.user.TeacherList;

/**
 * Created by ACER on 22/10/2016.
 */

public class FormAddTeacherActivity extends AppCompatActivity {
    private EditText idText, nipText, nameText, mailText, phoneText;
    private Teacher teacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher);

        // Find all relevant views that we will need to read user input from
        idText = (EditText) findViewById(R.id.edit_id);
        nameText = (EditText) findViewById(R.id.edit_nama);
        nipText = (EditText) findViewById(R.id.edit_nip);
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
        String nip = nipText.getText().toString();
        String name = nameText.getText().toString();
        String mail = mailText.getText().toString();
        String phone = phoneText.getText().toString();
        teacher = new Teacher(id, nip, name, mail, phone);
        TeacherList teacherList = TeacherList.getInstance();
        teacherList.addTeacher(teacher);
        Toast success = Toast.makeText(getApplicationContext(), "Successfully Added New Teacher Data", Toast.LENGTH_SHORT);
        success.show();
        finish();
    }
}