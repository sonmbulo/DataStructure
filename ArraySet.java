/* A simple array-based set */
public class ArraySet<T> {
    private T[] arraySet;
    private int size;

    public ArraySet() {
        arraySet = (T[]) new Object[100];
        size = 0;
    }

    /* return #t if x is in the set, #f otherwise. */
    public boolean contains(T x) {
        for (int i = 0; i < size; i++) {
            if (arraySet[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    /* add x to the set */
    public void add(T x) {
        if (!contains(x)) {
            arraySet[size] = x;
            size += 1;
        }
    }

    public int size() {
        return size;
    }
}

 
