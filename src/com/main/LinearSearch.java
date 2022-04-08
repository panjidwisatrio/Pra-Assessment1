package com.main;

public class LinearSearch {
    public static void main(String[] args) {
        int[] dataLinear = {30, 4, 7, 10, 8, 100, 33};
        int keyLinear = 10;

        System.out.println("--- Linear Search ---");
        int locationLinear = linearSearch(dataLinear, keyLinear);
        if (locationLinear == -1) {
            System.out.print("Element not found");
        } else {
            System.out.printf("Element %s found at index: %s",
                    keyLinear, locationLinear);
        }
    }

    public static int linearSearch(int[] data, int key) {
        int size = data.length;

        for (int i = 0; i < size; i++) {
            System.out.println(remainingElementsLinear(data, i));
            if (data[i] == key) {
                return i;
            }
        }
        return -1;
    }

    private static String remainingElementsLinear(int[] data, int index) {
        StringBuilder temporary = new StringBuilder();

        for (int i = index; i < data.length; i++) {
            temporary.append(data[i]).append(" ");
        }

        return String.format("[ %s]%n", temporary);
    }
}
