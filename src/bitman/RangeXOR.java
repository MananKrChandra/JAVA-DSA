package bitman;

public class RangeXOR {
    public static void main(String[] args) {
        int a=3;
        int b=9;
        System.out.println(xor(b)^xor(a-1));
    }
    static int xor(int x){
        if(x%4==0){
            return x;
        }
        if(x%4==1){
            return 1;
        }
        if(x%4==2){
            return x+1;
        }
        if(x%4==3){
            return 0;
        }
        return -1;
    }
}
