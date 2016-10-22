package com.example.acer.practiceadapter.com.example.acer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.acer.practiceadapter.R;
import com.example.acer.practiceadapter.com.example.acer.user.Student;

import java.util.ArrayList;

/**
 * Created by ACER on 13/10/2016.
 */
public class StudentArrayAdapter extends ArrayAdapter<Student> {

    public StudentArrayAdapter(Context context, ArrayList<Student> studentArrayList) {
        super(context, 0, studentArrayList);
    }

    public View getView(int position, View v, ViewGroup parent){
        Student student = getItem(position);
        if(v==null){
            v= LayoutInflater.from(getContext()).inflate(R.layout.student_instance,parent,false);
        }

        TextView idView = (TextView) v.findViewById(R.id.student_id);
        TextView noregView = (TextView) v.findViewById(R.id.student_noreg);
        TextView nameView = (TextView) v.findViewById(R.id.student_name);
        TextView mailView = (TextView) v.findViewById(R.id.student_email);
        TextView phoneView = (TextView) v.findViewById(R.id.student_phone);

        //set content
        idView.setText(student.getId() + "");
        noregView.setText(student.getNoreg());
        nameView.setText(student.getName());
        mailView.setText(student.getMail());
        phoneView.setText(student.getPhone());
        return v;
    }
}
