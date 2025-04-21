package com.core.java.programs.practical.inventory;

import lombok.Data;

@Data
public abstract class Product {

    private String name;
    private String brand;
    private String category;

    public Product(String name, String brand, String category){
        this.name = name;
        this.brand = brand;
        this.category = category;
    }

    protected abstract String getCategoryCode();

    @Override
    public String toString() {
        return "Product{" +
                "nameCode='" + getNameCode() + '\'' +
                ", brandCode='" + getCategoryCode() + '\'' +
                ", SUK='" + getSUKCode() + '\'' +
                '}';
    }

    
    private String getSUKCode() {
        return brand+(int)(Math.random()*1000);
    }

    private String getBrandCode() {
        return brand.substring(0,3);
    }

    private String getNameCode() {
        return name.substring(0,3);
    }
}
