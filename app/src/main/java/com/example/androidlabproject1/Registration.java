package com.example.androidlabproject1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Registration {
    public List<String> SaveStudents(String firstName , String lastName , int examResult) {
        List<String> studentList = new ArrayList<>();

        if (examResult > 400) {
            char section = firstName.charAt(0);
            studentList.add("Congratulations!!!");
            studentList.add("Dear " + firstName + lastName);
            studentList.add("you have successfully registered");
            studentList.add("Your section: " + section);

        } else {
            studentList.add("Dear " + firstName + " " + lastName);
            studentList.add("Sorry you are not eligible");
        }
        return studentList;
    }
}
