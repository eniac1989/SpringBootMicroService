package com.alipour.rest.webservices.restfulwebservices.controller;

import com.alipour.rest.webservices.restfulwebservices.exceptionmgr.UserNotFoundException;
import com.alipour.rest.webservices.restfulwebservices.service.UserDaoService;
import com.alipour.rest.webservices.restfulwebservices.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

/**
 * @author Paniz Alipour
 */
@RestController
public class UserController {

    private UserDaoService userDaoService;

    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping(path = "/users")
    private List<User> findAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    private User findUser(@PathVariable int id) throws UserNotFoundException {
        User findOne = userDaoService.findOne(id);
        if (findOne == null)
            throw new UserNotFoundException("id: " + id);
        return findOne;
    }

    @PostMapping(path = "/users")
    private ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
        User savedUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    private void deleteUser(@PathVariable Integer id) {
        if (userDaoService.findOne(id) == null)
            throw new UserNotFoundException(" user with id: " + id + " not found");
        userDaoService.deleteUser(id);
    }
}
