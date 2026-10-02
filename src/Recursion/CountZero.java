package Recursion;

public class CountZero {
    public static void main(String[] args) {
        int n = 1020;
        System.out.println(cz(n));
    }

    static int cz(int x) {
        return helper(x, 0);
    }

    static int helper(int x, int c) {
        if (x == 0) {
            return c;
        }

        if (x % 10 == 0) {
            c++;
        }

        return helper(x / 10, c);
    }
}