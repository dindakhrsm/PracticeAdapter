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


/**
 * Created by ACER on 22/10/2016.
 */


public class FormEditActivity extends AppCompatActivity {

    //initialize EditText field
    private EditText idText, noregText, nameText, mailText, phoneText;

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
        mailText.setText(object.getMail());
        phoneText.setText(object.getPhone());
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
       //not implemented yet
        Toast updated = Toast.makeText(getApplicationContext(), "Student Data has not changed yet", Toast.LENGTH_SHORT);
        updated.show();
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
