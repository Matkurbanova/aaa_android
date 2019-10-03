package kg.itrun.android.aaa.data;

import java.io.Serializable;

public class SubCategory extends Category implements Serializable {

    private int super_category;

    public SubCategory(String name) {
        super(name);
    }

    public int getSuperCategory() {
        return super_category;
    }

    public void setSuperCategory(int superCategory) {
        this.super_category = superCategory;
    }
}
