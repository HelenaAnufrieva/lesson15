import java.io.*;

/**
 * Created by Hillel on 10.07.2017.
 */
public class Main {

    public static void main(String[] args) {

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
