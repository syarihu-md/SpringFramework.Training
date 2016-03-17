package me.syarihu.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by Taichi Sato on 16/03/17.
 */
@Controller
@RequestMapping("/customer/{customerId}")
@SessionAttributes("editCustomer")
public class CustomerEditController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String redirectToEntryForm(@PathVariable int customerId, Model model) throws DataNotFoundException {
        Customer customer = customerService.findById(customerId);
        model.addAttribute("editCustomer", customer);
        return "redirect:enter";
    }

    @RequestMapping(value = "/enter", method = RequestMethod.GET)
    public String showEntryForm() {
        return "customer/edit/enter";
    }

}
