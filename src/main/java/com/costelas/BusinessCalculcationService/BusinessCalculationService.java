package com.costelas.BusinessCalculcationService;

import com.costelas.BusinessCalculcationService.db.Service;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class BusinessCalculationService {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(BusinessCalculationService.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(Service.class).findMax());
        }
    }
}
