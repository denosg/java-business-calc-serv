package com.costelas.lazyLauncher;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA {

}

// @Lazy waits for a use of the component for it to load, otherwise it won't
@Component
@Lazy
class ClassB {
    private ClassA classA;

    public ClassB(ClassA classA) {
        // Logic
        System.out.println("Some init logic");
        this.classA = classA;
    }

    public void doSomething() {
        System.out.println("Do something here");
    }
}

@Configuration
@ComponentScan
public class LazyInitLauncherApp {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(LazyInitLauncherApp.class)) {

            System.out.println("Init of context is competed");
            context.getBean(ClassB.class).doSomething();
        }
    }
}
