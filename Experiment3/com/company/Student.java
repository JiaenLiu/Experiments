package com.company;

import java.util.ArrayList;
import java.util.List;

public class Student extends Member{

    private List<Course> courseToLearn = new ArrayList<Course>();
    private int scoreUpperbound = 28;
    private int currentScore;

    private void findCurrentScore() {
        for (Course c : courseToLearn) {
            currentScore = currentScore + c.getScore();
        }
    }

    public Student(Integer id, String n, boolean sex, int s) {
        super(id,n,sex);
        scoreUpperbound = s;
        super.setIdNumber(id);
        super.setName(n);
        super.setSex(sex);
    }

    @Override
    public String toString() {
        String output = "Student: " + this.getName() + "\n";
        for (Course c :courseToLearn) {
            output = output + c.toString();
        }
        return output;
    }

    public void addCourseToLearn(Course c) {
        this.findCurrentScore();
        if (currentScore + c.getScore() > scoreUpperbound && c.isFull()) {
            System.out.println("You can not choose more course due to your upperbound of scores or the course is full.");
            return;
        }
        else {
            System.out.println("Successfully Added!!!!!!!");
            this.courseToLearn.add(c);
            c.addOneStudent();
        }
    }

    public int getScoreUpperbound() {
        return scoreUpperbound;
    }

    public int getCurrentScore() {
        return currentScore;
    }

}
