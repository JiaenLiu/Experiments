package com.company;

public interface Teacher {
    // Tax rate lever
    public final static double tax1 = 0.03;
    public final static double tax2 = 0.1;
    public final static double tax3 = 0.2;
    public final static double tax4 = 0.25;
    public final static double tax5 = 0.3;
    public final static double tax6 = 0.35;
    public final static double tax7 = 0.45;

    // Income lever
    public final static int lever1 = 36000;
    public final static int lever2 = 144000;
    public final static int lever3 = 300000;
    public final static int lever4 = 420000;
    public final static int lever5 = 660000;
    public final static int lever6 = 960000;

    public void getSalary();
    public double findSalary();
    public double getCurrency();
    public double tax();
}
