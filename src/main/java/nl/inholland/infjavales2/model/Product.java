package nl.inholland.infjavales2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Product {

    /////////// PARAMETERS ////////////

    @Id //Determine the 'private long id' as @Id for db mapping
    @GeneratedValue //Determine that 'id' is a generated value
    private long id;

    private String name;
    private String description;
    private double price;

    @JsonManagedReference //Avoid JSON loop
    @ManyToOne
    private Category category;

    ///////////////////////

    public Product() {
    }

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    //ID getters & setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //Name getters & setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Description getters & setters

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Price getters & setters

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //Category getters & setters

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
