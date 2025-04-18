package com.core.java.programs.practical.inventory;

public class Furniture extends Product {
    public Furniture(String name, String brand) {
        super(name, brand, "FUN");
    }

    @Override
    protected String getCategoryCode() {
        return getCategory();
    }
}
