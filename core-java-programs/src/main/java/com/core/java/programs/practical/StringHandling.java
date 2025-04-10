package com.core.java.programs.practical;

public class StringHandling {
    public static void main(String[] args) {
        String str1 = new String("Java");
        String str2 = new String("Java");
        System.out.println(str1 == str2); // false
        System.out.println(str1.equals(str2)); // true

        String str3 = "Java";
        String str4 = "Java";
        System.out.println(str3 == str2); //false
        System.out.println(str3.equals(str2)); // true
        System.out.println(str3 == str4);      // true
        System.out.println(str3.equals(str4)); //true

        String str5 = str3.intern();
        System.out.println(str3 == str5);  // true
        System.out.println(str3.equals(str5)); // true
    }
}
