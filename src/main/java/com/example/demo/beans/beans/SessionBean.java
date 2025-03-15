package com.example.demo.beans.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionBean {

    private int count;

    public SessionBean(){
        count = 0;
    }

    public int getCount() {
        System.out.println("Incrementing count on SessionBean: " + count);
        return count++;
    }
}
