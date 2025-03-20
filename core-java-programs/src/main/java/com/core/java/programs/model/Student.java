package com.core.java.programs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String firsName;
    private String lastName;
    private String city;
    private Double grade;
    private Integer age;
    private String department;

    public static List<Student> getStudentList(){
        return Arrays.asList(new Student("samba", "shivudu", "warangal", 9.5 ,25, "MPC"),
                new Student("test", "test", "warangal1", 8.8 ,26, "MPC"),
                new Student("test1", "test", "warangal", 7.5 ,25, "MPC2"),
                new Student("test2", "test", "warangal", 8.1 ,24, "MPC2"),
                new Student("test2", "test", "warangal1", 6.9 ,23, "MPC4"),
                new Student("test3", "test", "warangal2", 6.8 ,22, "MPC5"));
    }

}
