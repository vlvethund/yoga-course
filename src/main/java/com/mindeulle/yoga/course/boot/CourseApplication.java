package com.mindeulle.yoga.course.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.mindeulle.yoga.course")
@SpringBootApplication(scanBasePackages = "com.mindeulle.yoga.course")
public class CourseApplication {

    public static void main(String[] args) {
        //
        SpringApplication.run(CourseApplication.class, args);
    }

}
