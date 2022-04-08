package com.main;

public class BinarySearch {
    public static void main(String[] args) {
        int[] dataBinary = {4, 7, 10, 8, 9, 30, 33, 100};
        int keyBinary = 33;

        System.out.println("--- Binary Search ---");
        int locationBinary = binarySearch(dataBinary, keyBinary);
        if (locationBinary == -1) {
            System.out.printf("%d was not found%n%n", keyBinary);
        } else {
            System.out.printf("%d was found in position %d%n%n",
                    keyBinary, locationBinary);
        }
    }

    private static String remainingElementsBinary(int[] data, int low, int high) {
        StringBuilder temporary = new StringBuilder();

        for (int i = low; i <= high; i++) {
            temporary.append(data[i]).append(" ");
        }

        return String.format("[ %s]%n", temporary);
    }

    public static int binarySearch(int[] data, int key) {
        int low = 0;
        int high = data.length - 1;
        int middle = (low + high + 1) / 2;
        int location = -1;

        do {
            System.out.print(remainingElementsBinary(data, low, high));

            System.out.println("low in index " + low);
            System.out.println("middle in index " + middle);

            if (key == data[middle]) {
                location = middle;
            }

            else if (key < data[middle]) {
                high = middle - 1;
            }

            else {
                low = middle + 1;
            }

            middle = (low + high + 1) / 2;
        } while ((low <= high) && (location == -1));

        return location;
    }
}
