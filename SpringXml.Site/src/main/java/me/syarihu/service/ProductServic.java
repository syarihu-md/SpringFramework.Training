package me.syarihu.service;

import me.syarihu.models.Product;

import java.util.List;

/**
 * Created by Taichi Sato on 15/12/03.
 */
public interface ProductServic {
    Product findProduct();
    List<Product> selectBookList();
}
