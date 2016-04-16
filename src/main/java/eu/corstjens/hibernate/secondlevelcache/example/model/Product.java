package eu.corstjens.hibernate.secondlevelcache.example.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by koencorstjens on 17/04/16.
 */
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;

    @ManyToMany
    @JoinTable(name = "ProductCategory",
        joinColumns = @JoinColumn(name = "productId", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "categoryId", referencedColumnName = "id"))
    private List<Category> categories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
