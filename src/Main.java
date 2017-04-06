import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Child littleJimmy = new Child(1,"little Jimmy");

        Parent parent = new Parent();
        parent.setIdNum(11);
        parent.setName("Tammy");
        parent.setChild(littleJimmy);  //must new up littleJimmy

        System.out.println("parent before " + parent);

        FileOutputStream fos = new FileOutputStream("parentLog");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(parent);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("parentLog");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Parent reincarnated = (Parent) ois.readObject();
        System.out.println(reincarnated);

        //only flush the output.
        ois.close();

        //JSON
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(parent);
//        System.out.println("json is: " + json);
//
//        Parent foo2 = mapper.readValue(json, Parent.class);
//        System.out.println("parent is " + parent);
    }
}
