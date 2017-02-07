package me.syarihu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HelloController {


    @RequestMapping(value = "/hello", method = GET)
    public String index(Map<String, Object> model) {

        model.put("title", "Hello");
        model.put("msg", "Hello World!!");

        return "user";
    }

}
