package kg.itrun.android.aaa.data;

import java.io.Serializable;

public class Product implements Serializable {

    public Product() {

    }

    public Product(String name) {
        this.name = name;
    }

    private String image;
    private String name;
    private double price;

    public void decrementCount(){
        if(count > 1){
            count--;
        }
    }
    public void incrementCount(){
        count++;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private int count;

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
