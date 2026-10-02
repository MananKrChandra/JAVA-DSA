package Recursion;

import java.util.Arrays;

public class QuickSort {
    static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int start = low,end=high;
        int mid=low+(high-low)/2;
        int pivot=arr[mid];
        while (start<=end) {
            while (pivot >arr[start]) {
                start++;
            }
            while (pivot < arr[end]) {
                end--;
            }
            if (start <= end) {
                int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
                end--;
            }
        }
        quickSort(arr,low,end);
        quickSort(arr,start,high);
    }
    public static void main(String[] args) {
        int[] arr={4,3,6,2,7,1,8};
        quickSort(arr, 0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
