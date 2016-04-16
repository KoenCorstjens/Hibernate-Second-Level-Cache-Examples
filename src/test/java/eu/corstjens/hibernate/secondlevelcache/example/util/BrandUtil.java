package eu.corstjens.hibernate.secondlevelcache.example.util;


import eu.corstjens.hibernate.secondlevelcache.example.model.*;

import java.util.List;
import java.util.Set;

/**
 * Created by koencorstjens on 17/04/16.
 */
public class BrandUtil {
    public static void printBrandShopAddress(List<Brand> brands) {
        for (Brand brand : brands) {
            System.out.println("Brand Id: " + brand.getId());
            System.out.println("Brand Name: " + brand.getName());
            System.out.println("Shops: ");
            for (Shop shop : brand.getShops()) {
                System.out.println("  " + shop.getName());
                for (Address address : shop.getAddress()) {
                    System.out.println("    " + address.getUrl());
                }
            }
            System.out.println("--------------------");
        }
    }

    public static void printBrandShop(Set<Brand> brands) {
        for (Brand brand : brands) {
            System.out.println("Brand Id: " + brand.getId());
            System.out.println("Brand Name: " + brand.getName());
            System.out.println("Shops: ");
            for (Shop shop : brand.getShops()) {
                System.out.println("  " + shop.getName());
            }
            System.out.println("--------------------");
        }
    }

    public static void print(List<Category> categories) {
        for (Category category : categories) {
            System.out.println("category Id: " + category.getId());
            System.out.println("category Name: " + category.getName());
            System.out.println("producten: ");
            for (Product product : category.getProducts()) {
                System.out.println("  " + product.getName());
            }
            System.out.println("--------------------");
        }
    }
}
