package com.basics.springboot.basics.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency{
    @Override
    public void hello() {
        System.out.println("Hello world from ComponentImplement ");
    }
}
