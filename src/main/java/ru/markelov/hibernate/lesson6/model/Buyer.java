package ru.markelov.hibernate.lesson6.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "buyer")
public class Buyer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "buyers_products", joinColumns = @JoinColumn(name = "buyers_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    public Buyer() {
    }

    public Buyer(String name) {
        this.name = name;
    }

    public Buyer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
