public class Foo {
    private String temp;
    private boolean flag;
    private double amount;

    public String getTemp() {
        return temp;
    }
    public void setTemp(String temp) {
        this.temp = temp;
    }
    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    @Override
    public String toString() {
        return "Foo{" +
                "temp='" + temp + '\'' +
                ", flag=" + flag +
                ", amount=" + amount +
                '}';
    }
}
