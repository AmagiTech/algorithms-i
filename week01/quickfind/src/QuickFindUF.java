public class QuickFindUF {
    private int[] id;

    public QuickFindUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i += 1) {
            id[i] = i;
        }
    }


    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pId = id[p];
        int qId = id[q];

        for (int i = 0; i < id.length; i += 1) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }
}
