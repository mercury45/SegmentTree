import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DataGenerator {
    public static void main(String[] args) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter("./resources/data.txt")) {
            writer.write(10000 + "\n");
            for (int i = 0; i < 10000; i++) {
                int num = (int) (-10000 + Math.random() * 20000);
                writer.write("" + num + " ");
            }
        };


    }
}
