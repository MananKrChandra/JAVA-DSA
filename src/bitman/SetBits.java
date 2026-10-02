package bitman;

public class SetBits {
    public static void main(String[] args) {
        int n=7,count=0;
        while(n>0){
            int l=n&-n;
            n=n-l;
            count++;
        }
        System.out.println(count);
    }
}
