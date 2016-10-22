package com.example.acer.practiceadapter.com.example.acer.user;

import java.util.ArrayList;

/**
 * Created by ACER on 21/10/2016.
 */

public class TeacherList {
    private static ArrayList<Teacher> teacherArrayList = new ArrayList<>();
    private static TeacherList instance = new TeacherList();


    public static ArrayList<Teacher> getTeacherArrayList(){
        return teacherArrayList;
    }

    public static void setTeacherArrayList(ArrayList<Teacher> teacherArrayList){
        TeacherList.teacherArrayList = teacherArrayList;
    }

    public static TeacherList getInstance(){
        return instance;
    }

    public static void setInstance(TeacherList instance){
        TeacherList.instance = instance;
    }

    public void addTeacher(Teacher teacher){
        teacherArrayList.add(teacher);
    }

    public Teacher get(int index){
        Teacher teacher = teacherArrayList.get(index);
        return teacher;
    }

    public void set(int index, Teacher teacher){
        teacherArrayList.set(index, teacher);
    }

    public Teacher remove(int index){
        Teacher teacher = teacherArrayList.remove(index);
        return teacher;
    }

    public void AddTeachers(ArrayList<Teacher> teachers){
        teacherArrayList.addAll(teachers);
    }

    public ArrayList<Teacher> getList(){
        return teacherArrayList;
    }

    public int count(){
        return teacherArrayList.size();
    }

    public void clearList(){
        teacherArrayList.clear();
    }

    private void reset(int i) {
        for (int j = i; j < teacherArrayList.size(); j++) {
            teacherArrayList.get(j).setId(j);
        }
    }

}
