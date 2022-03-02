package com.mindeulle.yoga.course.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableMongoRepositories(basePackages = "com.mindeulle.yoga.course")
@EnableWebSecurity
@EnableCaching
@SpringBootApplication(scanBasePackages = "com.mindeulle.yoga.course")
public class CourseApplication {

    public static void main(String[] args) {
        //
        SpringApplication.run(CourseApplication.class, args);
    }

}
