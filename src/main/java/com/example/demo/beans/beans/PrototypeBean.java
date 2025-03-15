package com.example.demo.beans.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PrototypeBean {

    private int count;

    public PrototypeBean (){
        count = 0;
    }

    public int getCount() {
        System.out.println("Incrementing count on PrototypeBean: " + count);
        return count++;
    }
}
