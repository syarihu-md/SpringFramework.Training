package me.syarihu.service;

import me.syarihu.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Taichi Sato on 15/12/03.
 */
@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Product findProduct() {
        System.out.println("findProduct: ");
        return new Product("", 100);
    }

    @Override
    public List<Product> findAllProduct() {
        return jdbcTemplate.query("SELECT * FROM PRODUCT;", (rs, rowNum) -> {
            Product product = new Product();
            product.setId(rs.getInt("ID"));
            product.setName(rs.getString("NAME"));
            product.setPrice(rs.getInt("PRICE"));
            return product;
        });
    }
}
