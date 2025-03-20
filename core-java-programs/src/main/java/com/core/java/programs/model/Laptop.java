package com.core.java.programs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Laptop {
    Integer id;
    String brand;
    String model;
    Double price;

    public static List<Laptop> getLaptopList(){
        return Arrays.asList(new Laptop(2, "samsung", "A1", 50000d),
                new Laptop(2, "apple", "A1", 60000d),
                new Laptop(2, "acer", "A2", 40000d),
                new Laptop(2, "hp", "A3", 55000d),
                new Laptop(2, "dell", "A4", 65000d));
    }

}
