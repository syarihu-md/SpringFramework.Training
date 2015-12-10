package me.syarihu.service;

import me.syarihu.models.Product;
import org.springframework.stereotype.Component;

/**
 * Created by Taichi Sato on 15/12/03.
 */
@Component
public class ProductDaoImpl implements ProductDao {
    @Override
    public Product findProduct(String name) {
        return new Product(name, 100);
    }
}
