
# 实验报告

## 实验目的

初步了解分析系统需求，从学生选课角度了解系统中的实体及其关系，学会定义类中的属性以及方法；
掌握面向对象的类设计方法（属性、方法）；
掌握类的继承用法，通过构造方法实例化对象；
学会使用super()，用于实例化子类；
掌握使用Object根类的toString（）方法,应用在相关对象的信息输出中。

## 实验要求

说明：学校有“人员”，分为“教师”和“学生”，教师教授“课程”，学生选择“课程”。从简化系统考虑，每名教师仅教授一门课程，每门课程的授课教师也仅有一位，每名学生选仅选一门课程。

## 实验架构

创建主类Main用于测试与调试各个类的方法。创建类Member，Teacher，Student和Course。Class Teacher and Student are sub-classes of Member.
这里我用ArrayList来存储教师所授与学生所选择的课程。
[EOF]
各个Class内容如下:
    人员（编号，姓名，性别）
    教师（编号，姓名，性别，所授课程，教授课程上限）
    学生（编号，姓名，性别，所选课程，选课学分上限，当前已选学分）
    课程（编号，课程名称，上课地点，时间，授课教师，选课人数上限，当前学生数目，课程学分）

## 实现过程&核心代码

首先创建父类Memner，并其中设置好内部变量和接口。这里使用了类Interger用于方便的输入id。之后创建class Teacher 和 Student时直接调用Member中的接口获取id等信息。所有Member的class只提供带有三个参数的constructor，三个参数分别是id(编号)，n(姓名),sex(性别)。class Teacher 的constructor则是在Member的基础上增加了参数u(授课上限)。而class Student 的constructor对应的增加了参数s(学分上限)。对于class Course 的结构和构造方法都与Member类似，并且Teacher，Student 和 Course 我都对它们的 toString 方法进行了复写(@Override)。其中 class Course 内的 toString 方法就是将其内部信息分行转换为String。

```java
    @Override
    public String toString() {
        String output;
        output = "Course ID Number: " + idNumber + " " + "Course Name: " + name + "\n"
            + "Location: " + location + " " + "Time: " + time + "\n" + "Teacher: " + teacher.getName() + "." + "\n";
        return output;
    }
```

并且对于class Teacher&Student 的 toString 方法。所进行的操作就是获取类内的name，并对存储课程的列表进行遍历循环，在循环中调用class Course中的 toString 方法，最后得到一个含有对应姓名和所教授课程的字符串。

以 class Teacher 内的 toString method为例。

```java
    @Override
    public String toString() {
        String output = "Teacher: " + this.getName() + "\n";
        for (Course c :courseToTeach) {
            output = output + c.toString();
        }
        return output;
    }
```

做好这些准备工作之后，就是给 class Teacher&Student 编写选课与退课方法了。这里对于两个类来说，方法大同小异，只是一些逻辑判断上有些差异。以 class Student 内的选退课方法为例。

```java
    // 选课方法
    public void addCourseToLearn(Course c) {
        this.findCurrentScore();
        // 这里对应与 class Teacher 这是判断授课列表的大小与授课上限的关系，合取上课程内部教师是否与该教师相同。代码如下：
        // I use key “This” to get current object and use it to find whether the Teacher object equals to the Teacher object in the course object.
        //if (courseToTeach.size() < upperbound && this.equals(course.getTeacher()))
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


    //退课方法
    public void unEnrollACourse(Course course) {
        // 两类中的退课方法完全一致。
        // It is same in previous method.
        if (courseToLearn.contains(course)) {
            courseToLearn.remove(course);
            System.out.println("Successfully unenroll course " + "\n" + course.toString());
            return;
        }
        System.out.println("You do not enroll this course" + "\n" + course.toString());
    }

    //打印所有选课学生
    // Print all students who have selected the course.
    public void addStudent(Student student) {
        // 该方法用于添加学生至学生列表中
        // Use this method to add a student to the student list.
        curStudents.add(student);
    }

    public void printCurrentStudents() {
        // 打印出所有的学生
        // Print out the current student list.
        for (Student s : curStudents) {
            String sex = "";
            if (s.getSex()) {
                sex = "male";
            }
            else {
                sex = "female";
            }

            String info = "姓名: " + s.getName() + " 学号: " + s.getIdNumber() + " 性别: " + sex;
            System.out.println(info);
        }
    }
```

