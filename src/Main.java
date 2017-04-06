import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Child littleJimmy = new Child(1, "little Jimmy");
        littleJimmy.setSocial(44);
        Parent parent = new Parent();
        parent.setIdNum(11);
        parent.setName("Tammy");
        parent.setChild(littleJimmy);  //must new up littleJimmy
        System.out.println("parent before " + parent);

        // write to file
        FileOutputStream fos = new FileOutputStream("parentLog");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(parent);
        oos.flush();
        oos.close();

        // write to byte array
        ByteArrayOutputStream baos = new ByteArrayOutputStream(1000);
        oos = new ObjectOutputStream(baos);
        oos.writeObject(parent);
        oos.flush();
        oos.close();

        byte[] parentAsBytes = baos.toByteArray();

        // reading from file
        FileInputStream fis = new FileInputStream("parentLog");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Parent reincarnated = (Parent) ois.readObject();
        ois.close();
        System.out.println("PARENT HAS BEEN REINCARNATED AS " + reincarnated);

        // reading from byte array
        ByteArrayInputStream bais = new ByteArrayInputStream(parentAsBytes);
        ois = new ObjectInputStream(bais);
        Parent reincarnatedFromBytes = (Parent) ois.readObject();
        ois.close();
        System.out.println("PARENT HAS BEEN REINCARNATED from a byte array AS " + reincarnatedFromBytes);

        //JSON
        ObjectMapper mapper = new ObjectMapper();
        String jsonFromParent = mapper.writeValueAsString(parent);
        System.out.println("json is: " + jsonFromParent);

        System.out.println("Writing json to a file -> ");
        try (PrintWriter out = new PrintWriter(new FileWriter("parent.json"))) {
            out.println(jsonFromParent);
            out.flush();
            out.close();
        } catch (IOException e) {
            logException(e);

        }
        try (BufferedReader in = new BufferedReader(new FileReader("parent.json"))) {
            String jsonFromFile = in.readLine();
            in.close();

            Parent parent3 = mapper.readValue(jsonFromFile, Parent.class);
            System.out.println("jsonFromFIle is a representation of parent3 -> " + parent3);
        } catch (IOException e) {
            logException(e);
        }
    }
    static void logException(Throwable e) {
        System.out.println(e.getMessage());
    }
}
