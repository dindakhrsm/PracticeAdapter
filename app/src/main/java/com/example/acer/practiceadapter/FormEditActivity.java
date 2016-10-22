package com.example.acer.practiceadapter;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.acer.practiceadapter.com.example.acer.user.Student;
import com.example.acer.practiceadapter.com.example.acer.user.StudentList2;

/**
 * Created by ACER on 22/10/2016.
 */


public class FormEditActivity extends AppCompatActivity {

    private EditText idText, noregText, nameText, mailText, phoneText;
    private Student student;
    private int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
    // Find all relevant views that we will need to read user input from
        idText = (EditText) findViewById(R.id.edit_id);
        noregText = (EditText) findViewById(R.id.edit_nim);
        nameText = (EditText) findViewById(R.id.edit_nama);
		mailText = (EditText) findViewById(R.id.edit_email);
        phoneText = (EditText) findViewById(R.id.edit_phone);
    //get list of data which will be edited
        Student object = getIntent().getParcelableExtra("StudentList");
        idText.setText("" + object.getId());
        noregText.setText(object.getNoreg());
        nameText.setText(object.getName());
        phoneText.setText(object.getPhone());
        mailText.setText(object.getMail());
        //setup FAB to save edited data and cancel
        FloatingActionButton saveButton = (FloatingActionButton) findViewById(R.id.saveActionButton);
        FloatingActionButton cancelButton = (FloatingActionButton) findViewById(R.id.cancelActionButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUpdated();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
//method to save edited data
    protected void saveUpdated(){
        int id = Integer.parseInt(idText.getText().toString());
        String noreg = noregText.getText().toString();
        String name = nameText.getText().toString();
        String phone = phoneText.getText().toString();
        String mail = mailText.getText().toString();
        student = new Student(id, noreg, name, mail, phone);
        StudentList2 studentList2 = StudentList2.getInstance();
        studentList2.set(id, student);
        Toast success = Toast.makeText(getApplicationContext(), "Successfully Updated Student Data", Toast.LENGTH_SHORT);
        success.show();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_student_editor.xml file.
        // This adds menu items to the app bar.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_editor,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.delete_item:
                //not implemented yet
                return true;
            case R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
