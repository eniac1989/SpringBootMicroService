package com.alipour.rest.webservices.restfulwebservices.controller;

import com.alipour.rest.webservices.restfulwebservices.exceptionmgr.UserNotFoundException;
import com.alipour.rest.webservices.restfulwebservices.service.UserDaoService;
import com.alipour.rest.webservices.restfulwebservices.user.User;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
    List<User> findAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    private EntityModel<User> findUser(@PathVariable int id) throws UserNotFoundException {
        User findOne = userDaoService.findOne(id);
        if (findOne == null)
            throw new UserNotFoundException("id: " + id);
        //"all-users",SERVER_PATH +"/USERS"
        //retrieveAllUsers
        EntityModel<User> entityModel = EntityModel.of(findOne);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;

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
