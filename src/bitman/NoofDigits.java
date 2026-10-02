package bitman;

public class NoofDigits {
    static void main(String[] args) {
        int base=2;
        int n=10;
        int ans= (int)(Math.log(n) / Math.log(base) + 1);
        System.out.println(ans);
    }
}
