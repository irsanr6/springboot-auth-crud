package com.elibrary.crudauth.presenter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldPresenter {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
