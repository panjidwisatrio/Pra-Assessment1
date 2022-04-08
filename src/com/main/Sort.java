package com.main;

import java.util.Arrays;

public class Sort {

    static void bubbleSort(int[] data) {
        int size = data.length;

        // loop to access each array element
        for (int i = 0; i < size - 1; i++) {
            // loop to compare array elements
            for (int j = 0; j < size - i - 1; j++) {
                // compare two adjacent elements
                // change > to < to sort in descending order
                if (data[j] > data[j + 1]) {
                    // swapping occurs if elements
                    // are not in the intended order
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
//                    remainingElements(data);
                }
            }
        }
    }

    static void insertionSort(int[] data) {
        int size = data.length;

        for (int step = 1; step < size; step++) {
            int key = data[step];
            int j = step - 1;

            // Compare key with each element on the left of it until an element smaller than
            // it is found.
            // For descending order, change key<array[j] to key>array[j].
            while (j >= 0 && key < data[j]) {
                data[j + 1] = data[j];
                --j;
            }

            // Place key at after the element just smaller than it.
            data[j + 1] = key;
        }
    }

    static void merge(int[] data, int p, int q, int r) {
        // Create L ← A[p..q] and M ← A[q+1..r]
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] L = new int[n1];
        int[] M = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = data[p + i];
        }

        for (int j = 0; j < n2; j++) {
            M[j] = data[q + 1 + j];
        }

        // Maintain current index of sub-arrays and main array
        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        // Until we reach either end of either L or M, pick larger among
        // elements L and M and place them in the correct position at A[p..r]
        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                data[k] = L[i];
                i++;
            } else {
                data[k] = M[j];
                j++;
            }
            k++;
        }

        // When we run out of elements in either L or M,
        // pick up the remaining elements and put in A[p..r]
        while (i < n1) {
            data[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            data[k] = M[j];
            j++;
            k++;
        }
    }

    static void mergeSort(int[] data, int l, int r) {
        if (l < r) {

            // m is the point where the array is divided into two subarrays
            int m = (l + r) / 2;

            mergeSort(data, l, m);
            mergeSort(data, m + 1, r);

            // Merge the sorted subarrays
            merge(data, l, m, r);
        }
    }

    public static void main(String[] args) {
        int[] data = {6, 22, 2, 10, 8, 7, 100, 1, 3, 5};

        Sort.bubbleSort(data);
        System.out.println("Sorted Array by bubble sort:");
        System.out.println(Arrays.toString(data));

        Sort.insertionSort(data);
        System.out.println("\nSorted Array by insertion sort:");
        System.out.println(Arrays.toString(data));

        Sort.mergeSort(data, 0, data.length -1);
        System.out.println("\nSorted Array by merge sort:");
        System.out.println(Arrays.toString(data));
    }
}
