package iss.pos.test;

import iss.pos.Product;

import java.util.HashMap;

public class Products {
    static HashMap<String,Product> products = new HashMap<String, Product>(); 

    static 
    {
        products.put("A",    new Product("A", "Red Dress",   100.0));
        products.put("B",  new Product("B", "Green Dress", 100.0));
        products.put("C",   new Product("C", "Blue Dress",  100.0));
        products.put("D",  new Product("D", "White Socks", 10.0));
        products.put("E",    new Product("E", "Red Socks",   10.0));
    }

    public static Product GetProduct(String name)
    {
        return products.get(name);
    }

}
