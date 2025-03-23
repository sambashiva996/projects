package com.core.java.programs.comparator;

import java.util.Arrays;
import java.util.List;

public class ComparatorMain {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,1,6,3,4,8);

        ComparatorImpl comparator = new ComparatorImpl();

        bubbleSort(list, comparator);

        System.out.println(list);

    }
    // Bubble sort implementation
    public static void bubbleSort(List<Integer> list, ComparatorImpl comparator) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (comparator.compare(list.get(j), list.get(j + 1)) > 0) {
                    // Swap elements
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}
