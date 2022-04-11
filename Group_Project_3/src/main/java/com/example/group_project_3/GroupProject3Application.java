package com.example.group_project_3;

import Service.HRManagerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackageClasses = {HRManagerService.class}) // Service Class
@EntityScan("Model")// Model Package
@EnableJpaRepositories("Repository")
public class GroupProject3Application {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(GroupProject3Application.class, args);
        HRManagerService hrManagerService = (HRManagerService) ctx.getBean("hrManagerService");
        hrManagerService.Test();
    }

}
