package com.core.java.programs.practical.inventory;

import java.util.ArrayList;
import java.util.List;

public class ProductInventoryByTemplatePattern {

    public static void main(String[] args){
        List<Product> productInventory = new ArrayList<>();
        productInventory.add(new Electronics("smartPhone", "SAMSUNG"));
        productInventory.add(new Furniture("chair", "NeelKamal"));

        productInventory.forEach(System.out::println);

    }

}
