package kg.itrun.android.aaa.data;

public class Promo {

    public Promo() {
    }

    public Promo(String name) {
        this.name = name;
    }

    private String name;
    private double oldPrice;
    private Double newPrice;
    private String productInfo;
    private String links;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double icon) {
        this.oldPrice = icon;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double icon) {
        this.newPrice = icon;
    }

    public String getProductInfo() {
        return productInfo;
    }


    public void setProductInfo(String icon) {
        this.productInfo = icon;
    }

    public String getLinks(){
        return links;
    }
}
