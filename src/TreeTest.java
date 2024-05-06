import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class TreeTest {
    static SegmentTree tree;
    public static void main(String[] args) throws FileNotFoundException {
        InputStreamReader input = new InputStreamReader(new FileInputStream("./resources/data.txt"));
        InputStreamReader input2 = new InputStreamReader(new FileInputStream("./resources/rangesData.txt"));
        testAdd(input);
        testFind(input2);
        testDelete();
    }

    public static void testAdd(InputStreamReader input) {
        try (OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream("./resources/AddResults.txt"))){
            Scanner sc = new Scanner(input);
            int n = sc.nextInt();
            int[] a = new int[n];
            tree = new SegmentTree(a);
            for (int i = 0; i < n; i++) {
                long st = System.nanoTime();
                tree.set(i, sc.nextInt());
                long end = System.nanoTime();
                output.write(tree.oper + " " + (end-st) + "\n");
                tree.oper = 0;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void testFind(InputStreamReader input) {
        try (OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream("./resources/FindResults.txt"))){
            Scanner sc = new Scanner(input);
            int n = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                int[] ranges = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                long st = System.nanoTime();
                tree.sum(ranges[0],ranges[1],0,0,n-1);
                long end = System.nanoTime();
                output.write(tree.oper + " " + (end-st) + "\n");
                tree.oper = 0;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void testDelete() {
        try (OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream("./resources/DeleteResults.txt"))) {
            for (int i = 0; i < 10000; i++) {
                int index = (int) (Math.random()*10000);
                long st = System.nanoTime();
                tree.remove(index);
                long end = System.nanoTime();
                output.write(tree.oper + " " + (end - st) + "\n");
                tree.oper = 0;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
