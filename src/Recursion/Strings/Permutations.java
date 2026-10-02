package Recursion.Strings;

import java.util.ArrayList;

public class Permutations {
   static void pm1(String res,String inp){
       if(inp.isEmpty())
       {
           System.out.println(res);
           return;
       }
       char ch = inp.charAt(0);
       for(int i=0;i<=res.length();i++){
           String s=res.substring(0,i);
           String f=res.substring(i,res.length());
           pm1(s+ch+f,inp.substring(1));
       }
   }
    static ArrayList pm2(String res, String inp){
        if(inp.isEmpty())
        {
            ArrayList<String> l = new ArrayList<>();
            l.add(res);
            return l;
        }
        char ch = inp.charAt(0);
        ArrayList list = new ArrayList();
        for(int i=0;i<=res.length();i++){
            String s=res.substring(0,i);
            String f=res.substring(i,res.length());
            list.addAll(pm2(s+ch+f,inp.substring(1)));
        }
        return list;
    }
    static int Nopm(String res,String inp){
        if(inp.isEmpty())
        {
            return 1;
        }
        int count =0;
        char ch = inp.charAt(0);
        for(int i=0;i<=res.length();i++){
            String s=res.substring(0,i);
            String f=res.substring(i,res.length());
            count+=Nopm(s+ch+f,inp.substring(1));
        }
        return count;
    }
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        String inp="abcd";
        System.out.println(pm2("",inp));
        System.out.println("Number of permutations="+Nopm("",inp));
    }
}
