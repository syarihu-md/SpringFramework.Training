package me.syarihu.service;

import me.syarihu.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Taichi Sato on 15/12/03.
 */
@Component
public class ProductServicImpl implements ProductServic {
    @Autowired
    private ProductDao productDao;

    @Override
    public Product findProduct() {
        return productDao.findProduct();
    }

    @Override
    public List<Product> selectBookList() {
        return productDao.findAllProduct();
    }
}
