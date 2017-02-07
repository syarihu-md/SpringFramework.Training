package me.syarihu.service;

import me.syarihu.models.Product;

import java.util.List;

public interface ProductServic {
    Product findProduct();
    List<Product> selectBookList();
}
