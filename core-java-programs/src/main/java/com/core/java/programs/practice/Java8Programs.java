package com.core.java.programs.practice;

import com.core.java.programs.model.Student;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Programs {

    public static void main(String[] args) {

        /*Print prime Numbers in java8*/



/////////////////////////////////////////////////////////////////////////////////////////////

        /*Java 8*/
        /* print characters and count of character from given string*/
        String s = "Samba shivudu ambati";

        Map<String, Long> charAndCountOfChars = Arrays.stream(s.split(""))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

//        System.out.println(charAndCountOfChars);
/// //////////////////////////////////////////////////////////////////////////////////////////

        /*print all duplicate elements from given string*/

        String s2 = "samba shivudu ambati";

        List<String> duplicateCharList = Arrays.stream(s2.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(map -> map.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

//        System.out.println(duplicateCharList);
///////////////////////////////////////////////////////////////////////////////////////////////

        /*print all unique elements from given string*/

        String s3 = "samba shivudu ambati";

        List<String> uniqueElements = Arrays.stream(s3.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(map -> map.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

//        System.out.println(uniqueElements);
//////////////////////////////////////////////////////////////////////////////////////////////

        /*print first non repeat character from given string*/

        String s1 = "samba shivudu ambati";

        Optional<String> firstNonRepeatChar = Arrays.stream(s1.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(c -> c.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();

///////////////////////////////////////////////////////////////////////////////////////////////
        /*print first repeat character from given string*/

        Optional<String> optionalString = Arrays.stream(s1.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(f -> f.getValue() > 1)
                .map(Map.Entry::getKey).findFirst();
        optionalString.ifPresent(System.out::println);

//        System.out.println(firstNonRepeatChar.get());
///////////////////////////////////////////////////////////////////////////////////////////////

        /*slice the array with custom start and last index from
         *given input and in the output new sliced array based on indexes
         * */
        int startIndex = 4;
        int lastIndex = 8;

        int[] originalIntArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int[] slicedResult = Arrays.copyOfRange(originalIntArray, startIndex, lastIndex);
        /*OR*/
        int[] array = IntStream.range(startIndex, lastIndex).map(index -> originalIntArray[index]).toArray();
        /*OR*/
        List<Integer> collect1 = Arrays.stream(originalIntArray, startIndex, lastIndex).boxed().toList();

//        System.out.println(Arrays.toString(slicedResult));
/// ///////////////////////////////////////////////////////////////////////////////////////////

        /*print second-highest number from given array*/

        int[] numArray = {5,2,6,11,8,9};

        Optional<Integer> secondHighestElement = Arrays.stream(numArray)
                .boxed()
                .sorted((Comparator.reverseOrder()))
                .skip(1)
                .findFirst();

//        System.out.println(secondHighestElement.get());
//////////////////////////////////////////////////////////////////////////////////////////////

        /*print longest string from given array*/

        String[] strArray = {"samba", "shivudu", "ambati"};

        String longestString = Arrays.stream(strArray)
                .sorted((c1,c2) -> c2.length()-c1.length())
                .findFirst()
                .get();
        //OR using max method
        String longestString1 = Arrays.stream(strArray)
                .max(Comparator.comparing(String::length))
                .get();

        //OR using reduce method
        String s4 = Arrays.stream(strArray)
                .reduce((w1, w2) -> w1.length() > w2.length() ? w1 : w2)
                .get();

//        System.out.println(s4);
////////////////////////////////////////////////////////////////////////////////////////////

        /*print smallest string from given array*/

        String smallestStr = Arrays.stream(strArray)
                .min(Comparator.comparing(String::length))
                .get();
//        System.out.println(smallestStr);
////////////////////////////////////////////////////////////////////////////////////////////

       /*print all elements who start with 1 from given array*/

       int[] intArray = {2,4,1,6,11,12,8};

        List<String> numStartWith1 = Arrays.stream(intArray)
                .boxed()
                .map(num -> num.toString())
                .filter(num -> num.startsWith("1"))
                .collect(Collectors.toList());

//        System.out.println(numStartWith1);
//////////////////////////////////////////////////////////////////////////////////////////

        /*Using String join method prints all elements separated with '-' */

        List<String> joinStr = Arrays.asList("2", "4", "5", "6");
        String join = String.join("-", joinStr);
//        System.out.println(join);

//////////////////////////////////////////////////////////////////////////////////////////

        /*using limit and skip print specified values from range*/
        List<Integer> collect = IntStream.rangeClosed(1, 6)
                .boxed()
                .skip(1)
                .limit(4)
                .collect(Collectors.toList());
//        System.out.println(collect);
////////////////////////////////////////////////////////////////////////////////////////

        /*convert String Array to character array*/
        List<String> list = Arrays.asList("samba", "shivudu");

        char[] charArray = list.stream()
                .collect(Collectors.joining())
                .toCharArray();

        //OR

        List<String> collect11 = list.stream().map(m -> Arrays.asList(m.split("")))
                .flatMap(List::stream).collect(Collectors.toList());
//        System.out.println(collect11);

        //OR

        List<Character> collect2 = list.stream()
                .flatMapToInt(String::chars)
                .mapToObj(m -> (char) m)
                .collect(Collectors.toList());

//        System.out.println(collect2);
/////////////////////////////////////////////////////////////////////////////////////////

        /*
        * Print count of each vowel from given string
        * */
        String s5 = "sambashivuduambati";
        List<Character> characterList = Arrays.asList('a', 'e', 'i', 'o', 'u');

        Map<Character, Long> collect3 = s5.chars()
                .mapToObj(str -> (char) str)
                .filter(characterList::contains)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        System.out.println(collect3);
////////////////////////////////////////////////////////////////////////////////////////

        /* Rotate an array of integers by given number like 2 and 2 numbers should be rotated */
        int[] arr = {1,2,3,4,5,6};
        int rotate = 2;

        List<Integer> collect5 = IntStream.range(0, arr.length)
                .mapToObj(m -> arr[(m - rotate + arr.length) % arr.length]) // Circular shift
                .collect(Collectors.toList());
//        System.out.println(collect5);
/////////////////////////////////////////////////////////////////////////////////////////

  /*
        * Print the combination if keypad letters based on given input combination
        * input :
          2 abc
          3 def
          4 ghi
          5 jkl
          6 mno
          7 pqrs
          8 tuv
          9 wxyz
         * output : 23 = ad, ae, af, bd, be, bf, cd, ce, cf
         * */
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc"); map.put(3, "def");map.put(4, "ghi");
        map.put(5, "jkl");map.put(6, "mno");map.put(7, "pqrs");
        map.put(8, "tuv");map.put(9, "wxyz");

        String input = "23";

        List<String> collect4 = Arrays.stream(input.split(""))
                .map(m -> map.get(Integer.parseInt(m)))
                .filter(Objects::nonNull)
                .map(m -> Arrays.asList(m.split("")))
                .reduce((r1, r2) ->
                        r1.stream().flatMap(f ->
                                r2.stream().map(f1 -> f + f1))
                                .collect(Collectors.toList()))
                .orElse(Collections.emptyList());

//        System.out.println(collect4);
/// ///////////////////////////////////////////////////////////////////////////////////

        /*find average of even numbers from a given array*/
        Integer i[]={1,2,3,4,5,6,7,8};

        double asDouble = Arrays.stream(i).mapToInt(m -> m).filter(f -> f % 2 == 0).average().getAsDouble();
        //OR
        double asDouble1 = Arrays.stream(i).mapToInt(m -> m).filter(f -> f % 2 == 0).summaryStatistics().getAverage();
//        System.out.println(asDouble);
////////////////////////////////////////////////////////////////////////////////////////

        /*Print char and its count in such a way order from a given array*/
        String str ="aabbbcccc";

        //out put : a2b3c4

        String stringWithCount = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .map(m -> m.getKey() + m.getValue())
                .collect(Collectors.joining());
//        System.out.println(stringWithCount);
///////////////////////////////////////////////////////////////////////////////////////////

        /* Find the 5th highest grade of a student
         */

        Student collect6 = Student.getStudentList().stream()
                .sorted(Comparator.comparingDouble(Student::getGrade).reversed())
                .skip(4).findFirst().get();
//        System.out.println(collect6);
///////////////////////////////////////////////////////////////////////////////////////////

        /*
         * Filter words from string into diff categories
         * output : [rmesh] [jina7, LMn355, fgas4] [134] [%^$^, &&%]
         * */
        String words = "rmesh jina7 LMn355 %^$^ 134 fgas4 &&%";

        List<String> wordsList = Arrays.asList(words.split(" "));

        List<String> alphabets = wordsList.stream().filter(word -> word.matches("[a-zA-Z]+")).collect(Collectors.toList());
        List<String> alphaNumeric = wordsList.stream().filter(word -> word.matches("[a-zA-Z0-9]+") && !word.matches("[0-9]+") && !word.matches("[a-zA-Z]+")).collect(Collectors.toList());
        List<String> numeric = wordsList.stream().filter(word -> word.matches("[0-9]+")).collect(Collectors.toList());
        List<String> specialChars = wordsList.stream().filter(word -> !word.matches("[a-zA-Z0-9]+")).collect(Collectors.toList());

//        System.out.println(alphabets+" "+alphaNumeric+" "+numeric+" "+specialChars);
////////////////////////////////////////////////////////////////////////////////////////////

        /*
        * Input : 1w,2w,3w,4c,5c
        * OutPut : {c=[4c, 5c], w=[1w, 2w, 3w]}
        * */

        List<String> stringList = Arrays.asList("1w", "2w", "3w", "4c", "5c");
        Map<String, List<String>> stringListMap = stringList.stream().collect(Collectors.groupingBy(s10 -> s10.endsWith("w") ? "w" : "c"));
//        System.out.println(stringListMap);
/////////////////////////////////////////////////////////////////////////////////////////////

        /*Print the common elements from given two arrays*/

        int[] arr1 = {2,3,4,5,6,1};
        int[] arr2 = {2,3,8,9};

        List<Integer> collect7 = Arrays.stream(arr1).filter(e1 -> Arrays.stream(arr2).anyMatch(e2 -> e2 == e1)).boxed().collect(Collectors.toList());
//        System.out.println(collect7);
/////////////////////////////////////////////////////////////////////////////////////////////

        /*Reverse the elements in array in place*/

        int[] arr3 = {1,2,3,4,5};

        IntStream.rangeClosed(0, arr3.length/2).forEach(value -> {

            int temp = arr3[value];
            arr3[value] = arr3[arr3.length - 1 - value];
            arr3[arr3.length - 1 - value] = temp;

        });
//        System.out.println(Arrays.toString(arr3));
//////////////////////////////////////////////////////////////////////////////////////////////

        /*Concatenate two arrays in java8 using streams*/

        int[] arr5 = {1,2,3,4};
        int[] arr6 = {5,6,7,8};

        //below is for more than two arrays
        int[] array1 = Arrays.asList(arr5, arr6).stream().flatMapToInt(Arrays::stream).toArray();

        //OR

        int[] array3 = Stream.of(arr5, arr6).flatMapToInt(Arrays::stream).toArray();

        // OR

        //this one only for two arrays
        int[] array2 = IntStream.concat(IntStream.of(arr5), IntStream.of(arr6)).toArray();

        String[] strArray1 = {"samba", "shivudu"};
        String[] strArray2 = {"ambati"};

        //below is for more than two arrays
        String[] array4 = Arrays.asList(strArray1, strArray2).stream().flatMap(Arrays::stream).toArray(String[]::new);

        //OR

        String[] array5 = Stream.of(strArray1, strArray2).flatMap(Arrays::stream).toArray(String[]::new);

        //OR

        //this one only for two arrays
        String[] array6 = Stream.concat(Stream.of(strArray1), Stream.of(strArray2)).toArray(String[]::new);


//        System.out.println(Arrays.toString(array6));

    }

}
