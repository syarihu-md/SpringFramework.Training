package me.syarihu.customer;

import java.util.List;

/**
 * Created by Taichi Sato on 16/03/03.
 */
public interface CustomerService {
    public List<Customer> findAll() throws DataNotFoundException;

    public Customer findById(int id);

    public Customer register(Customer customer);

    public void update(Customer customer) throws DataNotFoundException;

    public void delete(int id) throws DataNotFoundException;

    public boolean isFreeEmailCustomer(Customer customer);
}
