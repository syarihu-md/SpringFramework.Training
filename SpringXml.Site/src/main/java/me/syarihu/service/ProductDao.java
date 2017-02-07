package me.syarihu.service;

import me.syarihu.models.Product;

import java.util.List;

public interface ProductDao {
    Product findProduct();

    List<Product> findAllProduct();
}
