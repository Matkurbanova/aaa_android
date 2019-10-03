package kg.itrun.android.aaa.data;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {

    public Product() {

    }

    public Product(String name) {
        this.name = name;
    }

    private List<String> images;
    private String name;
    private String description;
    private double price;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
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
