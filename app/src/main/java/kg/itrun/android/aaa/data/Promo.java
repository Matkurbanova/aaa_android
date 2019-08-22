package kg.itrun.android.aaa.data;

public class Promo extends Product {

    public Promo() {
    }

    public Promo(String name) {
        super(name);
    }

    private Double newPrice;
    private String promoDescription;

    public double getOldPrice() {
        return super.getPrice();
    }

    public void setOldPrice(double oldPrice) {
        setPrice(oldPrice);
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public String getPromoDescription() {
        return promoDescription;
    }


    public void setPromoDescription(String description) {
        this.promoDescription = description;
    }
}
