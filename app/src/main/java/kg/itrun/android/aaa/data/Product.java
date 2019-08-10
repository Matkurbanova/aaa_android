package kg.itrun.android.aaa.data;

public class Product {

    public Product() {

    }

    public Product(String name) {
        this.name = name;
    }

    private String image;
    private String name;
    private double price;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
}
