package Recursion.Strings;

import java.util.ArrayList;
import java.util.List;

public class PhonePad {
    public static void main(String[] args) {
        System.out.println(helper("12",""));
    }
    static List<String> helper(String s,String ans){
        if(s.isEmpty()){
            List<String> l=new ArrayList<>();
            l.add(ans);
            return l;
        }
        List<String> list=new ArrayList<>();
        int digit=s.charAt(0)-'0';
        for(int i=(digit-1)*3;i<digit*3;i++){
            char ch=(char)('a'+i);
            list.addAll(helper(s.substring(1),ans+ch));
        }
        return list;
    }
}
