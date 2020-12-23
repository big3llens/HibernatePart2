package ru.markelov.hibernate.lesson6.daoService;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.markelov.hibernate.lesson6.model.Product;

@Component
public class DaoProduct {

    private final Factory factory;

    @Autowired
    public DaoProduct(Factory factory){
        this.factory = factory;
    }

    public void craeteProduct(Product product){
        init();
        try(Session session = factory.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            session.saveOrUpdate(product);
            System.out.println(session.get(Product.class, product.getId()));
            session.getTransaction().commit();
        }
    }

    public Product getProduct(int id){
        init();
        try(Session session = factory.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    public void updateProduct(Product product){
        init();
        try(Session session = factory.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            Product newProduct = session.get(Product.class, product.getId());
            newProduct.setTitle(product.getTitle());
            newProduct.setCost(product.getCost());
            System.out.println(session.get(Product.class, newProduct.getId()));
            session.getTransaction().commit();
        }
    }

    public void deleteProduct(int id){
        init();
        try(Session session = factory.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    public void init(){
        factory.start();
    }
}
