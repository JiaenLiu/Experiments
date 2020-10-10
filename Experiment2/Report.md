# 第二次 Java 实验报告

## 实验内容

基本要求：完成教材p110 第四题关于PC、内存等模拟的程序。 附加要求： 类中定义不少于两个构造方法； 每个类定义不少于2个属性，且属性的类型应该多样化； 根据课堂中关于访问权限的内容，尝试定义属性的修饰符多样化，类中定义方法操作属性，避免直接通过“类对象.属性”的形式访问属性值；且定义的方法内应该有符合常理的逻辑判断； 尝试把本次实验的多个类放置在不同的包中，体会修饰符private的用法。

## 实验过程

创建主类test。创建cpu，hardDisk，和pc类。

## 实验方法

创建主类test用于运行，并且在创建的cpu，hardDisk，pc类中变量用private进行修饰。并且在各个子类中编写setter & getter。在setter和getter中加入逻辑判断语句。

## 核心代码

```java
// In class CPU
    CPU(int Speed, String brand) {
        if (Speed < 0) {
            System.out.println("Initial speed failed");
            return;
        }
        if (!brand.equals("Inter") && !brand.equals("AMD")) {
            Brand = "Others";
            return;
        }
        this.Speed = Speed;
        Brand = brand;
    }

    public void setBrand(String brand) {
        if (!brand.equals("Inter") && !brand.equals("AMD")) {
            Brand = "Others";
            return;
        }
        Brand = brand;
    }

    public String getBrand() {
        return Brand;
    }

```

## 实验结果

在同一package Experiment2中的test主类运行时，不需要将constructor使用public修饰符进行修饰。当在不同包中使用Experiment2 中的constructor时，需要用public修饰符对constructor和对应类进行修饰。
>
运行结果如下：
>
Use default constructor
Use default constructor
Use default constructor
Use default constructor
Use default constructor
Cpu speed: 2200
Cpu brand: Inter
Hard Disk amount: 200

## 实验感想

在Java的使用与应用过程中，应当非常熟悉类与类之间的关系和掌握Java关于访问权的修饰符所代表的含义。
