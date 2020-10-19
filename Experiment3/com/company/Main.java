package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Student testStudent1 = new Student(777778888,"Liu",true,3);
        Student testStudent2 = new Student(777779999,"Guo",false,8);


        Teacher testTeacher1 = new Teacher(1234556788,"Zhang", true,5);
        Teacher testTeacher2 = new Teacher(1234552788,"Wei", false,5);


        Course testCourse1 = new Course(888873243,"Object-oriented Java Programming", "Library,room 605","Monday 7:50-9:25",testTeacher1,100,2);
        Course testCourse2 = new Course(888873243,"Discrete Math", "Library,room 505","Wednesday 7:50-9:25",testTeacher2,100,4);

        System.out.println("Test addCourse method:..." + "\n");
        testTeacher1.addCourse(testCourse1);
        testTeacher2.addCourse(testCourse2);
        // Reverse the order
        testTeacher1.addCourse(testCourse2);
        testTeacher2.addCourse(testCourse1);

        System.out.println("Test addCourseToLearn method:..." + "\n");
        testStudent1.addCourseToLearn(testCourse1);
        testStudent1.addCourseToLearn(testCourse2);
        testStudent2.addCourseToLearn(testCourse1);
        testStudent2.addCourseToLearn(testCourse2);

        System.out.println("Test toString in class Course method:..." + "\n");
        System.out.println(testCourse1);
        System.out.println(testCourse2);

        System.out.println("Test toString in class Teacher method:..." + "\n");
        System.out.println(testTeacher1);
        System.out.println(testTeacher2);

        System.out.println("Test toString in class Student method:..." + "\n");
        System.out.println(testStudent1);
        System.out.println(testStudent2);

        System.out.println("Test unEnrollACourse in class Teacher..." + "\n");
        testTeacher1.unEnrollACourse(testCourse1);
        testTeacher1.unEnrollACourse(testCourse2);
        testTeacher2.unEnrollACourse(testCourse2);
        testTeacher2.unEnrollACourse(testCourse1);

        System.out.println("Test unEnrollACourse in class Student..." + "\n");
        testStudent1.unEnrollACourse(testCourse1);
        testStudent1.unEnrollACourse(testCourse2);
        testStudent2.unEnrollACourse(testCourse1);
        testStudent2.unEnrollACourse(testCourse2);

        System.out.println("Test output all students in a course" + "\n");
        testCourse1.printCurrentStudents();

    }
}
