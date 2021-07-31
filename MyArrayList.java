package Collections;

import java.util.Iterator;

public class MyArrayList<T extends Object> implements Iterable<T> {

    private T[] arrayList;
    private int elementsInArray;

    public MyArrayList() {
        this(10);
    }
    public MyArrayList(int n) {
        if (n <= 0) {
            System.out.println("The size must be greater than 0. Try again.");
            return;
        }

        this.arrayList = (T[]) new Object[n];
        this.elementsInArray = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int pointer = 0;
            @Override
            public boolean hasNext() {
                return pointer < elementsInArray;
            }

            @Override
            public T next() {
                if (hasNext()){
                    pointer++;
                    return get(pointer);
                }
                return null;
            }
        };
    }

    public void add(T x) {
        if (checkIfArrayFull()) {
            copyArray(0, "double");
        }

        this.arrayList[this.elementsInArray] = x;
        this.elementsInArray++;
    }

    public void add(int index, T x) {
        if (checkIfArrayFull()) {
            copyArray(0, "double");
        }

        if (index >= this.arrayList.length) {
            System.out.println("The index is out of bounds");
            System.exit(-1);
        }

        T temp = this.arrayList[index];
        arrayList[index] = x;

        T temp2;
        for (int i = index; i < this.arrayList.length - 1; i++) {
            temp2 = arrayList[i + 1];
            arrayList[i + 1] = temp;
            temp = temp2;
        }

        copyArray(0, "");
        this.elementsInArray++;
    }
