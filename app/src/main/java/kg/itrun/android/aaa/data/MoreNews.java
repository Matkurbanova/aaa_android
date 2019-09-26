package kg.itrun.android.aaa.data;

public class MoreNews {
    public MoreNews() {

    }

    public MoreNews(String text) {
        this.text = text;
    }

    private String image;
    private String text;
    private String icon;
    private String links;
    private int likes;
    private boolean isLiked;

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public int getLikes(){
        return likes;
    }
    public void setLikes(int likes){
        this.likes=likes;
    }

    public String getLinks(){
        return links;
    }
    public void setLinks(String links){
        this.links=links;
    }

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String  icon) {
        this.icon = icon;
    }
}
