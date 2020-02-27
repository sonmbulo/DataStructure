/** Implement a simple ArrayList */
public class AList<T> {
    private T[] items;
    private int size;

    public AList() {
        items = (T[]) new Object[100];
        size = 0;
    }

    public T get(int i) {
        return items[i];
    }

    public void addLast(T x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size] = x;
        size += 1;
    }

    private void resize(int x) {
        T[] newItems = (T[]) new Object[x];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }

    public T getLast() {
        return items[size-1];
    }

    public T removeLast() {
        T item = items[size-1];
        items[size-1] = null;
        size -= 1;
        return item;
    }
}
