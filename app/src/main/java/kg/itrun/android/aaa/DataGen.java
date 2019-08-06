package kg.itrun.android.aaa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kg.itrun.android.aaa.data.Category;

public class DataGen {

    public static String[] catNames = new String[]{
            "Продукты",
            "Товары для дома",
            "Дача и сад",
            "Бытовая техника",
            "Игрушки",
            "Хоз товары",
            "Красота и здоровье",
            "Канцтовары"
    };

    public static List<Category> genCategories(int count) {
        List<Category> categories = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            Category category = new Category(catNames[random.nextInt(catNames.length)]);
            categories.add(category);
        }

        return categories;
    }
}
