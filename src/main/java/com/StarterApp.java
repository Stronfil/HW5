package com;

import com.entites.Product;
import com.repositories.ProductDAO;

public class StarterApp {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.findById(1L);

        System.out.println(productDAO.findById(1L));
        product.setTitle("new Umbrella");
        productDAO.saveOrUpdate(product);
        System.out.println(productDAO.findById(1L));

        System.out.println(productDAO.findAll());
        productDAO.deleteById(2L);
        System.out.println(productDAO.findAll());
    }
}
