package Recursion.Strings;

import java.util.ArrayList;
import java.util.List;

public class ItrSubset {
    static List<List<Integer>> subsets(int[] arr) {
        ArrayList<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int nums:arr){
            int n=outer.size();
            for(int i=0;i<n;i++){
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(nums);
                outer.add(inner);
            }
        }
        return outer;
    }
    static List<List<Integer>> subsetsdupe(int[] arr) {
        ArrayList<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start=0,end=0;
        for(int i=0;i<arr.length;i++){
            if(i>0&&arr[i]==arr[i-1]) start=end+1;
            end=outer.size()-1;
            int n=outer.size();
            for(int j=start;j<n;j++){
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }
        return outer;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        System.out.println(subsetsdupe(arr));
    }
}
