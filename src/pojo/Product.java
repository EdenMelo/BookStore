package pojo;

import java.util.Objects;

public class Product {
    private String id;
    private String name;
    private double price;
    //商品类型
    private String category;
    //商品数量/库存
    private int pnum;
    //商品图片
    private String imgurl;
    //商品描述
    private String description;

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", pnum=" + pnum +
                ", imgurl='" + imgurl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Product() {
    }

    public Product(String id, String name, double price, String category, int pnum, String imgurl, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.pnum = pnum;
        this.imgurl = imgurl;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPnum() {
        return pnum;
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && pnum == product.pnum && Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(category, product.category) && Objects.equals(imgurl, product.imgurl) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, category, pnum, imgurl, description);
    }
}
