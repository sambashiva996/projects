package com.core.java.programs.practical.inventory;

import lombok.Data;


public class Electronics extends Product{

    public Electronics(String name, String brand) {
        super(name, brand, "ELE");
    }

    @Override
    protected String getCategoryCode() {
        return getCategory();
    }
}
