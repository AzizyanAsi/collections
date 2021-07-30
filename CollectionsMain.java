package Collections;

import java.util.Iterator;

public class CollectionsMain {
    public static void main(String[] args) {

        MyArrayList numeric = new MyArrayList(50);

        numeric.add("b");
        numeric.add("G");
        numeric.add("d");
        numeric.add("a");
        numeric.add("e");
        numeric.add("vvvvvvvv");
        numeric.add("c");
        numeric.remove("aaaaa");
        numeric.remove("x");
        Iterator iterat = numeric.iterator();
        while (iterat.hasNext()){
            System.out.println(iterat.next());
        }


        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList();
        mySinglyLinkedList.add(5);
        mySinglyLinkedList.add(8);
        mySinglyLinkedList.add(9);
        mySinglyLinkedList.add(15);
        mySinglyLinkedList.printList();
        Iterator iterator = mySinglyLinkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }
}
