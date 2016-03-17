package me.syarihu.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Taichi Sato on 16/03/03.
 */
@Controller
@RequestMapping("/user")
public class UserListController {
    @RequestMapping
    public String getAllUsers(Model model) {
        model.addAttribute("title", "たいとる");
        return "user";
    }
}
