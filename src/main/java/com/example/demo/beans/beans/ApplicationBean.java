package com.example.demo.beans.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ApplicationBean {
    private int count;

    public ApplicationBean (){
        count = 0;
    }

    public int getCount() {
        System.out.println("Incrementing count on ApplicationBean: " + count);
        return count++;
    }
}
