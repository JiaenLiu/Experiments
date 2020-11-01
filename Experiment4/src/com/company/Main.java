package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Postgraduates testOne = new Postgraduates("Liu", true, 5000, 2000);
        Postgraduates testTwo = new Postgraduates("Guo", false, 5000, 6000);

        // Test method tax
        System.out.println("TestOne's tax is: " + testOne.tax() + "\n");

        System.out.println("TestTwo's tax is: " + testTwo.tax() + "\n");

        // Test method getSalary
        System.out.println("Before salary day: " + testOne.getCurrency());
        testOne.getSalary();
        System.out.println("After salary day: " + testOne.getCurrency() + "\n");

        System.out.println("Before salary day: " + testTwo.getCurrency());
        testTwo.getSalary();
        System.out.println("After salary day: " + testTwo.getCurrency() + "\n");

        // Test method findSalary
        System.out.println("testOne's salary: " + testOne.findSalary());
        System.out.println("testTwo's salary: " + testTwo.findSalary() + "\n");

        // Test method getTuition
        System.out.println("testOne's tuition: " + testOne.getTuition());
        System.out.println("testTwo's tuition: " + testTwo.getTuition() + "\n");

        // Test method payTheTuition
        System.out.println("Before pay the tuition: " + testOne.getCurrency());
        testOne.payTheTuition();
        System.out.println("After pay the tuition: " + testOne.getCurrency() + "\n");

        System.out.println("Before pay the tuition: " + testTwo.getCurrency());
        testTwo.payTheTuition();
        System.out.println("After pay the tuition: " + testTwo.getCurrency());
    }
}
