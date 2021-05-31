package com.repositories;

import com.entites.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProductDAO {
    private SessionFactory factory;
    private Session session;

    public ProductDAO() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
    }

    public Product findById(Long id) {
        session = factory.getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.getTransaction().commit();
        return product;
    }

    public List<Product> findAll() {
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<Product> productList = session.createQuery("from Product").getResultList();
        session.getTransaction().commit();
        return productList;
    }

    public void deleteById(Long id) {
        session = factory.getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.delete(product);
        session.getTransaction().commit();
    }

    public Product saveOrUpdate(Product product) {
        session = factory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(product);
        session.getTransaction().commit();
        return product;
    }
}
