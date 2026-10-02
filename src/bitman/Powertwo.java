package bitman;

public class Powertwo {
    static void main(String[] args) {
        int n = 10;
        if ((n & (n - 1)) == 0) {
            System.out.println(true);
        }
        else System.out.println(false);
    }
}