## 实验结果

Test addCourse method:...

Successfully Added!!!!
Successfully Added!!!!
Too many course or Not the lecturer in this course.
Too many course or Not the lecturer in this course.
Test addCourseToLearn method:...

Successfully Added!!!!!!!
You can not choose more course due to your upperbound of scores or the course is full.
Successfully Added!!!!!!!
Successfully Added!!!!!!!
Test toString in class Course method:...

Course ID Number: 888873243 Course Name: Object-oriented Java Programming
Location: Library,room 605 Time: Monday 7:50-9:25
Teacher: Zhang.

Course ID Number: 888873243 Course Name: Discrete Math
Location: Library,room 505 Time: Wednesday 7:50-9:25
Teacher: Wei.

Test toString in class Teacher method:...

Teacher: Zhang
Course ID Number: 888873243 Course Name: Object-oriented Java Programming
Location: Library,room 605 Time: Monday 7:50-9:25
Teacher: Zhang.

Teacher: Wei
Course ID Number: 888873243 Course Name: Discrete Math
Location: Library,room 505 Time: Wednesday 7:50-9:25
Teacher: Wei.

Test toString in class Student method:...

Student: Liu
Course ID Number: 888873243 Course Name: Object-oriented Java Programming
Location: Library,room 605 Time: Monday 7:50-9:25
Teacher: Zhang.

Student: Guo
Course ID Number: 888873243 Course Name: Object-oriented Java Programming
Location: Library,room 605 Time: Monday 7:50-9:25
Teacher: Zhang.
Course ID Number: 888873243 Course Name: Discrete Math
Location: Library,room 505 Time: Wednesday 7:50-9:25
Teacher: Wei.

Test unEnrollACourse in class Teacher...

Successfully unenroll course
Course ID Number: 888873243 Course Name: Object-oriented Java Programming
Location: Library,room 605 Time: Monday 7:50-9:25
Teacher: Zhang.

You do not enroll this course
Course ID Number: 888873243 Course Name: Discrete Math
Location: Library,room 505 Time: Wednesday 7:50-9:25
Teacher: Wei.

Successfully unenroll course
Course ID Number: 888873243 Course Name: Discrete Math
Location: Library,room 505 Time: Wednesday 7:50-9:25
Teacher: Wei.

You do not enroll this course
Course ID Number: 888873243 Course Name: Object-oriented Java Programming
Location: Library,room 605 Time: Monday 7:50-9:25
Teacher: Zhang.

Test unEnrollACourse in class Student...

Successfully unenroll course
Course ID Number: 888873243 Course Name: Object-oriented Java Programming
Location: Library,room 605 Time: Monday 7:50-9:25
Teacher: Zhang.

You do not enroll this course
Course ID Number: 888873243 Course Name: Discrete Math
Location: Library,room 505 Time: Wednesday 7:50-9:25
Teacher: Wei.

Successfully unenroll course
Course ID Number: 888873243 Course Name: Object-oriented Java Programming
Location: Library,room 605 Time: Monday 7:50-9:25
Teacher: Zhang.

Successfully unenroll course
Course ID Number: 888873243 Course Name: Discrete Math
Location: Library,room 505 Time: Wednesday 7:50-9:25
Teacher: Wei.

Test output all students in a course

姓名: Liu 学号: 777778888 性别: male
姓名: Guo 学号: 777779999 性别: female

## 实验感想

本次实验原理较为简单，只是工作量稍微略大。把握好继承关系，java class 之间的访问规则，选取合适的辅助类，编写适当的辅助方法和适当的覆写方法即可十分轻松的完成本次实验。
