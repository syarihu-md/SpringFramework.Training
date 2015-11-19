package me.tomo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by usr0200379 on 15/10/02.
 */
@RestController
@RequestMapping(value = "/api")
public class HelloRestController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        return "Hello World!";
    }
}
