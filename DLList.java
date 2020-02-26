/** Simple circular double linked list */
public class DLList<T> {
    /* Why private? */
    private int size;
    private Node sentinel;
    
    public class Node {
        T item;
        Node pre;
        Node next;

        public Node(T item, Node p, Node n) {
            this.item = item;
            pre = p;
            next = n;
        }
    }

    /* empty DLList */
    public DLList() {
        size = 0;
        
        sentinel = new Node(null, null, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
    }

    public DLList(T item) {
        size = 1;
        
        DLList l = new DLList();
        Node newNode = new Node(item, l.sentinel, l.sentinel);
        l.sentinel.next = newNode;
        l.sentinel.pre = newNode;
        sentinel = l.sentinel;
    }

    public void addFirst(T x) {
        Node newNode = new Node(x, sentinel, sentinel.next);
        sentinel.next.pre = newNode;
        sentinel.next = newNode;
        size += 1;
    }
    
    public T removeFirst() {
        Node first = sentinel.next;
        sentinel.next = first.next;
        sentinel.next.pre = sentinel;
        first.next = null;
        first.pre = null;
        size -= 1;

        return first.item;
    }

    /* T(n) = O(1) */
    public void addLast(T x) {
        Node newNode = new Node(x, sentinel.pre, sentinel);
        sentinel.pre.next = newNode;
        sentinel.pre = newNode;

        size += 1;
    }

    /* T(n) = O(1) */
    public T removeLast() {
        Node last = sentinel.pre;
        last.pre.next = sentinel;
        sentinel.pre = last.pre;
        last.pre = null;
        last.next = null;
        
        size -= 1;
        return last.item;
    }

    public int size() {
        return size;
    }

    /* Print the items in the list in order */
    public void print() {
        Node p = sentinel.next;

        while(p != sentinel) {
            System.out.print(p.item);
            p = p.next;
        }

        System.out.printf("\n");
    }

    public static void main(String[] args) {
        DLList<Integer> l1 = new DLList<>();
        DLList<String> l2 = new DLList<>("1");

        l2.addLast("2");
        l2.addLast("0");
        l2.addLast("4");
        l2.addLast("9");
        l2.addLast("b");
        
        l1.addFirst(1);
        l2.removeLast();
        l2.removeFirst();
        l1.addFirst(2);
        l1.addFirst(9);
        l1.addLast(4);
        l1.addLast(8);
        l2.addLast("bbs");

        /* Should be 5 */
        System.out.println(l2.size());
        /* Should be "2049bbs" */
        l2.print();
        /* Should be "92148" */
        l1.print();
    }
}















        

