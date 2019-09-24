package kg.itrun.android.aaa.data;

import java.io.Serializable;

public class News implements Serializable {
    public News() {
    }

    public News(String text) {
        this.text = text;
    }

    private String image;
    private String text;
    private String icon;
    private String links;
    private int likes;
    private boolean isLiked;

    public void incrementLikes() {
        likes++;
    }

    public void decrementLikes() {
        if (likes > 0) {
            likes--;
        }
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void switchLike() {
        if (isLiked) {
            decrementLikes();
        } else {
            incrementLikes();
        }
        isLiked = !isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
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

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
