package com.core.java.programs.practice;

import com.core.java.programs.model.CreditCard;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CoreJavaPrograms {
    public CoreJavaPrograms() {
    }

    public static void main(String[] args) {

        List<CreditCard> creditCardList = CreditCard.getCreditCard();



//        convertStringArrayToCharacterArray();
////////////////////////////////////////////////////////////////////

//        rotateArrayWithTimeComplexity();
////////////////////////////////////////////////////////////////////

//        rotateArrayUsingJava8();
/////////////////////////////////////////////////////////////////
//        rotateArrays();
        //////////////////////////////////////////////////////////

//        sortArrayOfIntegers();
//////////////////////////////////////////////////////////

//        sortingListOfString();
//////////////////////////////////////////////////////////

//        armStrongNumber();
//////////////////////////////////////////////////////////

//        palindromeNumber();
//////////////////////////////////////////////////////////

//        feboNocciSeries();
//////////////////////////////////////////////////////////

//        maxAndSecondLargestMaxInArray();
//////////////////////////////////////////////////////////

//        minAndSecondLargestMinInArray();
//////////////////////////////////////////////////////////

//        primeNumbers();
//////////////////////////////////////////////////////////

//        removeDuplicatesFromList();
//////////////////////////////////////////////////////////

//        removeDuplicateIntFromListAndFindMax();
//////////////////////////////////////////////////////////

//        incrementSequenceId();
//////////////////////////////////////////////////////////
//        System.out.println(returnMidOfLinkedList());
//////////////////////////////////////////////////////////

//        System.out.println(dateUtils());
//////////////////////////////////////////////////////////

//        System.out.println(linearSearch());
//        System.out.println(binarySearch());
///////////////////////////////////////////////////////////

//        System.out.println(findMedianInMergedArray());
///////////////////////////////////////////////////////////

//        addTwoNumbersUptoTarget();
///////////////////////////////////////////////////////////

//        java8ConceptsPro();
///////////////////////////////////////////////////////////

//        returnMajorityOfElementExistInArray();
////////////////////////////////////////////////////////////

//        medianOfTwoSortedArrays();
////////////////////////////////////////////////////////////

//        System.out.println(lengthOfLongestSubstring());
////////////////////////////////////////////////////////////

//        countFrequencyOfElementsInString();
    }

    // Rotate right by k positions using reverse method
    private static void rotateArrayWithTimeComplexity() {
        int[] arr = {1,2,3,4,5,6};
        int rotate = 2;
        int n = arr.length;
        rotate = rotate % n; // Handle cases where rotate > n
        reverse(arr, 0, n - 1);      // Reverse the whole array
        reverse(arr, 0, rotate - 1);      // Reverse first rotate elements
        reverse(arr, rotate, n - 1);//     Reverse remaining elements

        System.out.println(Arrays.toString(arr));
    }
    // Helper function to reverse array from index 'start' to 'end'
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    private static void rotateArrayUsingJava8() {
        //Using streams
        int[] arr = {1,2,3,4,5,6};
        int rotate = 2;

        List<Integer> collect = IntStream.range(0, arr.length)
                .mapToObj(m -> arr[(m - rotate + arr.length) % arr.length]) // Circular shift
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void convertStringArrayToCharacterArray() {
        List<String> list = Arrays.asList("good", "morning");

        char[] charArray = list.stream().collect(Collectors.joining()).toCharArray();

        System.out.println(Arrays.toString(charArray));
    }


    private static void rotateArrays() {
        /*Without following time complexity*/
        int[] arr = {1,2,3,4,5,6};
        int rotateNum = 2;
        int length = arr.length;
        int rotateSize = length-rotateNum;
        int[] newArr = new int[length];

        String temp = "";
        for (int i = rotateSize; i < length; i++){
            temp = temp+arr[i];
        }

        int count = rotateNum;
        for (int j = 0; j < rotateSize; j++){
            newArr[count]=arr[j];
            count++;
        }
        count = 0;
        for (String s : temp.split("")){
            newArr[count]=Integer.parseInt(s);
            count++;
        }

        System.out.println(Arrays.toString(newArr));

    }

    private static boolean checkIsAlphaNumeric(String creditCardNumber) {
        return !creditCardNumber.chars().allMatch(Character::isDigit);
    }

    private static void sortArrayOfIntegers() {
        int[] arr = {4,2,6,3,8,10};

        for (int i = 0; i < arr.length; i++){
            for (int j = i+1; j < arr.length; j++){
                if (arr[i] > arr[j]){
                    int integer = arr[i];
                    arr[i] = arr[j];
                    arr[j] = integer;
                }
            }
        }
        for (int i : arr){
        System.out.print(i+",");
        }
    }

    private static void sortingListOfString() {
        List<String> stringList = Arrays.asList("samba", "shivudu", "ambati");

        for (int i =0; i < stringList.size(); i++){
            for (int j = i +1; j < stringList.size(); j++){
                if (stringList.get(i).compareTo(stringList.get(j)) > 0){
                    String temp = stringList.get(i);
                    stringList.set(i,stringList.get(j));
                    stringList.set(j,temp);
                }
            }
        }
        System.out.println(stringList);
    }

    private static void armStrongNumber() {
        int number = 153;
        int rem = 0;
        int sum = 0;
        int temp = number;

        while (number > 0){
            rem = number%10;
           number = number/10;
           sum = sum+rem*rem*rem;
        }

        if (temp == sum){
            System.out.println("ArmStrongNumber");
        }else {
      System.out.println("Not a ArmStrongNumber");
                }
    }

    private static void palindromeNumber() {
        int number = 122;
        int rem = 0;
        int sum = 0;
        int temp = number;

        while (number > 0){
            rem = number%10;
            number = number/10;
            sum = sum*10+rem;
        }
        if (temp == sum){
            System.out.println("Palindrome number");
        }else {
            System.out.println("Not a Palindrome number");
        }
    }

    private static void feboNocciSeries() {
        /*print 10 febonocciseries numbers*/

        int n1 = 0,n2 = 1, n3 = 0;

        System.out.print(n1+",");
        System.out.print(n2+",");

        for (int i = 2; i < 10; i++){
          n3 = n1 + n2;
      System.out.print(n3+",");
          n1 = n2;
          n2 = n3;
        }
    }

    private static void maxAndSecondLargestMaxInArray() {
        int[] arr = {5,3,8,9,20,10};
        int max = arr[0];
        int secondLargestMax = arr[0];

        for (int i = 0;  i < arr.length; i++){
            if (arr[i] > max){
                secondLargestMax = max;
                max = arr[i];
            }
            else if(secondLargestMax < arr[i]){
                secondLargestMax = arr[i];
            }
        }
        System.out.println("Max : "+max+" SecondLargestMax : "+secondLargestMax);
    }

    private static void minAndSecondLargestMinInArray() {
        int[] arr = {5,3,8,9,10};
        int min = arr[0];
        int secondLargestMin = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < min){
                secondLargestMin = min;
                min = arr[i];
            }
            else if(secondLargestMin > arr[i]){
                secondLargestMin = arr[i];
            }
        }
    System.out.println("Min : "+min+" SecondLargestMin : "+secondLargestMin);
    }

    private static void primeNumbers() {
        for (int i = 1; i < 50; i++){
            int count = 0;
            for (int j = 1; j <=i; j++){
                if (i%j == 0){
                    count++;
                }
            }
            if (count == 2){
                System.out.print(i+",");
            }
        }
    }

    private static void returnMajorityOfElementExistInArray() {
        //The majority of the element is appears more than ⌊n / 2⌋ times. You may assume that the majority of the element always exists in the array.
        Map<Integer, Integer> map = new HashMap<>();
        int[] nums = {2,2,1,1,1,2,2};
        int l = nums.length;

        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                Integer c = map.get(nums[i]);
                map.put(nums[i], ++c);
            }else {
                map.put(nums[i], 1);
            }
        }
        System.out.println(map);
        map.forEach((k, v) -> {
         if (v > l/2){
             System.out.println(k);
         }
        });
    }

    private static void java8ConceptsPro() {
        /*get the CreditCard data by sorting based on Name and id range should be >1 and <5 */
        List<CreditCard> collect = CreditCard.getCreditCard().stream().sorted((o1,o2) -> o2.getId() - o1.getId()).filter(creditCard -> creditCard.getId() >1 && creditCard.getId() < 3).collect(Collectors.toList());

        /*group by creditCardNumber*/
//        Map<String, List<CreditCard>> collect1 = CreditCard.getCreditCard().stream().collect(Collectors.groupingBy(CreditCard::getCreditCardNumber));

        /*special feature called summary statistics will provide avg, min, max, count*/
//        IntSummaryStatistics intSummaryStatistics = CreditCard.getCreditCard().stream().mapToInt(creditCard -> Integer.parseInt(creditCard.getCreditCardNumber())).summaryStatistics();

        List<CreditCard> collect2 = CreditCard.getCreditCard().stream().sorted((c1,c2) -> c2.getId()-c1.getId()).collect(Collectors.toList());

        /*partitioning creditCard by id ex : id < 3 then
        if matched within the range then key should true and value should that current Obj */
        Map<Boolean, List<CreditCard>> collect3 = CreditCard.getCreditCard().stream().collect(Collectors.partitioningBy(creditCard -> creditCard.getId() < 3));

        System.out.print(collect);
    }

    private static void medianOfTwoSortedArrays() {
        int[] n1 = {1,2,3};
        int[] n2 = {4,5,6,7};

        int size = n1.length+n2.length;
        int[] mergedArray = new int[size];

        int count = 0;
        for (int i : n1){
            mergedArray[count] = i;
            count++;
        }

        for (int j : n2){
            mergedArray[count] = j;
            count++;
        }

        int mid = size/2;
        if (size%2 !=0){
            //oddMid
            System.out.println(mergedArray[mid]);
        }else {
            int mid1 = mergedArray[mid-1];
            int mid2 = mergedArray[mid];
            int oddMid = mid1+mid2;
            double evenMid = (double) oddMid/2;
            System.out.println(evenMid);
        }
    }

    private static void removeDuplicateIntFromListAndFindMax() {
        List<Integer> list = Arrays.asList(20, 30, 40, 20, 60, 70, 80, 40);
        List<Integer> collect = list.stream().distinct().collect(Collectors.toList());
        Optional<Integer> max = collect.stream().filter(integer -> integer > 0).max((o1,o2) -> o1-o2);
    System.out.println(max.get());
        Optional<Integer> min = collect.stream().filter(integer -> integer > 0).min((o1, o2) -> o1 - o2);
      System.out.println(min.get());

        List<Integer> collect1 = list.stream().sorted((o1, o2) -> o2 - o1).collect(Collectors.toList());
    System.out.println(collect1);
    }

    private static void removeDuplicatesFromList() {
        String s0 = "sambashivuduambati";
        /*remove duplicates from a string*/
        char[] cha = s0.toCharArray();
        List<Character> lists = new ArrayList<>();
        for (int i = 0; i < cha.length; i++){
            if (lists.contains(cha[i])){
                continue;
            }else {
                lists.add(cha[i]);
            }
        }
        System.out.println(lists);

        //OR

        List<Character> collect = s0.chars().boxed().map(integer -> (char) (int) integer).distinct().collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void addTwoNumbersUptoTarget() {

        int[] arr = {2,7,11,6};

        int t= 9;
        Map<Integer, Integer> map = new HashMap<>();

        int[] twoSum = null;
        for (int i =0; i < arr.length; i++){
           int c = t-arr[i];

           if (map.containsKey(c)) {
               twoSum =  new int[] {map.get(c), i};
           }else {
               map.put(arr[i], i);
           }
        }

        for (int i : twoSum){
            System.out.print(i);
        }
    }

    private static void incrementSequenceId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter CRM_ID : ");
        String cRMId = scanner.nextLine();

        List<String> dbList = new LinkedList<>();
        dbList.add("6557-88-0004");
        dbList.add("6557-88-0004-1");
        dbList.add("6557-88-0004-2");
        dbList.add("6557-88-0004-3");

//        dbList = dbList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        String max = Collections.max(dbList);
        System.out.println(dbList);

        if (dbList.contains(cRMId)){
            System.out.println("CRM_ID found");
            String newCRmId = cRMId+"-"+ "1";
            if (dbList.size() == 1){
                dbList.add(newCRmId);
            }else {
                String dbCRMId = max;
                String[] split = dbCRMId.split("-");
//                String count = split[split.length - 1];
                int intCount = Integer.parseInt(split[split.length - 1]);
                int incrementedCount = ++intCount;
                cRMId = cRMId+"-"+incrementedCount;
                dbList.add(cRMId);
            }
        }else {
            dbList.add(cRMId);
            System.out.println("CRM_ID not found and save new record");
        }
        dbList = dbList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        System.out.println(dbList);
    }

    private static List<Integer> returnMidOfLinkedList() {

         /*Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.*/
        List<Integer> oddList = new LinkedList<>();
        oddList.add(1);
        oddList.add(2);
        oddList.add(3);
        oddList.add(4);
        oddList.add(5);

        List<Integer> evenList = new LinkedList<>();
        evenList.add(1);
        evenList.add(2);
        evenList.add(3);
        evenList.add(4);
        evenList.add(5);
        evenList.add(6);

        List<Integer> newList = new LinkedList<>();
        int lengthOfList = evenList.size();
        int mid = lengthOfList / 2;
        if (lengthOfList%2 != 0) {
        for (int i = mid; i < lengthOfList; i++){
            newList.add(evenList.get(i));
        }
        }else {
            for (int i = mid; i < lengthOfList; i++){
                newList.add(evenList.get(i));
            }
        }
        return newList;
    }

    private static Timestamp dateUtils() {

        String eventTime = "2023-05-19T16:31:56.436Z";

        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        try {
            Date parse = simpleDateFormat.parse(eventTime);
            return new Timestamp(parse.getTime());
        } catch (ParseException e) {

        }

        return null;
    }

    private static int binarySearch() {

        int[] intArray = {2,3,5,8,9};
        int searchNumber = 9;

        //lestIndex position
        int left = 0;
        //rightIndex position
        int right = intArray.length-1;

        while (left <= right){
            int mid = (left + right)/2;

            if (intArray[mid] == searchNumber){
                return mid;
            }
            else if (intArray[mid] < searchNumber){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }

        return -1;
    }

    private static int linearSearch() {
        int[] linearArray = {2,3,5,8,9};
        int searchNumber = 9;
        for (int i = 0; i < linearArray.length; i++){
            if (linearArray[i] == searchNumber){
                return i;
            }
        }

        return -1;
    }

    private static double findMedianInMergedArray() {

        int[] n1 = {2,1};
        int[] n2 = {3,4};

        int tL = n1.length + n2.length;
        int[] merged = new int[tL];
        int count = 0;
        for (int i : n1){
            merged[count] = i;
            count++;
        }
        for (int j : n2){
                merged[count] = j;
                count++;
        }
        System.out.println(Arrays.toString(merged));
        Arrays.sort(merged);

        System.out.println(Arrays.toString(merged));

        int mid = tL/2;
        if (tL%2 != 0){
            return merged[mid];
        }
       double d= (double)(merged[mid] + merged[mid-1])/2;
        return d;
    }

    private static void countFrequencyOfElementsInString() {
        //Java 8
        String s1 = "abcabcdef";
        Map<Character, Long> collect = s1.chars()
                .boxed()
                .map(e -> (char) (int) e)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
    }

    public static int lengthOfLongestSubstring() {
        String s = "abcabcbb";
        String s1 = "pwwkew";

        if (s == null || s.length() == 0)
            return 0;

        int maxLength = 0;
        int left = 0;
        int right = 0;

        Set<Character> charSet = new HashSet<>();
        while (right < s.length()) {
            char currentChar = s.charAt(right);
            if (!charSet.contains(currentChar)) {
                charSet.add(currentChar);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                charSet.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }
}
