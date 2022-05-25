package org.genspark;

public class Phone
{

    private String mob;

    public Phone(String mob) {
        this.mob = mob;
    }
    public Phone(){}

    @Override
    public String toString() {
        return "Phone{" +
                "mob='" + mob + '\'' +
                '}';
    }
}

