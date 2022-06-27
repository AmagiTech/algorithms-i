public class WeightedQuickUnionUF {
    private final int[] id;
    private final int[] size;
    int componentCount = 0;


    public WeightedQuickUnionUF(int n) {
        this.componentCount = n;
        this.id = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i += 1) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public int getComponentCount() {
        return this.componentCount;
    }

    public int root(int i) {
        if (id[i] != i)
            return root(id[i]);
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        if (size[rootP] > size[rootQ]) {
            id[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            id[rootP] = rootQ;
            size[rootQ] = size[rootP];
        }
        componentCount -= 1;
    }
}
