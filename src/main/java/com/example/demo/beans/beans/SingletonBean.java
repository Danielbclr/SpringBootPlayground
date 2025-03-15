package com.example.demo.beans.beans;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {
    private int count;

    public SingletonBean (){
        count = 0;
    }

    public int getCount() {
        System.out.println("Incrementing count on SingletonBean: " + count);
        return count++;
    }
}
