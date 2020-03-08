/* Basic SegmentTree data structure, which sum the given interval in O(log n) */
public class SegmentTree {

    private int[] tree;
    
    public SegmentTree(int[] a) {

        int n = a.length;

        tree = new int[4 * n];
        build(a, 1, 0, n - 1);
        tree[0] = n;
    }

    /** @params a[]: orginal quried array
     *          v: index of node in the segmentTree array, start at 1.
     *          l, r: represent the interval [l, r]
     */
    private void build(int[] a, int v, int l, int r) {

        if (l == r) {
            tree[v] = a[l];
            return;
        }
        int m = (l + r) / 2;
        build(a, 2 * v, l, m);//left tree
        build(a, 2 * v + 1, m + 1, r);//right tree
        tree[v] = tree[2 * v] + tree[2 * v + 1];
    }

    /** @params l, r: represent the queried interval [l, r]
     *  @output the sum of range[l, r]
     */
    public int sum(int l, int r) {
        return sum(1, 0, tree[0] - 1, l, r);
    }

    /** @params v: the node 
     *          tl, tr: the boundry of segment(node)
     *          l, r: the boundry of query
     */
    private int sum(int v, int tl, int tr, int l, int r) {
        if (tl == l && tr == r) {
            return tree[v];
        }
        int tm = (tl + tr) / 2;
        if (r <= tm) {
            return sum(2 * v, tl, tm, l, r);
        } else if (l > tm) {
            return sum(2 * v + 1, tm + 1, tr, l, r);
        } else {
            return sum(2 * v, tl, tm, l, tm) + sum(2 * v + 1, tm  + 1, tr, tm + 1, r);
        }
    }


    private void update(int v, int tl, int tr, int pos, int new_value) {
        if (tl == tr) {
            tree[v] = new_value;
            return;
        }
        int m = (tl + tr) / 2;
        if (pos <= m) {
            update(v, tl, m, pos, new_value);
        } else {
            update(v, m+1, tr, pos, new_value);
        }

        tree[v] = tree[2 * v] + tree[2 * v + 1];
    }


    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 3, 4, 5};

        SegmentTree st = new SegmentTree(a);

        int tree[] = st.tree;

        //Should return 9
        System.out.println(st.sum(1, 3));
    }
}


