package org.brackinapps.{{cookiecutter.app_name}};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class {{cookiecutter.app_name_cap}}Application {

    public static void main(String[] args) {
        SpringApplication.run({{cookiecutter.app_name_cap}}Application.class, args);
    }

}