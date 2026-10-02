package Linkl;

public class Main {
    public static void main(String[] args) {
        LL ll = new LL();
        ll.insertfirst(6);
        ll.insertfirst(3);
        ll.insertfirst(5);
        ll.insertfirst(7);
        ll.insertlast(8);
//        ll.removelast();
        ll.remove(3);
        ll.display();
    }

}
