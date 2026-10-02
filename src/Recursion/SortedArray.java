package Recursion;

public class SortedArray {
    public static void main(String[] args) {
        System.out.println(sorted(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
    static boolean sorted(int[] arr) {
        if (arr.length <= 1) return true;
        return helper(arr, 0);
    }
    static boolean helper(int[] arr,int l) {
        if (l == arr.length-1) return true;
        return arr[l]<arr[l+1] && helper(arr,l+1);
    }
}
