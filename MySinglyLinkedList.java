package Collections;

import java.util.Iterator;
public class MySinglyLinkedList<T> implements Iterable<T> {

    Node head;
    int size = 0;

    @Override
    public Iterator<T> iterator() {
        return new Iterator() {
            Node last = head;
            @Override
            public boolean hasNext() {
                return last != null;
            }

            @Override
            public T next() {
                T data = null;
                if (hasNext()){
                    data = (T) last.data;
                    last = last.next;
                    return data;
                }
                return null;
            }
        };
    }

    static class Node<T> {

        T data;
        Node next;

        // Constructor
        Node(T d)
        {
            data = d;
            next = null;
        }
    }

    public void add(int data)
    {
        Node newNode = new Node(data);
        newNode.next = null;
        size++;
        if (head == null) {
            head = newNode;
        }
        else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = newNode;
        }

    }

    public Node  get(int i) {

        Node last = head;
        int x = 0;
        while (last.next != null) {
            i++;
            if (x==i)
                return last;
            last = last.next;

        }
        return null;
    }

    public boolean  contains(Node node) {
        if (node == null)
            return false;
        Node last = head;
        while (last.next != null) {
            if (last.data == node.data)
                return true;
            last = last.next;

        }
        return false;
    }

    public void printList()
    {
        Node currNode = head;

        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println("\n");
    }

    public void remove(T key)
    {
        Node currNode = head, prev = null;

        if (currNode != null && currNode.data == key) {
            head = currNode.next;
            size--;
            return;
        }
        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
        }
        if (currNode != null) {
            prev.next = currNode.next;
            size--;
        }
    }

    public void removeAtPosition(int index)
    {
        Node currNode = head, prev = null;
        if (index == 0 && currNode != null) {
            head = currNode.next;
            size--;
            return;
        }
        int counter = 0;
        while (currNode != null) {

            if (counter == index) {
                prev.next = currNode.next;
                size--;
                break;
            }
            else {
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }
    }

    public int size(){
        return size;
    }
}
