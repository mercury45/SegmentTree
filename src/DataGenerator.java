import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DataGenerator {
    public static void main(String[] args) throws FileNotFoundException {
        generateIntegers();
        generateRange();


    }

    public static void generateIntegers() throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter("./resources/data.txt")) {
            writer.write(10000 + "\n");
            for (int i = 0; i < 10000; i++) {
                int num = (int) (-10000 + Math.random() * 20000);
                writer.write(num + " ");
            }
        };
    }

    public static void generateRange() throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter("./resources/rangesData.txt")) {
            writer.write(10000 + "\n");
            for (int i = 0; i < 10000; i++) {
                int num1 = (int) (Math.random() * 10000);
                int num2 = (int) (Math.random() * 10000);
                writer.write(Math.min(num1,num2) + " " + Math.max(num1,num2) + "\n");
            }
        };
    }
}
