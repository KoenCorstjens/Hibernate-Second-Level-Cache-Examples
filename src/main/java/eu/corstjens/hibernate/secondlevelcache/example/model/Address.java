package eu.corstjens.hibernate.secondlevelcache.example.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by koencorstjens on 17/04/16.
 */
@Entity
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String url;

    @ManyToOne
    @JoinColumn(name = "SHOPID")
    private Shop shop;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
