package com.example.acer.practiceadapter.com.example.acer.user;

import java.util.ArrayList;

/**
 * Created by ACER on 21/10/2016.
 */

public class StudentList2 {
    private static ArrayList<Student> studentArrayList = new ArrayList<>();
    private static StudentList2 instance = new StudentList2();


    public static ArrayList<Student> getStudentArrayList(){
        return studentArrayList;
    }

    public static void setStudentArrayList(ArrayList<Student> studentArrayList){
        StudentList2.studentArrayList = studentArrayList;
    }

    public static StudentList2 getInstance(){
        return instance;
    }

    public static void setInstance(StudentList2 instance){
        StudentList2.instance = instance;
    }

    public void addStudent(Student student){
        studentArrayList.add(student);
    }

    public Student get(int index){
        Student student = studentArrayList.get(index);
        return student;
    }

    public void set(int index, Student student){
        studentArrayList.set(index, student);
    }

    public Student remove(int index){
        Student student = studentArrayList.remove(index);
        return student;
    }

    public void AddStudents(ArrayList<Student> students){
        studentArrayList.addAll(students);
    }

    public ArrayList<Student> getList(){
        return studentArrayList;
    }

    public int count(){
        return studentArrayList.size();
    }

    public void clearList(){
        studentArrayList.clear();
    }
	
     private void reset(int i) {
         for (int j = i; j < studentArrayList.size(); j++) {
            studentArrayList.get(j).setId(j);
         }
      }

    }
