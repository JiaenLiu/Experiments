package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        try {
            // Args
            String name1 = args[0];
            String name2 = args[1];
            boolean sex1 = false;
            boolean sex2 = false;
            int tuition = Integer.parseInt(args[4]);
            int salary1 = Integer.parseInt(args[5]);
            int salary2 = Integer.parseInt(args[6]);

            if (args[2].equals("male")) {
                sex1 = true;
            }
            Postgraduates testOne = new Postgraduates(name1, sex1, tuition, salary1);
            Postgraduates testTwo = new Postgraduates(name2, sex2, tuition, salary2);
             // Test body

        
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
        catch (Exception e) {
            System.out.println(e.toString());
        }
       

    }
}
