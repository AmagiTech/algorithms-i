import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.println("Write array size: ");
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());

        var quickFindUF = new QuickFindUF(n);

        while (true) {
            System.out.println("Please select operation\n 1) \"u {p} {q}\" for union\n 2) \"c {p} {q}\" for connected\n 3) \"q\" for quit");
            String line = scanner.nextLine();
            if (line.startsWith("q"))
                break;
            else {
                String[] words = line.split(" ");
                String op = words[0];
                int p = Integer.valueOf(words[1]);
                int q = Integer.valueOf(words[2]);
                if (op.equals("u")) {
                    quickFindUF.union(p, q);
                } else if (op.equals("c")) {
                    boolean isConnected = quickFindUF.connected(p, q);
                    System.out.println(p + " and " + q + " are " + (isConnected ? "" : "not ") + "connected");
                }
            }
        }


    }
}
