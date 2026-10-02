package Recursion.Strings;

public class SkipString {
    static String skip(String str, String sk) {
        if (str.length() < sk.length()) {
            return str;
        }
        if (!str.substring(0,sk.length()).equals(sk)) {
            return str.charAt(0) + skip(str.substring(1),sk);
        }
        else  return skip(str.substring(sk.length()),sk);
    }
    public static void main(String[] args) {
        System.out.println(skip("abcdefg","bcd"));
    }
}
