package kg.itrun.android.aaa.data;

import java.io.Serializable;

public class SubCategory implements Serializable {
    public SubCategory() {

    }

    public SubCategory(String name) {
        this.name = name;
    }

    private String icon;

    private String name;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
