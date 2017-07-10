import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Hillel on 10.07.2017.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Path target = Paths.get("D:\\MyStuff.txt");
        Path file = Files.createFile(target);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("temp.out"))) {
            TestSerial ts = new TestSerial("name", 2);
            oos.writeObject(ts);
            oos.flush();
            oos.close();
        }
        catch (IOException ex)
        {
        }
        try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream("temp.out"))){
            TestSerial ts = (TestSerial)oin.readObject();
            ts.print();
            System.out.println(ts.getAge() + "   " + ts.getName());
        }
        catch (IOException | ClassNotFoundException ex)
        {
        }
    }

}
