package ru.markelov.hibernate.lesson6.daoService;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.markelov.hibernate.lesson6.model.Buyer;
import ru.markelov.hibernate.lesson6.model.Product;

import java.util.List;

@Component
public class InfoService {

    private Factory factory;

    @Autowired
    public InfoService(Factory factory){
        this.factory = factory;
    }

    public List<Product> getProductListById(int id){
        init();
        List<Product> productList;
        try (Session session = factory.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            productList = buyer.getProducts();
            Product product = productList.get(0);
            session.getTransaction().commit();
        }
        return productList;
    }

    public List<Buyer> getBuyerListById(int id){
        init();
        List<Buyer> buyerList;
        try(Session session = factory.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
//            buyerList = session.get(Product.class, id).getBuyers();
            buyerList = product.getBuyers();
            Buyer buyer = buyerList.get(0);
            session.getTransaction().commit();
        }
        return buyerList;
    }

    public void init(){
        factory.start();
    }
}
