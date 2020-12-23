package ru.markelov.hibernate.lesson6.daoService;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.markelov.hibernate.lesson6.model.Buyer;

@Component
public class DaoBuyer {

    private Factory factory;

    @Autowired
    public DaoBuyer (Factory factory){
        this.factory = factory;
    }

    public void init(){
        factory.start();
    }

    public void createBuyer(Buyer buyer){
        init();
        try (Session session = factory.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            session.saveOrUpdate(buyer);
            session.getTransaction().commit();
        }
    }

    public Buyer getBuyer(int id){
        init();
        try(Session session = factory.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            session.getTransaction().commit();
            return buyer;
        }
    }

    public void updateBuyer(Buyer buyer){
        init();
        try(Session session = factory.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            Buyer newBuyer = session.get(Buyer.class, buyer.getId());
//            newBuyer.setId(buyer.getId());
            newBuyer.setName(buyer.getName());
            session.getTransaction().commit();
        }
    }

    public void deleteBuyer(int id){
        init();
        try(Session session = factory.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            session.delete(buyer);
            session.getTransaction().commit();
        }
    }
}
