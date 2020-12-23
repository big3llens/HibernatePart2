package ru.markelov.hibernate.lesson6;

//import ru.markelov.hibernate.lesson6.daoClass.DaoClass;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.markelov.hibernate.lesson6.config.Config;
import ru.markelov.hibernate.lesson6.daoService.DaoBuyer;
import ru.markelov.hibernate.lesson6.daoService.DaoProduct;
import ru.markelov.hibernate.lesson6.daoService.Factory;
import ru.markelov.hibernate.lesson6.daoService.InfoService;
import ru.markelov.hibernate.lesson6.model.Buyer;
import ru.markelov.hibernate.lesson6.model.Product;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        DaoProduct daoProduct = context.getBean("daoProduct", DaoProduct.class);
        daoProduct.craeteProduct(new Product( "Meat", 80));
//        System.out.println(daoProduct.getProduct(5));
//        daoProduct.updateProduct(new Product(5, "Meat", 75));
//        daoProduct.deleteProduct(5);
        DaoBuyer daoBuyer = context.getBean("daoBuyer", DaoBuyer.class);
//        daoBuyer.createBuyer(new Buyer("Lana"));
//        System.out.println(daoBuyer.getBuyer(2));
//        daoBuyer.updateBuyer(new Buyer(1, "Mickkk"));
//        daoBuyer.deleteBuyer(1);

        InfoService infoService = context.getBean("infoService", InfoService.class);

//        for (Product p: infoService.getProductListById(2)) {
//            System.out.println(p.toString());
//        }

//        for (Buyer b: infoService.getBuyerListById(4)) {
//            System.out.println(b.toString());
//        }
    }
}


