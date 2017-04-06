import java.io.Serializable;

/**

 */
public class Child implements Serializable {
    private int idNum;
    private String name;
    private transient int social;

    public Child(int idNum, String name) {
        this.idNum = idNum;
        this.name = name;
    }

    //Do I need to new up littleJimmy?
    // Child littleJimmy = new Child();

    //GetSet

    public int getSocial() {
        return social;
    }

    public void setSocial(int social) {
        this.social = social;
    }

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Child{" +
                "idNum=" + idNum +
                ", name='" + name + '\'' +
                ", social=" + social +
                '}';
    }
}
