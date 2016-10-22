package com.example.acer.practiceadapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.acer.practiceadapter.com.example.acer.adapter.StudentArrayAdapter;
import com.example.acer.practiceadapter.com.example.acer.user.Student;
import com.example.acer.practiceadapter.com.example.acer.user.StudentList2;

import java.util.ArrayList;

/**
 * Created by ACER on 13/10/2016.
 */
public class StudentActivity extends AppCompatActivity {

    private StudentArrayAdapter studentArrayAdapter;
	private static ArrayList<Student> studentArrayList;
    private ListView studentListView;
	private TextView empty_view;
	private StudentList2 studentList2;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        studentListView = (ListView)findViewById(R.id.list_item);
        empty_view = (TextView)findViewById(R.id.empty_view);
        studentListView.setEmptyView(empty_view);
        studentList2 = StudentList2.getInstance();

        //setlistener for floacting action button
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open Form Add Student
                Intent intent = new Intent(getApplicationContext(), FormAddActivity.class);
                startActivity(intent);
            }
        });
        studentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), FormEditActivity.class);
                Student student = studentList2.get(position);
                intent.putExtra("StudentList",student);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        if(studentList2.count()==0) {
            studentArrayAdapter = new StudentArrayAdapter(this, new ArrayList<Student>());
            empty_view.setText("No Student Found");
        } else{
            studentArrayAdapter = new StudentArrayAdapter(this, studentList2.getList());
        }
        studentListView.setAdapter(studentArrayAdapter);
    }

    private void populateStudentList(){
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student(1, "3145136192","Ummu Kultsum","ummu@mhs.unj.ac.id","0888xxx"));
        studentArrayList.add(new Student(2, "3145136203","Ghina Rosika Amalina","ghina@mhs.unj.ac.id","0812xxx"));
        studentArrayList.add(new Student(3, "3145136204","Dinda Kharisma","dinda@mhs.unj.ac.id","0896xxx"));
        studentArrayList.add(new Student(4, "3145136216","Rahmi Putri","putri@mhs.unj.ac.id","0857xxx"));
        studentList2.AddStudents(studentArrayList);
        studentArrayAdapter = new StudentArrayAdapter(this, studentList2.getList());
        studentListView.setAdapter(studentArrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_student_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.create_dummy:
                populateStudentList();
                return true;
            case R.id.clear_list:
                StudentList2.getInstance().clearList();
                studentArrayAdapter = new StudentArrayAdapter(this, new ArrayList<Student>());
                studentListView.setAdapter(studentArrayAdapter);
                return true;
            case R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

