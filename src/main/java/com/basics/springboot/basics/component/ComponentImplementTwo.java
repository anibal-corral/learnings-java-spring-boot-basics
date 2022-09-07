package com.basics.springboot.basics.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplementTwo implements ComponentDependency{
    @Override
    public void hello() {
        System.out.println("Hello World From Component Two");
    }
}
