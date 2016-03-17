package me.syarihu.customer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Taichi Sato on 16/03/03.
 */
@Service
public class MockCustomerService implements CustomerService {
    List<Customer> list;

    public MockCustomerService() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Customer(i, "name" + i, "address" + i, "email" + i));
        }
    }

    @Override
    public List<Customer> findAll() throws DataNotFoundException {
        return list;
    }

    @Override
    public Customer findById(int id) {
        return list.stream().filter(method -> method.getId() == id).collect(Collectors.toList()).get(0);
    }

    @Override
    public Customer register(Customer customer) {
        return list.add(customer) ? customer : null;
    }

    @Override
    public void update(Customer customer) throws DataNotFoundException {
        for (Customer cus : list) {
            if (cus.getId() == customer.getId()) {
                cus.setName(customer.getName());
                cus.setAddress(customer.getAddress());
                cus.setEmailAddress(customer.getEmailAddress());
                break;
            }
        }
    }

    @Override
    public void delete(int id) throws DataNotFoundException {
        if (!list.removeIf(method -> method.getId() == id)) {
            throw new DataNotFoundException();
        }
    }

    @Override
    public boolean isFreeEmailCustomer(Customer customer) {
        return customer.isFreeEmail();
    }
}
