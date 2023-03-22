package com.alipour.rest.webservices.restfulwebservices.controller;

import com.alipour.rest.webservices.restfulwebservices.filtering.SomeBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author Paniz Alipour
 */
@RestController
public class StaticFiltering {

    @GetMapping("/filtering")
    private SomeBean filtering() {
        return new SomeBean("value1", "value2", "value3");
    }

    @GetMapping("/filtering-list")
    private List<SomeBean> filteringList() {
        return Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6"));
    }
}
