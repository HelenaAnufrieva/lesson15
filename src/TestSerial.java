import java.io.Serializable;

/**
 * Created by Hillel on 10.07.2017.
 */
public class TestSerial implements Serializable{

    private transient String name;
    private static int age;

    public TestSerial() {
        name = "Name";
        age = 0;
    }

    public TestSerial(String name, int age) {
       this.age = age;
       this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public String getName()
    {
        return name;
    }

    public void print()
    {
        System.out.println(age + "   " + name);
    }

}
