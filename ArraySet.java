import java.util.Iterator;

/* A simple array-based set */
public class ArraySet<T> implements Iterable<T> {
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
        if (x == null) {
            throw new IllegalArgumentException("can't add null");
        }
        if (!contains(x)) {
            arraySet[size] = x;
            size += 1;
        }
    }

    public int size() {
        return size;
    }

    private class setIterator implements Iterator<T> {

        int index;

        public setIterator() {
            index = 0;
        }

        /* return #t if there exists next element, #f otherwise */
        public boolean hasNext() {
            return index < size;
        }

        public T next() {
            T res = arraySet[index];
            index += 1;
            return res;
        }
    }

    public setIterator iterator() {
        return new setIterator();
    }

    public static void main(String[] args) {
        ArraySet<Integer> intSet = new ArraySet<>();
        ArraySet<String> strs = new ArraySet<>();
        intSet.add(1);
        intSet.add(2);
        intSet.add(3);

        /* should print 1 2 3 */
        for (int x : intSet) {
            System.out.print(x);
        }

    }
}





