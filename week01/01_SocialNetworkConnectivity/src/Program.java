import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        String filePath = "C:\\src\\algs4\\algorithms-i\\week01\\01_SocialNetworkConnectivity\\src\\log.txt";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        WeightedQuickUnionUF wqu = null;
        try {
            int n = 0;
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            int lineIndex = 0;
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (lineIndex == 0) {
                    n = Integer.valueOf(line.split(":")[1].trim());
                    System.out.println("There are " + n + " people");
                    wqu = new WeightedQuickUnionUF(n);
                } else {
                    String[] words = line.split(" ");
                    int one = Integer.valueOf(words[0].trim());
                    int two = Integer.valueOf(words[1].trim());
                    Date date = new Date();
                    try {
                        date = formatter.parse(words[2].trim());
                    } catch (ParseException ex) {
                        System.out.println(ex.getMessage());
                    }
                    wqu.union(one, two);
                    System.out.println(one + " and " + two + " became friends at " + date);
                    System.out.println(wqu.getComponentCount() + " different group");
                    if (wqu.getComponentCount() == 1) {
                        System.out.println("All of them are connected each other at " + date);
                        break;
                    }
                }
                lineIndex += 1;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
