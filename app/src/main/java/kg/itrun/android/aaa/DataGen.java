package kg.itrun.android.aaa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kg.itrun.android.aaa.data.Category;
import kg.itrun.android.aaa.data.SubCategory;

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

    public static String[] subCatNames = new String[]{
            "Детское питание",
            "Хлебобулочные изделия",
            "Овощи и фрукты",
            "Кондитерские изделия",
            "Молочная продукция ",
            "Рыба",
            "Чай, какао, кофе",
            "Сыры",
            "Консервы",
            "Напитки",
            "Сахар, соль,припавы",
            "Мясные и колбасные изделия",
            "Корм для домашних животных"
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

    public static List<SubCategory> genSubCategories(int count) {
        List<SubCategory> categories = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            SubCategory category = new SubCategory(subCatNames[random.nextInt(subCatNames.length)]);
            categories.add(category);
        }

        return categories;
    }
}
