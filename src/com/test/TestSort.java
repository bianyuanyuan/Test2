package com.test;
//quick sort

import java.util.*;

class GetKey {//received the index of the middle element

    public static int getKey(int values[], int low, int high) {
        if (values.length <= 0) {// Judge the arrays's length
            return 0;
        }
        int key = values[low];// the middle of the arrays
        while (low < high) {
            while (low < high && key <= values[high]) {
                high--;// move to the front of itself
            }
            values[low] = values[high];// fill the fist hole
            while (low < high && values[low] <= key) {
                low++;// move to the front of itself
            }
            values[high] = values[low];// fill the next hole
        }
        values[low] = key;// fill the middle hole
        /*
         * for(int i:values){//Test the process System.out.print(i+" "); }
         * System.out.println();
         */
        return low;
    }
}

class QuickSort {//recursion call the method

    public static void quickSort(int values[], int low, int high) {
        if (low < high) {
            int middle = GetKey.getKey(values, low, high);
            quickSort(values, low, middle - 1);//left of the array
            quickSort(values, middle + 1, high);//right of the array
        }
    }
}

class NoRecQuickSort {//no recursion,use stack

    public static void nonRecQuickSort(int values[]) {
        // stack
        int low = 0;//the left index
        int high = values.length - 1;//the right index
        Stack<Integer> stack = new Stack<Integer>();//save the index of the start and the end
        if (low < high) {
            stack.push(high);//push
            stack.push(low);
            while (!stack.isEmpty()) {
                int i = stack.pop();//pop
                int j = stack.pop();
                int index = GetKey.getKey(values, i, j);
                if (i < index - 1) {//left
                    stack.push(index - 1);//save the middle element of the array
                    stack.push(i);
                }
                if (j > index + 1) {//right
                    stack.push(j);
                    stack.push(index + 1);
                }
            }
        }
    }
}

public class TestSort {
    public static void main(String[] args) {
        Random rand = new Random(47);
        int arr[] = new int[100000];// rand.nextInt(10000)
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }
        System.out.println("Before the quinkSort:");
        System.out.println(Arrays.toString(arr));
        System.out.println();

        NoRecQuickSort.nonRecQuickSort(arr);//test the non recursion quick sort
        //QuickSort.quickSort(arr,0,arr.length-1);//test the  recursion quick sort

        System.out.println("After the quinkSort:");
        System.out.println(Arrays.toString(arr));
    }
}
