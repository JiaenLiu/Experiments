package com.company;

import org.jetbrains.annotations.NotNull;

public class Course {

    private String idNumber;
    private String name;
    private String location;
    private String time;
    private Teacher teacher;
    private int upperbound;
    private int curNumOfStudents = 0;
    private int score;

    public Course(Integer id, String n, String l, String t1, Teacher t2, int u, int s) {
        if (u < 0) {
            System.out.println("Invalid Upperbound!!!");
            return;
        }
        if (s < 0) {
            System.out.println("Invalid Upperbound!!!");
            return;
        }
        idNumber = id.toString();
        name = n;
        location = l;
        time = t1;
        teacher = t2;
        upperbound = u;
        score = s;
    }

    public boolean isFull() {
        return curNumOfStudents <= upperbound;
    }


    @Override
    public String toString() {
        String output;
        output = "Course ID Number: " + idNumber + " " + "Course Name: " + name + "\n"
            + "Location: " + location + " " + "Time: " + time + "\n" + "Teacher: " + teacher.getName() + "." + "\n";
        return output;
    }

    //Setters

    public void addOneStudent() {
        this.curNumOfStudents++ ;
    }

    public void setIdNumber(Integer idNumber) {
        if (idNumber.toString().length()< 8) {
            System.out.println("Invalid Id Number!!!");
            return;
        }
        this.idNumber = idNumber.toString();
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        if (score < 0) {
            System.out.println("Invalid Score!!!");
            return;
        }
        this.score = score;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setUpperbound(int upperbound) {
        if (upperbound < 0) {
            System.out.println("Invalid attend Upperbound!!!");
        }
        this.upperbound = upperbound;
    }

    // Getters


    public int getScore() {
        return score;
    }

    public int getUpperbound() {
        return upperbound;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public int getCurNumOfStudents() {
        return curNumOfStudents;
    }
}
