package Seminar3;

public class Main {
    public static void main(String[] args) {

        // LinList list = new LinList();
        // list.addFirst(1);
        // list.addLast(2);
        // list.addFirst(3);
        // // list.removeLast();
        // // list.removeFirst();
        // // list.removeLast();
        // // list.removeFirst();
        // list.reverse();
        // list.print();

        Lin2List list = new Lin2List();
        list.addFirst(1);
        list.addLast(2);
        list.addFirst(3);
        list.addLast(4);
        list.reverse();
        list.print();
        System.out.println();
        list.bubbleSort();
        list.print();
        
    }
}
