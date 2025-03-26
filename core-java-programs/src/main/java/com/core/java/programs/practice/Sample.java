package com.core.java.programs.practice;

import com.core.java.programs.model.CreditCard;
import com.core.java.programs.model.Laptop;
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

        int fact = 5;
        System.out.println(factorial(fact));

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

    private static int factorial(int fact) {
        // 5*4*3*2*1 = 120
        int r = 0;
        while (fact > 0){

           r = fact * (fact - 1);

        }
        return r;
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
