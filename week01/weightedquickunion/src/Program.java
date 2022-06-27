import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.println("Write array size: ");
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());

        var weightedQuickUnionUF = new WeightedQuickUnionUF(n);

        while (true) {
            System.out.println("Please select operation\n 1) " +
                    "\"u {p} {q}\" for union\n 2) " +
                    "\"c {p} {q}\" for connected \n 3)" +
                    "\"r {p} {q}\" root" +
                    "\n 4) \"q\" for quit");
            String line = scanner.nextLine();
            if (line.startsWith("q"))
                break;
            else {
                String[] words = line.split(" ");
                String op = words[0];
                int p = Integer.valueOf(words[1]);
                int q = Integer.valueOf(words[2]);
                if (op.equals("u")) {
                    weightedQuickUnionUF.union(p, q);
                } else if (op.equals("c")) {
                    boolean isConnected = weightedQuickUnionUF.connected(p, q);
                    System.out.println(p + " and " + q + " are " + (isConnected ? "" : "not ") + "connected");
                } else if (op.equals("r")) {
                    var rootP = weightedQuickUnionUF.root(p);
                    var rootQ = weightedQuickUnionUF.root(q);
                    System.out.println("p root is  " + rootP + " and q root is " + rootQ);
                }
            }
        }
    }
}
