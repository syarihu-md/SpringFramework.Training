package me.syarihu.service;

import me.syarihu.models.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Taichi Sato on 15/12/03.
 */
public class ProductSampleRun {
    public static void main(String[] args) {
        ProductSampleRun productSampleRun = new ProductSampleRun();
        productSampleRun.execute();
    }

    public void execute() {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("/config/applicationContext.xml");
        ProductServic productServic = context.getBean(ProductServic.class);
        Product product = productServic.findProduct();
        System.out.println(product);

        productServic.selectBookList().forEach(System.out::println);
    }
}
