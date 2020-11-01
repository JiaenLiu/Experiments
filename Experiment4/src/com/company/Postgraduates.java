package com.company;

public class Postgraduates implements Teacher,Student {
    private String name;
    private boolean sex;
    private double tuition;
    private double salary;
    private double currency;

    /**
     * Constructor
     * @param name the name of this postgraduate
     * @param sex  the sex of this postgraduate
     * @param tuition the tuition that this postgraduate should pay
     * @param salary the salary that this postgraduate can get
     */


    public Postgraduates(String name, boolean sex,
                         double tuition, double salary) {
        if (tuition < 0 && salary < 0) {
            System.out.println("Invalid tuition or salary");
            return;
        }
        this.name = name;
        this.sex = sex;
        this.tuition = tuition;
        this.salary = salary;
        this.currency = 10000;
    }

    public double getTuition() {
        return tuition;
    }

    /**
     *  This method is used to pay the tuition
     */

    public void payTheTuition() {
        currency = currency - tuition;
    }

    public double getCurrency() {
        return currency;
    }

    public double tax() {
        double tax = 0;
        double income = salary * 12;
        double allTuition = tuition * 2;
        double maxCurrency = income - allTuition;

        if (maxCurrency <= Teacher.lever1) {
            if (maxCurrency < 0) {
                tax = 0;
            }
            tax = tax + maxCurrency * Teacher.tax1;
        }
        else if (Teacher.lever1 < maxCurrency && maxCurrency <= Teacher.lever2) {
            tax = Teacher.lever1 * Teacher.tax1 + (maxCurrency - Teacher.lever1) * Teacher.tax2;
        }

        else if (Teacher.lever2 < maxCurrency && maxCurrency <= Teacher.lever3) {
            tax = Teacher.lever1 * Teacher.tax1 + (Teacher.lever2 - Teacher.lever1) * Teacher.tax2
                    + (maxCurrency - Teacher.lever2) * Teacher.tax3;
        }

        else if (Teacher.lever3 < maxCurrency && maxCurrency <= Teacher.lever4) {
            tax = Teacher.lever1 * Teacher.tax1 + (Teacher.lever2 - Teacher.lever1) * Teacher.tax2
                    + (Teacher.lever3 - Teacher.lever2) * Teacher.tax3 + (maxCurrency - Teacher.lever3) * Teacher.tax4;
        }

        else if (Teacher.lever4 < maxCurrency && maxCurrency <= Teacher.lever5) {
            tax = Teacher.lever1 * Teacher.tax1 + (Teacher.lever2 - Teacher.lever1) * Teacher.tax2
                    + (Teacher.lever3 - Teacher.lever2) * Teacher.tax3 + (Teacher.lever4 - Teacher.lever3) * Teacher.tax4
                    + (maxCurrency - Teacher.lever4) * Teacher.tax5;
        }

        else if (Teacher.lever5 < maxCurrency && maxCurrency <= Teacher.lever6) {
            tax = Teacher.lever1 * Teacher.tax1 + (Teacher.lever2 - Teacher.lever1) * Teacher.tax2
                    + (Teacher.lever3 - Teacher.lever2) * Teacher.tax3 + (Teacher.lever4 - Teacher.lever3) * Teacher.tax4
                    + (Teacher.lever5 - Teacher.lever4) * Teacher.tax5 + (maxCurrency - Teacher.lever5) * Teacher.tax6;
        }

        else if (maxCurrency > Teacher.lever6) {
            tax = Teacher.lever1 * Teacher.tax1 + (Teacher.lever2 - Teacher.lever1) * Teacher.tax2
                    + (Teacher.lever3 - Teacher.lever2) * Teacher.tax3 + (Teacher.lever4 - Teacher.lever3) * Teacher.tax4
                    + (Teacher.lever5 - Teacher.lever4) * Teacher.tax5 + (Teacher.lever6 - Teacher.lever5) * Teacher.tax6
                    + (maxCurrency - Teacher.lever6) * Teacher.tax7;
        }

        return tax;
    }

    public void getSalary() {
        currency = currency + salary;
    }

    public double findSalary() {
        return salary;
    }

}
