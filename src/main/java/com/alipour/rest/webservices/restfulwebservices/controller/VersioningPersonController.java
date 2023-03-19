package com.alipour.rest.webservices.restfulwebservices.controller;

import com.alipour.rest.webservices.restfulwebservices.user.Name;
import com.alipour.rest.webservices.restfulwebservices.user.PersonV1;
import com.alipour.rest.webservices.restfulwebservices.user.PersonV2;
import com.alipour.rest.webservices.restfulwebservices.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VersioningPersonController {

    @GetMapping(path = "v1/person")
    PersonV1 firstVersionOfGetPerson() {
        return new PersonV1("Paniz Alipour");
    }

    @GetMapping(path = "v2/person")
    PersonV2 secondVersionOfGetPerson() {
        return new PersonV2(new Name("Paniz","Alipour"));
    }
}
