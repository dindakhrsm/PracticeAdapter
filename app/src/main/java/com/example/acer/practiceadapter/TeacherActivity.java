package com.example.acer.practiceadapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.acer.practiceadapter.com.example.acer.adapter.TeacherArrayAdapter;
import com.example.acer.practiceadapter.com.example.acer.user.Teacher;

import java.util.ArrayList;

    public class TeacherActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.list_view);

            ArrayList<Teacher> teachers = populateTeacherDummies();
            TeacherArrayAdapter teacherArrayAdapter = new TeacherArrayAdapter(this,teachers);
            ListView list_item = (ListView) findViewById(R.id.list_item);
            list_item.setAdapter(teacherArrayAdapter);

        }

        private ArrayList<Teacher> populateTeacherDummies(){
            ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
            teacherList.add(new Teacher(1,"196002111987032001","Fariani Hermin","0818xxxxxx","fariani-hermin@unj.ac.id"));
            teacherList.add(new Teacher(2,"196605171994031003","Mulyono","0813xxxxxx","mulyono@unj.ac.id"));
            teacherList.add(new Teacher(3,"197509252002122002","Ratna Widyati","0858xxxxxx","ratna-widyati@unj.ac.id"));
            teacherList.add(new Teacher(4,"197511212005012004","Ria Arafiyah","0856xxxxxx","ria-arafiyah@unj.ac.id"));
            teacherList.add(new Teacher(5,"197706152003121001","Med Irzal","0813xxxxxx","med-irzal@unj.ac.id"));
            teacherList.add(new Teacher(6,"198512232012121002","Muhammad Eka Suryana","0882xxxxxx","eka-suryana@unj.ac.id"));
            return teacherList;
        }
    }
