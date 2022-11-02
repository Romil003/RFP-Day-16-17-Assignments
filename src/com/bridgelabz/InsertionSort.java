package com.bridgelabz;

import java.util.Arrays;

public class InsertionSort {

    void insertionSort(String[] array) {
        int size = array.length;

        for (int step = 1; step < size; step++) {
            String key = array[step];
            int j = step - 1;

            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                --j;
            }


            array[j + 1] = key;
        }
    }

    public static void main(String args[]) {
        String[] data = { "Prathamesh" ,"Vaibhav", "Sarvesh", "Romil" };
        System.out.println(data[0].compareTo(data[1]));
        System.out.println();
        System.out.println("Before sorting : ");
        System.out.println(Arrays.toString(data));
        InsertionSort is = new InsertionSort();
        is.insertionSort(data);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}

