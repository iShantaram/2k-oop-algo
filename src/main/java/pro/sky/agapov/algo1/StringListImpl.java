package pro.sky.agapov.algo1;

import java.util.Arrays;

public class StringListImpl implements StringList {

    public static final double GROWING_COEFFICIENT = 2.0;
    private int capacity = 10;
    private int size = 0;
    private String[] elements;

    public StringListImpl(int capacity) {
        this.capacity = capacity;
        elements = new String[capacity];
    }

    public StringListImpl() {
        elements = new String[capacity];
    }

    @Override
    public String add(String item) {
        return add(size, item);
    }

    @Override
    public String add(int index, String item) {
        if (item != null) {
            if (index >= 0 && index <= size) {
                if (size == capacity) {
                    capacity = (int) (capacity * GROWING_COEFFICIENT) + 1;
                    elements = Arrays.copyOf(elements, capacity);
                }
                for (int i = index; i < size; i++) {
                    elements[i + 1] = elements[i];
                }
                elements[index] = item;
                size++;
                return item;
            } else {
                throw new IndexOutOfBoundsException("Index in method \"add\" must be in range of 0 and " + size + '.');
            }
        } else {
            throw new NullPointerException("Method \"add\" required not NULL parameter.");
        }
    }

    @Override
    public String set(int index, String item) {
        if (item != null) {
            if (index >= 0 && index < size) {
                elements[index] = item;
                return item;
            } else {
                throw new IndexOutOfBoundsException("Index in method \"set\" must be in range of 0 and " + (size-1) + '.');
            }
        } else {
            throw new NullPointerException("Method \"set\" required not NULL parameter.");
        }
    }

    @Override
    public String remove(String item) {
        if (item == null) {
            throw new NullPointerException("Method \"remove\" required not NULL parameter.");
        } else {
            return remove(indexOf(item));
        }
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index in method \"remove\" must be in range of 0 and " + (size - 1) + '.');
        } else {
            String item = elements[index];
            for (int i = index; i < size-1; i++) {
                elements[i] = elements[i+1];
            }
            size--;
            return item;
        }
    }

    @Override
    public boolean contains(String item) {
        if (indexOf(item) == -1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size-1; i >= 0; i--) {
            if (item.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index >= 0 && index < size) {
            return elements[index];
        } else {
            throw new IndexOutOfBoundsException("Index in method \"get\" must be in range of 0 and " + (size-1) + '.');
        }
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            return size == 0;
        }

        if (otherList.size() == size) {
            for (int i = 0; i < size; i++) {
                if (!elements[i].equals(otherList.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] stringArray = new String[size];
        for (int i = 0; i < size; i++) {
            stringArray[i] = elements[i];
        }
        return stringArray;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("StringList@" + Integer.toHexString(hashCode()) + " { ");
        for (int i = 0; i < size; i++) {
            s.append(elements[i]).append(" ");
        }
        s.append("}");
        return s.toString();
    }

    public int getCapacity() {
        return capacity;
    }
}
