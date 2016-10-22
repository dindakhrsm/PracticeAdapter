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

import com.example.acer.practiceadapter.com.example.acer.adapter.TeacherArrayAdapter;
import com.example.acer.practiceadapter.com.example.acer.user.Teacher;
import com.example.acer.practiceadapter.com.example.acer.user.TeacherList;

import java.util.ArrayList;

    public class TeacherActivity extends AppCompatActivity {

        private TeacherArrayAdapter teacherArrayAdapter;
        private static ArrayList<Teacher>teacherArrayList;
        private ListView teacherListView;
        private TextView empty_view;
        private TeacherList teacherList;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.list_view);
            teacherListView = (ListView) findViewById(R.id.list_item);
            empty_view = (TextView) findViewById(R.id.empty_view);
            teacherListView.setEmptyView(empty_view);
            teacherList = TeacherList.getInstance();

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), FormAddTeacherActivity.class);
                    startActivity(intent);
                }
            });
            teacherListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    Intent intent = new Intent(getApplicationContext(), FormEditActivity.class);
                    Teacher student = teacherList.get(position);
                    intent.putExtra("TeacherList", student);
                    startActivity(intent);
                }
            });
        }

        @Override
        public void onResume() {
            super.onResume();
            if (teacherList.count() == 0) {
                teacherArrayAdapter = new TeacherArrayAdapter(this, new ArrayList<Teacher>());
                empty_view.setText("No Teacher Found");
            } else {
                teacherArrayAdapter = new TeacherArrayAdapter(this, teacherList.getList());
            }
            teacherListView.setAdapter(teacherArrayAdapter);
        }

        private void populateTeacherList() {
            ArrayList<Teacher> teacherArrayList = new ArrayList<>();
                teacherArrayList.add(new Teacher(1, "196002111987032001", "Fariani Hermin", "0818xxxxxx", "fariani-hermin@unj.ac.id"));
                teacherArrayList.add(new Teacher(2, "196605171994031003", "Mulyono", "0813xxxxxx", "mulyono@unj.ac.id"));
                teacherArrayList.add(new Teacher(3, "197509252002122002", "Ratna Widyati", "0858xxxxxx", "ratna-widyati@unj.ac.id"));
                teacherArrayList.add(new Teacher(4, "197511212005012004", "Ria Arafiyah", "0856xxxxxx", "ria-arafiyah@unj.ac.id"));
                teacherArrayList.add(new Teacher(5, "197706152003121001", "Med Irzal", "0813xxxxxx", "med-irzal@unj.ac.id"));
                teacherList.AddTeachers(teacherArrayList);
                teacherArrayAdapter = new TeacherArrayAdapter(this, teacherList.getList());
                teacherListView.setAdapter(teacherArrayAdapter);
            }

            @Override
            public boolean onCreateOptionsMenu(Menu menu){
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.menu_teacher_list, menu);
                return true;
            }

            @Override
            public boolean onOptionsItemSelected(MenuItem item){
                switch(item.getItemId()){
                    case R.id.create_dummy:
                        populateTeacherList();
                        return true;
                    case R.id.clear_list:
                        TeacherList.getInstance().clearList();
                        teacherArrayAdapter = new TeacherArrayAdapter(this, new ArrayList<Teacher>());
                        teacherListView.setAdapter(teacherArrayAdapter);
                        return true;
                    case R.id.home:
                        finish();
                        return true;
                }

                return super.onOptionsItemSelected(item);
            }
        }
