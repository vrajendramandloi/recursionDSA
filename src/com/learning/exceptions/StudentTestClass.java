package com.learning.exceptions;


import collectiontest.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentTestClass {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Vishnu", 95));
        studentList.add(new Student("Abhinav", 96));
        studentList.add(new Student("Teek", 45));
        studentList.add(new Student("aab", 68));
        evaluateMax(studentList);
    }

    public static void evaluateMax(List<Student> studentList) {
        /*if(studentList == null || studentList.isEmpty()) return;
        Optional<Student> maxMarkStudent =  studentList.stream()
                .sorted((o1, o2) -> o1.compareTo(o2))
                .findFirst();
        if(maxMarkStudent.isPresent()) {
            System.out.println(maxMarkStudent.get());
        }*/
    }
}
