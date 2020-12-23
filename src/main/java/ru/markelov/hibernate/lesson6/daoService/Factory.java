package ru.markelov.hibernate.lesson6.daoService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import ru.markelov.hibernate.lesson6.model.Buyer;
import ru.markelov.hibernate.lesson6.model.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@Component
public class Factory {
    public void start (){
        SessionFactory startFactory = new Configuration().configure("config/config.start.hibernate.xml").buildSessionFactory();
        Session currentSession;

        try {
            String sql1 = Files.lines(Paths.get("src/main/resources/sqlQueries/dropB_b.sql")).collect(Collectors.joining(" "));
            String sql2 = Files.lines(Paths.get("src/main/resources/sqlQueries/dropBuyer.sql")).collect(Collectors.joining(" "));
            String sql3 = Files.lines(Paths.get("src/main/resources/sqlQueries/dropProduct.sql")).collect(Collectors.joining(" "));
            String sql4 = Files.lines(Paths.get("src/main/resources/sqlQueries/products.sql")).collect(Collectors.joining(" "));
            String sql5 = Files.lines(Paths.get("src/main/resources/sqlQueries/buyers.sql")).collect(Collectors.joining(" "));
            String sql6 = Files.lines(Paths.get("src/main/resources/sqlQueries/b_p.sql")).collect(Collectors.joining(" "));
            String sql7 = Files.lines(Paths.get("src/main/resources/sqlQueries/addProducts.sql")).collect(Collectors.joining(" "));
            String sql8 = Files.lines(Paths.get("src/main/resources/sqlQueries/addBuyers.sql")).collect(Collectors.joining(" "));
            String sql9 = Files.lines(Paths.get("src/main/resources/sqlQueries/addP_b.sql")).collect(Collectors.joining(" "));

            currentSession = startFactory.getCurrentSession();
            currentSession.beginTransaction();
            currentSession.createNativeQuery(sql1).executeUpdate();
            currentSession.createNativeQuery(sql2).executeUpdate();
            currentSession.createNativeQuery(sql3).executeUpdate();
            currentSession.createNativeQuery(sql4).executeUpdate();
            currentSession.createNativeQuery(sql5).executeUpdate();
            currentSession.createNativeQuery(sql6).executeUpdate();
            currentSession.createNativeQuery(sql7).executeUpdate();
            currentSession.createNativeQuery(sql8).executeUpdate();
            currentSession.getTransaction().commit();
            currentSession = startFactory.getCurrentSession();
            currentSession.beginTransaction();
            currentSession.createNativeQuery(sql9).executeUpdate();
            currentSession.getTransaction().commit();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SessionFactory getSessionFactory (){
//        Configuration configuration = new Configuration().addAnnotatedClass(Product.class);
//        SessionFactory factory = configuration.buildSessionFactory();
        SessionFactory factory = new Configuration().configure("config/main.config.hibernatet.xml").buildSessionFactory();
        return factory;
    }
}
