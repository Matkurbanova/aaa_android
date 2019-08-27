package kg.itrun.android.aaa.data;

public class Basket extends Product {

    public Basket() {
    }

    public Basket(String name) {
        super(name);
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
