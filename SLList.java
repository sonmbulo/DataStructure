public class SLList<T> {
    private Node sentinel;
    int size;

    /* Nested class */
    public class Node {
        T element;
        Node next;

        public Node(T i, Node n) {
            element = i;
            next = n;
        }
    }

    public SLList() {
        sentinel = new Node(null, null);
        size = 0;
    }

    public SLList(T element) {
        sentinel = new Node(null, new Node(element, null));
        size = 1;
    }

    /*Add element in the front */
    public void addFirst(T x) {
        sentinel.next = new Node(x, sentinel.next);
        size += 1;
    }

    /* Remove the first elem */
    public T removeFirst() {
        T item = sentinel.next.element;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return item;
    }

    /* Add elem at the end. O(n) */
    public void addLast(T item) {
        Node p = sentinel.next;

        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node(item, null);
        size += 1;
    }

    /* Remove the last elem and return. O(n) */
    public T removeLast() {
        Node p = sentinel.next;

        while (p.next.next != null) {
            p = p.next;
        }
        T item = p.next.element;
        p.next = null;
        size -= 1;
        return item;
    }

    public void print() {
        Node p = sentinel.next;

        while (p != null) {
            System.out.print(p.element);
            p = p.next;
        }
        System.out.printf("\n");
    }

    public static void main(String[] args) {
        SLList<Integer> l1 = new SLList<>();
        l1.addFirst(1);
        l1.addFirst(2);
        l1.addFirst(3);
        l1.addLast(4);

        /* Should print "3214" */
        l1.print();

        SLList<String> l2 = new SLList<>("wow! ");
        l2.addLast("hello,");
        l2.addLast(" world!");

        /* Should print "wow! hello world!" */
        l2.print();

        l1.addLast(4);
        l1.addFirst(3);
        l1.removeFirst();
        l1.removeLast();

        /* Should be 4 */
        System.out.println(l1.size);
        
    }
}


























