package kg.itrun.android.aaa.data;

public class Basket extends Product {

    public Basket() {
    }

    public Basket(String name) {
        super(name);
    }

    public Basket(Product product) {
        setPrice(product.getPrice());
        setDescription(product.getDescription());
        setName(product.getName());
        setImage(product.getImage());
    }

    public int count = 1;

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void decrementCount() {
        if (count > 1) {
            count--;
        }
    }

    public void incrementCount() {
        count++;
    }
}
