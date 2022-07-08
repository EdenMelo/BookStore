package pojo;

public class Sales {
    private String name;
    private int buynum;

    public Sales() {
    }

    public Sales(String name, int buynum) {
        this.name = name;
        this.buynum = buynum;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "name='" + name + '\'' +
                ", buynum=" + buynum +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBuynum() {
        return buynum;
    }

    public void setBuynum(int buynum) {
        this.buynum = buynum;
    }
}
