package com.javadeveloperzone.hateoas.controller;

import com.javadeveloperzone.hateoas.exception.UserNotFoundException;
import com.javadeveloperzone.hateoas.model.User;
import com.javadeveloperzone.hateoas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/user/{id}", produces = {"application/hal+json"})
    public Resource<User> getUser(@PathVariable(value = "id", required = true) Long id) {
        User user = userService.getUserById(id).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("User not found with id - " + id);
        }
        user.add(linkTo(methodOn(UserController.class).getUser(id)).withSelfRel().withType("GET"));
        return new Resource<User>(user);
    }

    @GetMapping(value = "/users", produces = {"application/hal+json"})
    public Resources<User> getUsers() {

        List<User> users = userService.getAllUsers();
        for (User user : users) {
            Long userId = user.getUserId();
            user.add(linkTo(methodOn(UserController.class).getUser(userId)).withRel("get_user").withType("GET"));
            user.add(linkTo(methodOn(UserController.class).deleteUser(userId)).withRel("delete_user").withType("DELETE"));
        }

        Link link = linkTo(methodOn(UserController.class).getUsers()).withSelfRel().withType("GET");
        return new Resources<User>(users, link);
    }

    @DeleteMapping(value = "/user/{id}", produces = {"application/hal+json"})
    public Resource<User> deleteUser(@PathVariable(value = "id", required = true) Long id) {

        Optional<User> user = userService.getUserById(id);

        if (!user.isPresent()) {
            throw new UserNotFoundException("User not found with id - " + id);
        }

        userService.deleteUserById(id);
        User userNull = new User();
        userNull.add(linkTo(methodOn(UserController.class).getUsers()).withRel("get_users").withType("GET"));
        return new Resource<User>(userNull);
    }
}