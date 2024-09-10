package com.sdz.boot.springrest1;

import Config.MyConfig;
import Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class SpringRest1Application
{
    public static void main( String[] args ) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication", Communication.class);

        List<User> users = communication.getAllUsers();

        for (User user : users) {
            System.out.println(user);
        }

        User user = new User(3L, "James", "Brown", (byte) 20);

        String newUser = communication.addUser(user);

        user.setName("Thomas");
        user.setLastName("Shelby");

        String updatedUser = communication.updateUser(user);

        String deletedUser = communication.deleteUser(3L);

        System.out.println(newUser + updatedUser + deletedUser);
    }
}