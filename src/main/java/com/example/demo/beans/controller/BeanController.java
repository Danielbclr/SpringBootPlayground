package com.example.demo.beans.controller;

import com.example.demo.beans.beans.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import javax.inject.Provider;

@RestController
@RequestMapping("/api/scope")
public class BeanController {

    @Autowired
    private SingletonBean singletonBean;

    @Autowired
    private ObjectProvider<PrototypeBean> prototypeBeanProvider;

    @Autowired
    private ObjectFactory<RequestBean> requestBeanFactory;

    @Autowired
    private ObjectFactory<SessionBean> sessionBeanFactory;

    @Autowired
    private ApplicationBean applicationBean;

    @RequestMapping(value = "/singleton", method = RequestMethod.GET)
    public String singleTonScope() {
        return "From Singleton Bean " + singletonBean.getCount();
    }

    @RequestMapping(value = "/prototype", method = RequestMethod.GET)
    public String protoTypeBean() {
        PrototypeBean prototypeBean1 = prototypeBeanProvider.getObject();
        PrototypeBean prototypeBean2 = prototypeBeanProvider.getObject();

        int firstCount = prototypeBean1.getCount();
        int secondCount = prototypeBean2.getCount();

        return "First Count: " + firstCount + " Second Count: " + secondCount;
    }

    @RequestMapping(value = "/request", method = RequestMethod.GET)
    public String requestScope(HttpServletRequest httpServletRequest) {
        return "From Request Scope " + requestBeanFactory.getObject().getCount() +
                " Hash Code: " + httpServletRequest.hashCode();
    }

    @RequestMapping(value = "/session", method = RequestMethod.GET)
    public String sessionScope(HttpServletRequest httpServletRequest) {
        return "From Session Scope " + sessionBeanFactory.getObject().getCount() +
                " Hash Code: " + httpServletRequest.hashCode();
    }

    @RequestMapping(value = "/application", method = RequestMethod.GET)
    public String applicationScopedBean() {
        return "From Application Scope: " + applicationBean.getCount();
    }
}
