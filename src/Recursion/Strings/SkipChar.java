package Recursion.Strings;

public class SkipChar {
    static StringBuilder sb=new StringBuilder();
    static void skip(String str, char ch, StringBuilder sb) {
        if (str.length() == 0) {
            return;
        }

        if (str.charAt(0) != ch) {
            sb.append(str.charAt(0));
        }

        skip(str.substring(1), ch, sb); // substring returns empty string when we pass the last index in the function i.e "",length==0;
    }
    static String skip2(String str, char ch) {
        if (str.length() == 0) {
            return "";
        }

        if (str.charAt(0) != ch) {
            return str.charAt(0) + skip2(str.substring(1), ch);
        }
        else  return skip2(str.substring(1), ch);
    }
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        //skip("aueuiwcb", 'u',sb);
        System.out.println(skip2("aueuiwcb", 'u'));
    }
}
