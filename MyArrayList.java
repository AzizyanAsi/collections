package Collections;

import java.util.Iterator;

public class MyArrayList implements Iterable {

    private Object[] arrayList;
    private int elementsInArray;

    public MyArrayList() {
        this(10);
    }
    public MyArrayList(int n) {
        if (n <= 0) {
            System.out.println("The size must be greater than 0. Try again.");
            return;
        }

        this.arrayList = new Object[n];
        this.elementsInArray = 0;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int pointer = 0;
            @Override
            public boolean hasNext() {
                return pointer < elementsInArray;
            }

            @Override
            public Object next() {
                if (hasNext()){
                    pointer++;
                    return get(pointer);
                }
                return null;
            }
        };
    }

    public void add(Object x) {
        if (checkIfArrayFull()) {
            copyArray(0, "double");
        }

        this.arrayList[this.elementsInArray] = x;
        this.elementsInArray++;
    }

    public void add(int index, Object x) {
        if (checkIfArrayFull()) {
            copyArray(0, "double");
        }

        if (index >= this.arrayList.length) {
            System.out.println("The index is out of bounds");
            System.exit(-1);
        }

        Object temp = this.arrayList[index];
        arrayList[index] = x;

        Object temp2;
        for (int i = index; i < this.arrayList.length - 1; i++) {
            temp2 = arrayList[i + 1];
            arrayList[i + 1] = temp;
            temp = temp2;
        }

        copyArray(0, "");
        this.elementsInArray++;
    }

    public Object get(int index) {
        Object element = null;
        try {
            element = this.arrayList[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The index that you specified is not within bounds.");
            System.exit(-1);
        }

        return element;
    }

    public int size() {
        return this.elementsInArray;
    }

    public boolean isEmpty() {
        return this.elementsInArray == 0;
    }

    public boolean contains(Object ob) {
        return find(ob) >= 0;
    }

    public int find (Object n) {
        for (int i = 0; i < this.arrayList.length; i++) {
            if (n.equals(this.arrayList[i])) {
                return i;
            }
        }

        return -1;
    }

    public void remove (Object n) {
        for (int i = 0; i < this.elementsInArray; i++) {
            if (n.equals(this.arrayList[i])) {
                this.arrayList[i] = null;
                this.elementsInArray--;
                copyArray(0, "");
                return;
            }
        }
    }

    private boolean checkIfArrayFull() {
        return this.arrayList.length == this.elementsInArray;
    }

    private void copyArray(int size, String action) {
        size = increaseArraySize(size, action);

        Object[] tempArray = new Object[size];

        int tempElement = 0;

        for (int i = 0; i < this.arrayList.length; i++, tempElement++) {
            if (this.arrayList[i] == null) {
                tempElement--;
                continue;
            }

            tempArray[tempElement] = this.arrayList[i];
        }

        this.arrayList = null;
        this.arrayList = new Object[tempArray.length];
        this.arrayList = tempArray;
    }

    private int increaseArraySize(int size, String action) {
        if (action.equals("double")) {
            size = this.arrayList.length * 2;
        } else {
            size = this.arrayList.length + size;
        }

        return size;
    }
}

