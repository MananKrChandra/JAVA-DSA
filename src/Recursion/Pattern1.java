package Recursion;

import java.util.Arrays;

public class Pattern1 {
    static void inv(int r,int c){
        if(r==0) return;
        if(c<r) {
            System.out.print("*");
            inv(r,c+1);
        }
        else{
            System.out.println("");
            inv(r-1,0);
        }
    }
    static void bubble(int[] arr, int r, int c) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            if (arr[c] > arr[c+1]) {
                int temp = arr[c];
                arr[c] = arr[c+1];
                arr[c+1] = temp;
            }
            bubble(arr, r, c+1);
        } else {
            bubble(arr, r-1, 0);
        }
    }
    static void selection (int[] arr, int r, int c) {
        if (r == 0) return;
        if  (c < r) {}
    }
    public static void main(String[] args) {
        inv(5,0);
        int[] arr=new int[]{4,3,2,1};
        bubble(arr,3,0);
        System.out.println(Arrays.toString(arr));
    }
}
