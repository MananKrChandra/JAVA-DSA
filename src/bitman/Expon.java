package bitman;

public class Expon {
     public static void main() {
         long a=3,b=6;
         long ans = 1;
         while (b > 0) {
            if ((b & 1) == 1) {
                ans *= a;
            }
            a *= a;
            b >>= 1;
        }
         System.out.println(ans);
    }
}
