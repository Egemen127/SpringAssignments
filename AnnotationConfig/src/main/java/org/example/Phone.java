package org.example;

import org.springframework.stereotype.Component;

@Component
public class Phone
{
    private String mob;

    @Override
    public String toString() {
        return "Phone{" +
                "mob='" + mob + '\'' +
                '}';
    }
}
