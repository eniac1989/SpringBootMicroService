package com.alipour.rest.webservices.restfulwebservices.resource;

import com.alipour.rest.webservices.restfulwebservices.entity.Post;
import com.alipour.rest.webservices.restfulwebservices.exceptionmgr.UserNotFoundException;
import com.alipour.rest.webservices.restfulwebservices.repository.UserRepository;
import com.alipour.rest.webservices.restfulwebservices.service.UserDaoService;
import com.alipour.rest.webservices.restfulwebservices.entity.User;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author Paniz Alipour
 */
@RestController
public class UserResource {

    private UserDaoService userDaoService;
    private UserRepository userRepository;

    public UserResource(UserDaoService service, UserRepository repository) {
        this.userDaoService = service;
        this.userRepository = repository;
    }

    @GetMapping(path = "/jpa/users")
    List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/jpa/users/{id}")
    private EntityModel<User> findUser(@PathVariable int id) throws UserNotFoundException {
        Optional<User> findOne = userRepository.findById(id);
        if (findOne==null)
            throw new UserNotFoundException("id: " + id);
        //"all-users",SERVER_PATH +"/USERS"
        //retrieveAllUsers
        EntityModel<User> entityModel = EntityModel.of(findOne.get());
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;

    }

    @GetMapping(path = "/jpa/users/{id}/posts")
    private List<Post> retreivePostOfUser(@PathVariable int id) throws UserNotFoundException {

        Optional<User> findOne = userRepository.findById(id);

        if (findOne==null)
            throw new UserNotFoundException("id: " + id);
        List<Post> posts = findOne.get().getPosts();

        return posts;
    }



    @PostMapping(path = "/jpa/users")
    private ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    private void deleteUser(@PathVariable Integer id) {
        if (userRepository.findById(id) == null)
            throw new UserNotFoundException(" user with id: " + id + " not found");
        userRepository.deleteById(id);
    }

}
