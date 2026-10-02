package Recursion;

import java.util.Arrays;

public class MergeSort {
//        static int[] mergesort(int[] arr){
//            if(arr.length == 1) return arr;
//            int mid=arr.length/2;
//            int[] left=mergesort(Arrays.copyOfRange(arr,0,mid));
//            int[] right=mergesort(Arrays.copyOfRange(arr,mid,arr.length));
//            return merge(left,right);
//        }
//        static int[] merge(int[] left,int[] right) {
//            int[] result = new int[left.length + right.length];
//            int i = 0, j = 0, k = 0;
//            while (i < left.length && j < right.length) {
//                if (left[i] < right[j]) {
//                    result[k++] = left[i++];
//                } else {
//                    result[k++] = right[j++];
//                }
//            }
//            while (i < left.length) {
//                result[k++] = left[i++];
//            }
//            while (j < right.length) {
//                result[k++] = right[j++];
//            }
//            return result;
//        }
        static void mergesortIP(int[] arr, int start, int end) {
            if(end-start == 1) return;
            int mid=(start+end)/2;
            mergesortIP(arr,start,mid);
            mergesortIP(arr,mid,end);
            mergeIP(arr,start,mid,end);
        }
        static void mergeIP(int[] arr, int start, int mid, int end) {
            int[] result = new int[end-start];
            int i = start, j = mid, k = 0;
            while (i < mid && j < end) {
                if (arr[i] < arr[j]) {
                    result[k++] = arr[i++];
                } else {
                    result[k++] = arr[j++];
                }
            }
            while (i <mid) {
                result[k++] = arr[i++];
            }
            while (j <end) {
                result[k++] = arr[j++];
            }
            for (int l = 0; l < result.length; l++) {
                arr[start + l] = result[l];
            }
        }
    public static void main(String[] args) {
            int[] arr = {1,4,3,6,2,7,8,5};
            mergesortIP(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
