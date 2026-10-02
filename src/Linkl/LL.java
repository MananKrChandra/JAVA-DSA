package Linkl;
public class LL {
    private Node head;
    private Node tail;
    private int size;
    public LL() {
        this.size = 0;
    }
    // Google, Microsoft, Facebook: https://leetcode.com/problems/reverse-linked-list-ii/
//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        if (left == right) {
//            return head;
//        }
//
//        // skip the first left-1 nodes
//        ListNode current = head;
//        ListNode prev = null;
//        for (int i = 0; current != null && i < left - 1; i++) {
//            prev = current;
//            current = current.next;
//        }
//
//        ListNode last = prev;
//        ListNode newEnd = current;
//
//        // reverse between left and right
//        ListNode next = current.next;
//        for (int i = 0; current != null && i < right - left + 1; i++) {
//            current.next = prev;
//            prev = current;
//            current = next;
//            if (next != null) {
//                next = next.next;
//            }
//        }
//
//        if (last != null) {
//            last.next = prev;
//        } else {
//            head = prev;
//        }
//
//        newEnd.next = current;
//        return head;
//    }
//    private void bubbleSort(int row, int col) {
//        if (row == 0) {
//            return;
//        }
//
//        if (col < row) {
//            Node first = get(col);
//            Node second = get(col + 1);
//
//            if (first.value > second.value) {
//                // swap
//                if (first == head) {
//                    head = second;
//                    first.next = second.next;
//                    second.next = first;
//                } else if (second == tail) {
//                    Node prev = get(col - 1);
//                    prev.next = second;
//                    tail = first;
//                    first.next = null;
//                    second.next = tail;
//                } else {
//                    Node prev = get(col - 1);
//                    prev.next = second;
//                    first.next = second.next;
//                    second.next = first;
//                }
//            }
//            bubbleSort(row, col + 1);
//        } else {
//            bubbleSort(row - 1, 0);
//        }
//    }

    // recursion reverse
    private void reverse(Node node) {
        if (node == tail) {
            head = tail;
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    // in place reversal of linked list
    // google, microsoft, apple, amazon: https://leetcode.com/problems/reverse-linked-list/
    public void insertfirst(int value) {
        Node node=new Node(value);
        node.next=head;
        head=node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }
    public void display() {
        if (head == null) {
            return;
        }
        Node temp=head;
        for(int i=1;i<=size;i++) {
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    public void insertlast(int value) {
        if(tail==null) {
            insertfirst(value);
            return;
        }
        Node node=new Node(value);
        tail.next=node;
        tail=node;
        size++;
    }
    public int removefirst(){
        if (head==null) {
            return -1;
        }
        int value=head.data;
        head=head.next;
        size--;
        if(head==null) {
            tail=null;
        }
        return value;
    }
    public int removelast(){
        if(head==null){
            return -1;
        }
        if(size==1){
            return removefirst();
        }
        Node secondLast=get(size-1);
        int value=tail.data;
        tail=secondLast;
        tail.next=null;
        size--;
        return value;
    }
    public void remove(int pos){
        Node temp=get(pos - 1);
        temp.next=temp.next.next;
        size--;
    }
    public Node get(int pos){
        Node temp=head;
        for(int i=1;i<pos;i++){
            temp=temp.next;
        }
        return temp;
    }

}
