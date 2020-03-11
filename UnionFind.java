import java.util.Arrays;

/** connect(x, y)
    isConnected */
public class UnionFind {
    private int[] unionFind;

    public UnionFind(int n) {
        unionFind = new int[n];
        Arrays.fill(unionFind, -1);
    }

    public void connect(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (!isConnected(x, y)) {
            if (parent(xRoot) > parent(yRoot)) {
                unionFind[xRoot] = yRoot;
            } else {
                unionFind[yRoot] = xRoot;
            }
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    private int parent(int x) {
        return unionFind[x];
    }

    //Get the index of x's root
    private int find(int x) {
        int root = x;
        while (parent(root) >= 0) {
            root = parent(root);
        }

        while(parent(x) >= 0) {
            int temp = parent(x);
            unionFind[x] = root;
            x = temp;
        }
        return root;
    }

    public static void main(String[] args) {
        UnionFind uFind = new UnionFind(20);
        
        uFind.connect(1, 3);
        uFind.connect(2, 11);
        uFind.connect(2, 5);
        uFind.connect(11, 6);
        uFind.connect(3, 6);
        uFind.connect(4, 8);


        //Should print true
        System.out.println(uFind.isConnected(1, 6));
        //Should print false
        System.out.println(uFind.isConnected(1, 7));
        //Should print false
        System.out.println(uFind.isConnected(1, 9));
        //Should print true
        System.out.println(uFind.isConnected(4, 8));
    }
} 
