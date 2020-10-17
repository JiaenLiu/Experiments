package com.company;

import org.jetbrains.annotations.NotNull;

public class Member {
    private String idNumber;
    private String name;
    private boolean sex;

    public Member(@NotNull Integer id, String n, boolean s) {
        if (id.toString().length()< 8) {
            System.out.println("Invalid Id Number");
            return;
        }
        idNumber = id.toString();
        name = n;
        sex = s;
    }

    public void setIdNumber(@NotNull Integer id) {
        if (id.toString().length()< 8) {
            System.out.println("Invalid Id Number");
            return;
        }
        idNumber = id.toString();
    }

    public void setName(String n) {
        name = n;
    }

    public void setSex(boolean sex1) {
        sex = sex1;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getName() {
        return name;
    }

    public boolean getSex() {
        return sex;
    }

}
