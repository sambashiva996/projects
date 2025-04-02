package com.core.java.programs.practice;

import com.core.java.programs.model.CreditCard;
import com.core.java.programs.model.Student;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Sample {
    public static void main(String[] args) {

        List<List<CreditCard>> objectList = new ArrayList<>();
        List<CreditCard> creditCardList = CreditCard.getCreditCard();
        objectList.add(creditCardList);

        List<Student> studentList = Student.getStudentList();
/////////////////////////////////////////////////////////////////////////

//        keyPadMobile();
/// ///////////////////////////////////////////////////////////////////
        int fact = 5;
//        System.out.println(factorial(fact));

        String collect4 = studentList.stream().sorted(Comparator.comparingInt(Student::getAge)).map(s -> s.getLastName()).collect(Collectors.joining("/"));

//        System.out.println(collect4);
/// ////////////////////////////////////////////////////////////////

//        rotateArray();
//////////////////////////////////////////////////

        String s = "sambashivuduambati";

		List<Character> characterList = Arrays.asList('a', 'e', 'i', 'o', 'u');
		Map<Character, Long> collect1 = s.chars()
                .boxed()
                .map(c -> (char) (int) c)
                .filter(characterList::contains)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //OR
        List<String> collect3 = Arrays.stream(s.split("")).filter(characterList::contains).collect(Collectors.toList());
//		System.out.println(collect);

        List<String> list = Arrays.asList("good", "morning");

        List<Character> collect = list.stream().flatMapToInt(String::chars).mapToObj(c -> (char) c).collect(Collectors.toList());
//        System.out.println(collect);

        List<CreditCard> collect2 = objectList.stream().flatMap(List::stream).collect(Collectors.toList());
//        System.out.println(collect1);

    }

    private static void keyPadMobile() {
        //input :
//        2 abc
//        3 def
//        4 ghi
//        5 jkl
//        6 mno
//        7 pqrs
//        8 tuv
//        9 wxyz
//output : 23 = ad, ae, af, bd, be, bf, cd, ce, cf

        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        String input = "23";

        StringBuffer sb = new StringBuffer();
        String[] split = input.split("");
//        for (String s : input.split("")){
        Integer num = Integer.parseInt(split[0]);
        Integer num1 = Integer.parseInt(split[1]);

        Set<Map.Entry<Integer, String>> entries = map.entrySet();

        String s1 = "";
        String s2 = "";
        List<String> list1 = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : entries){

            if (entry.getKey().equals(num)){
                s1 = s1+entry.getValue();
            }

            if (entry.getKey().equals(num1)){
                s2 = s2+entry.getValue();
            }
        }

        for (int i = 0; i < s1.length(); i++){

            for (int j = 0; j < s2.length(); j++){
                String s = s1.charAt(i) + "" + s2.charAt(j);
                list1.add(s);
            }
        }

        String join = String.join(", ", list1);

        //OR

        List<String> strings = Arrays.stream(input.split(""))
                .map(m -> map.get(Integer.parseInt(m)))
                .filter(Objects::nonNull)
                .map(m -> Arrays.asList(m.split("")))
                .reduce((r1, r2) -> r1.stream().flatMap(f -> r2.stream().map(f1 -> f + f1))
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());


        System.out.println(strings);
    }

    private static int factorial(int fact) {
        // 5*4*3*2*1 = 120
       if (fact == 0){
           return 1;
       }else {
           return fact * factorial(fact-1);
       }
    }

    private static void rotateArray() {

        int[] arr = new int[]{1,2,3,4,5,6};
        int rotate = 3;
        int arrLength = arr.length;
        //612345
        //561234
        //456123

        rotate = rotate % arrLength; //handles where rotate > allLength

        reverse(arr, 0, arrLength - 1); // reverse whole array
        reverse(arr, 0, rotate - 1); // reverse first rotate elements
        reverse(arr, rotate, arrLength - 1);

        System.out.println(Arrays.toString(arr));

    }

    private static void reverse(int[] arr, int startIndex, int lastIndex) {

        while(startIndex < lastIndex){
            int temp = arr[startIndex];
            arr[startIndex] = arr[lastIndex];
            arr[lastIndex] = temp;
            startIndex++;
            lastIndex--;
        }

    }


}
