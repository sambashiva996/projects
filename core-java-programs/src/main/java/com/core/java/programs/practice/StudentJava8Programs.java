package com.core.java.programs.practice;

import com.core.java.programs.model.Student;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentJava8Programs {
    public static void main(String[] args) {
        List<Student> studentList = Student.getStudentList();

        //Student java8 concepts

        /*Find all students from one city with grade more than 8*/

        List<Student> collect3 = studentList.stream()
                .filter(stu -> stu.getCity().equalsIgnoreCase("warangal") && stu.getGrade() > 8)
                .collect(Collectors.toList());

//        System.out.println(collect3);

        /*find the student with higher grade*/
        Optional<Student> max = studentList.stream().max(Comparator.comparingDouble(Student::getGrade));
//        System.out.println(max.get());

        /*count the number of students in each department*/

        Map<String, Long> collect4 = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));
//        System.out.println(collect4);

        /*find the average grade per department*/

        Map<String, Double> collect5 = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDepartment, Collectors.averagingDouble(Student::getGrade)));
//        System.out.println(collect5);

        /*sort the students by age then by grade*/
        List<Student> collect6 = studentList.stream()
                .sorted(Comparator.comparingInt(Student::getAge).thenComparingDouble(Student::getGrade))
                .collect(Collectors.toList());
//        System.out.println(collect6);

        /*get a comma separated list of student names*/
        String collect7 = studentList.stream()
                .map(stu -> stu.getFirsName()+" "+stu.getLastName())
                .collect(Collectors.joining(", "));
//        System.out.println(collect7);

        /*Check if all students are above 18*/
        boolean b = studentList.stream().allMatch(stu -> stu.getAge() > 18);
//        System.out.println(b);

        /*Find the department with the most students*/
        String s1 = studentList.stream().
                collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()))
                .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getKey).get();
//        System.out.println(s1);

        /*Partition student into grade > 8 and grade <= 8*/
        Map<Boolean, List<Student>> collect8 = studentList.stream().collect(Collectors.partitioningBy(stu -> stu.getGrade() > 8 && stu.getGrade() <= 8));
//        System.out.println(collect8);

        /*Find the student with Longest full name*/
        Optional<String> max1 = studentList.stream().map(stu -> stu.getFirsName() + " " + stu.getLastName()).max(Comparator.comparing(String::length));
//        System.out.println(max1.get());

        /*Using Collectors class*/

        /*print strings output : [samba,test,test1,test2,test2,test3]
         */
        String collect9 = studentList.stream().collect(Collectors.mapping(Student::getFirsName, Collectors.joining(",", "[", "]")));
        System.out.println(collect9);

        /*filter the ages of students more than 25 age*/
        List<Student> collect10 = studentList.stream().collect(Collectors.filtering(student -> student.getAge() > 25, Collectors.toList()));
        System.out.println(collect10);

        /**/
        Double collect11 = studentList.stream().collect(Collectors.averagingDouble(Student::getGrade));
        System.out.println(collect11);
        /**/
        List<Student> list1 = studentList.stream().collect(Collectors.collectingAndThen(Collectors.toList(), students -> students.stream().sorted())).toList();
        System.out.println(list1);
        /**/
        List<Student> collect12 = studentList.stream().map(Arrays::asList).collect(Collectors.flatMapping(m -> m.stream(), Collectors.toList()));
        System.out.println(collect12);
        /**/
        String s = studentList.stream().collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()))
                .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey).get();
        System.out.println(s);

    }
}
