package bitman;

public class Magicnum {
    public static void main(String[] args) {
        int base=5;
        int n=10;
        int answer = 0;
        while(n>0){
            int last = n&1;
            answer+= last*base;
            base=base*5;
            n=n>>1;
        }
        System.out.println(answer);
    }
}
                                                                                            