package Recursion;

public class LinearSearch {
    public static void main(String[] args) {
        System.out.println(ls(new int[]{1,2,3,4,5,6},6,0));
    }
    static boolean ls(int[] arr, int target,int i) {
        if(i<arr.length) {
            if (arr[i] == target) return true;
            return ls(arr, target, i + 1);
        }
        return false;
    }
}
