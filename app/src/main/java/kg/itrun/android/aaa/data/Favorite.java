package kg.itrun.android.aaa.data;

public class Favorite {
    public Favorite() {

    }
    public Favorite(String text) {
        this.text = text;
    }

    private String image;
    private String text;
    private double price;
    public String delete;

    public String getDelete(){
        return delete;
    }
    public void setDelete(String delete){
        this.delete=delete ;   }



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
