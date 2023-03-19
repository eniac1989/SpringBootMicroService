package com.alipour.rest.webservices.restfulwebservices.controller;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * @author Paniz Alipour
 */

@RestController
public class HelloWorldController {

    private MessageSource messagesSource;

    public HelloWorldController(MessageSource messagesSource) {
        this.messagesSource = messagesSource;
    }

    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world-bean-param/{name1}")
    public HelloWorldBean HelloWorldBeanWithParameters(@PathVariable String name1) {
        return new HelloWorldBean(String.format("Hello World, %s", name1));
    }

    @GetMapping(path = "/hello-world-internationalization")
    public String helloWorldInternationnalized() {
        Locale locale = LocaleContextHolder.getLocale();
        return messagesSource.getMessage("good.morning.messages",null,"default message",locale);
    }
}
