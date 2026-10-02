package Recursion.Strings;

import java.util.ArrayList;
import java.util.List;

public class Dice {
    static void dice(String p, int target) {
        if (target==0) {
            System.out.println(p);
            return;
        }
        for(int i=1;i<=6&&i<=target;i++){
            dice(p+i,target-i);
        }
    }
    static List<String> dice2(String p, int target) {
        if (target==0) {
            List<String> l= new ArrayList<>(); 
            l.add(p);
            return l;
        }
        List<String> list= new ArrayList<>();
        for(int i=1;i<=6&&i<=target;i++){
            list.addAll(dice2(p+i,target-i));
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(dice2("",5));
    }
}
