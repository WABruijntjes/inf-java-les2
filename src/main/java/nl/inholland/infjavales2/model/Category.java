package nl.inholland.infjavales2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {

    @Id //Determine the 'private long id' as @Id for db mapping
    @GeneratedValue //Determine that 'id' is a generated value
    private long id;

    private String name;

    @JsonBackReference //Avoid JSON loop
    @OneToMany(mappedBy = "category")
    private Set<Product> products;

    public Category(){

    }

    public Category(String name) {
        this.name = name;
    }

    // ID getters & setters

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

    //Products in category getters & setters

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

}
