
# 实验报告

## 实验目的

掌握Java中抽象类和抽象方法的定义；
掌握Java中接口的定义，熟练掌握接口的定义形式以及接口的实现方法

## 实验要求

学校为了给学生提供勤工俭学机会，也减轻授课教师的部分压力，准许博士研究生参与课程的助教工作。此时，该博士研究生有双重身份：学生和助教教师。

1. 设计两个管理接口：学生管理接口和教师管理接口。学生接口必须包括缴纳学费、查学费的方法；教师接口包括发放薪水和查询薪水的方法。
2. 设计博士研究生类，实现上述的两个接口，该博士研究生应具有姓名、性别、年龄、每学期学费、每月薪水等属性。（其他属性及方法，可自行发挥）
3. 编写测试类，并实例化至少两名博士研究生，统计他们的年收入和学费。根据两者之差，算出每名博士研究生的年应纳税金额（国家最新工资纳税标准，请自行检索）。

## 实验架构

创建main class Main用于测试与调试各个类的方法。创建类 class Postgraduates做为实现功能的class。定义两个interface，分别为Teacher，Students。
Class:
    Postgraduates: (姓名，性别，学费，薪水，当前现金)
Interface:
    Students: (getTuition,payTheTuition,getCurrency)
    Teacher: (Tax rate & lever data, getSalary,getCurrency,tax)

## 实验过程 & 核心代码

首先创建两个interface，并在其中设置好需要声明的函数和内置数据。
之后创建class Postgraduates，并在其中设置好内部接口和变量。并且完成两个interface 中所定义的method。之后编写Main class 用于调试。这里主类使用了运行时传入参数的方式进行调试。并且使用try-except-finally 的格式进行异常的捕获与处理。

这里对作为主要功能实现的两个函数payTheTuition，tax和异常处理结果进行说明。（具体说明详见注释）

```java
 /**
     *  This method is used to pay the tuition
     *  本方法较为简单，只是在currency上减去tuition。
     */

    public void payTheTuition() {
        currency = currency - tuition;
    }
```

```java
    /**
     * 本方法看似复杂，实际上十分简单，就是按照税率和税率等级进行多次条件判断，
     * 符合条件即按照税率计算方法得出该名研究生一年所应上交的税款。
     **/
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
```

```java
    try {
            // 这里就是很简单从运行时传入的参数列表中获取参数。
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

        }
        catch (Exception e) {
            // 进行异常的捕获并输出异常
            System.out.println(e.toString());
        }
```

## 实验结果

TestOne's tax is: 420.0

TestTwo's tax is: 3680.0

Before salary day: 10000.0
After salary day: 12000.0

Before salary day: 10000.0
After salary day: 16000.0

testOne's salary: 2000.0
testTwo's salary: 6000.0

testOne's tuition: 5000.0
testTwo's tuition: 5000.0

Before pay the tuition: 12000.0
After pay the tuition: 7000.0

Before pay the tuition: 16000.0
After pay the tuition: 11000.0

## 实验感想

本次实验原理较为简单，工作量也不是很大。掌握了Interface的使用方法和规则，简单的异常处理与捕获和运行主类是参数的传递方法以后即可轻松完成本次实验。
