package org.genspark;

import java.util.List;


public class student<Phone>
{

    private int id;
    private String name;
    private List<Phone> ph;
    private Address add;

    public student(int id, String name, List<Phone> ph, Address add) {
        this.id = id;
        this.name = name;
        this.ph = ph;
        this.add = add;
    }
    public student(){

    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ph=" + ph +
                ", add=" + add +
                '}';
    }
}

