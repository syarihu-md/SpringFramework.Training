package me.syarihu.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CustomerListController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String showAllCustomer(Model model) throws DataNotFoundException {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customer/list";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "forward:/customer";
    }

    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
    public String showCustomerDetail(@PathVariable int customerId, Model model) throws DataNotFoundException {
        Customer customer = customerService.findById(customerId);
        model.addAttribute("customer", customer);
        return "customer/detail";
    }

    @ExceptionHandler(DataNotFoundException.class)
    public String handleException(DataNotFoundException exception, Model model) {
        model.addAttribute("exception", exception);
        return "customer/notfound";
    }

    @ExceptionHandler
    public String handleException(Exception exception, Model model) {
        model.addAttribute("exception", exception);
        return "customer/notfound";
    }
}
