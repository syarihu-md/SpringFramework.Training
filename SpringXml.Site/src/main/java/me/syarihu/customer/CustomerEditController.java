package me.syarihu.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping(value = "/enter", params = "_event_proceed", method = RequestMethod.POST)
    public String verify(@Validated @ModelAttribute("editCustomer") Customer customer, Errors errors) {
        if (errors.hasErrors()) {
            return "customer/edit/enter";
        }
        return "redirect:review";
    }

    @RequestMapping(value = "/review", method = RequestMethod.GET)
    public String showReview() {
        return "customer/edit/review";
    }

    @RequestMapping(value = "/review", params = "_event_confirmed", method = RequestMethod.POST)
    public String edit(@ModelAttribute("editCustomer") Customer customer, RedirectAttributes redirectAttributes, SessionStatus sessionStatus) throws DataNotFoundException {
        customerService.update(customer);
        redirectAttributes.addFlashAttribute("editCustomer", customer);
        sessionStatus.setComplete();
        return "redirect:/customer";
    }

    @RequestMapping(value = "/review", params = "_event_revise", method = RequestMethod.POST)
    public String revise(@ModelAttribute("editCustomer") Customer customer, Model model) throws DataNotFoundException {
        model.addAttribute("editCustomer", customer);
        return "redirect:enter";
    }

    @RequestMapping(value = "/edited", method = RequestMethod.GET)
    public String showEdited(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "customer/edit/edited";
    }
}
