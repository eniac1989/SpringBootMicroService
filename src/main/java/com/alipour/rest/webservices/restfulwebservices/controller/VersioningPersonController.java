package com.alipour.rest.webservices.restfulwebservices.controller;

import com.alipour.rest.webservices.restfulwebservices.entity.Name;
import com.alipour.rest.webservices.restfulwebservices.entity.PersonV1;
import com.alipour.rest.webservices.restfulwebservices.entity.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(path = "person",params = "version=1")
    PersonV1 firstVersionOfGetPersonWithParams() {
        return new PersonV1("Paniz Alipour");
    }

    @GetMapping(path = "person",params = "version=2")
    PersonV2 secondVersionOfGetPersonWithParams() {
        return new PersonV2(new Name("Paniz","Alipour"));
    }

    @GetMapping(path = "person",headers = "X-API-VERSION=1")
    PersonV1 firstVersionOfGetPersonWithHeaders() {
        return new PersonV1("Paniz Alipour");
    }

    @GetMapping(path = "person",headers = "X-API-VERSION=2")
    PersonV2 secondVersionOfGetPersonWithHeaders() {
        return new PersonV2(new Name("Paniz","Alipour"));
    }

    @GetMapping(path = "person",produces = "application/vnd.company.app-v1+json")
    PersonV1 firstVersionOfGetPersonAcceptHeaders() {
        return new PersonV1("Paniz Alipour");
    }

    @GetMapping(path = "person",produces = "application/vnd.company.app-v2+json")
    PersonV2 secondVersionOfGetPersonWithAcceptHeaders() {
        return new PersonV2(new Name("Paniz","Alipour"));
    }
}
