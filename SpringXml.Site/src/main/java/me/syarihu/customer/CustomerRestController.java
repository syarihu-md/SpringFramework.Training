package me.syarihu.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;

/**
 * Created by Taichi Sato on 16/03/31.
 */
@Controller
@RequestMapping("/api/customer")
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String register(@RequestBody Customer customer) {
        customerService.register(customer);
        return "OK";
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<Customer> findById(@PathVariable int customerId) throws DataNotFoundException {
        Customer customer = customerService.findById(customerId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("text", "xml", Charset.forName("UTF-8")));
        headers.set("My-Header", "MyHeaderValue");
        return new ResponseEntity<>(customer, headers, HttpStatus.OK);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleException(DataNotFoundException ext) {
        return "customer is not found";
    }
}
