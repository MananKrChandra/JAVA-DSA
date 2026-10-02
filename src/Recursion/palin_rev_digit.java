package Recursion;

public class palin_rev_digit {

    public static void main(String[] args) {
        System.out.println(rev(4545));
    }

    static int rev(int n) {
        return help(n, 0);
    }

    static int help(int n, int rev) {
        if (n == 0) return rev;
        return help(n / 10, rev * 10 + n % 10);
    }
}