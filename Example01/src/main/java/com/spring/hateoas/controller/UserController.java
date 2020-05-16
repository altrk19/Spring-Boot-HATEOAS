package com.spring.hateoas.controller;

import com.spring.hateoas.model.User;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UserController {

    @GetMapping("/all")
    public List<User> getAll() {
        User users1 = getUser();
        User users2 = new User("Sam", 2400L);
        return Arrays.asList(users1, users2);
    }

    private User getUser() {
        User user = new User("Peter", 2300L);
        Link link = ControllerLinkBuilder.linkTo(UserController.class)
                .slash(user.getName())
                .withSelfRel();
        user.add(link);
        return user;
    }

    @GetMapping(value = "/hateoas/all", produces = MediaTypes.HAL_JSON_VALUE)
    public List<User> getHateOASAll() {
        User user1 = new User("Peter", 2300L);
        Link link = ControllerLinkBuilder.linkTo(UserController.class)
                .slash(user1.getSalary()).withSelfRel();
        Link link2 = ControllerLinkBuilder.linkTo(UserController.class)
                .slash(user1.getSalary()).withRel("salary");
        user1.add(link, link2);
        User user2 = new User("Sam", 2400L);
        user2.add(ControllerLinkBuilder.linkTo(UserController.class)
                .slash(user2.getSalary()).withSelfRel());
        return Arrays.asList(user1, user2);
    }
}
