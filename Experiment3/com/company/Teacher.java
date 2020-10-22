package com.company;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Member {

    private List<Course> courseToTeach = new ArrayList<Course>();
    private int upperbound = 5;


    public Teacher(Integer id, String n, boolean sex, int u) {
        super(id,n,sex);
        upperbound = u;
    }

    public void clearAll() {
        courseToTeach.clear();
    }

    public void unEnrollACourse(Course course) {
        if (courseToTeach.contains(course)) {
            courseToTeach.remove(course);
            System.out.println("Successfully unenroll course " + "\n" + course.toString());
            return;
        }
        System.out.println("You do not enroll this course" + "\n" + course.toString());
    }

    @Override
    public String toString() {
        String output = "Teacher: " + this.getName() + "\n";
        for (Course c :courseToTeach) {
            output = output + c.toString();
        }
        return output;
    }

    public void setUpperbound(int u) {
        if (u < 0) {
            System.out.println("Invalid Upperbound!!!!");
            return;
        }
        upperbound = u;
    }

    public int getUpperbound() {
        return upperbound;
    }

    public void addCourse(Course course) {
        if (courseToTeach.size() < upperbound && this.equals(course.getTeacher())) {
            System.out.println("Successfully Added!!!!");
            courseToTeach.add(course);
        }
        else {
            System.out.println("Too many course or Not the lecturer in this course.");
        }
    }

    public boolean hasCourse(Course course) {
        return courseToTeach.contains(course);
    }

    public int getCurrentCourse () {
        return courseToTeach.size();
    }

}
