import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class TreeTest {
    public static void main(String[] args) {

        try ( InputStreamReader input = new InputStreamReader(new FileInputStream("./resources/data.txt"))){
            Scanner sc = new Scanner(input);
            int n = sc.nextInt();
            int[] a = new int[n];
            SegmentTree tree = new SegmentTree(a);
            for (int i = 0; i < n; i++) {
                tree.set(i, sc.nextInt());
            }

            System.out.println(tree.sum(0,1,0,0,n-1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
