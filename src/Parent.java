import java.io.Serializable;
public class Parent implements Serializable{
    private int idNum;
    private String name;
    private Child child;
    //GetSet ...
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
    public Child getChild() {
        return child;
    }
    public void setChild(Child child) {
        this.child = child;
    }
    //toString
    @Override
    public String toString() {
        return "Parent{" +
                "idNum=" + idNum +
                ", name='" + name + '\'' +
                ", child=" + child +
                '}';
    }
}
