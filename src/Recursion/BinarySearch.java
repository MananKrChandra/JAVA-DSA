package Recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int target =5;
        System.out.println(Bsearch(arr, 0, arr.length-1,target));
    }
    static int Bsearch(int[] arr, int left, int right, int target){
        if(left > right) return -1;

        int mid = (left + right) / 2;

        if (arr[mid] == target) return mid;
        if (target > arr[mid]) return Bsearch(arr, mid + 1, right, target);
        else return Bsearch(arr, left, mid - 1, target);
    }
}