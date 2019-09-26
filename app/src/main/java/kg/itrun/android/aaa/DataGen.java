package kg.itrun.android.aaa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kg.itrun.android.aaa.data.Category;
import kg.itrun.android.aaa.data.Favorite;
import kg.itrun.android.aaa.data.Message;
import kg.itrun.android.aaa.data.MoreNews;
import kg.itrun.android.aaa.data.News;
import kg.itrun.android.aaa.data.Product;
import kg.itrun.android.aaa.data.Promo;
import kg.itrun.android.aaa.data.SubCategory;
import kg.itrun.android.aaa.data.User;

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

    public static String[] productNames = new String[]{
            "Банан",
            "Молоко",
            "Сыр",
            "Хлеб",
            "Сгущенное молоко",
            "Творог",
            "Шампунь",
            "Ручка"
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
    public static String[] newsTexts = new String[]{
            "Кто устал и хочет в отпуск? Выигрывайте ПОДАРКИ от KITKAT Senses в акции... еще",
            "Сок рекомендуется пить утром за завтраком. Если же дело совсем плохо...еще",

    };
    public static String[] MorenewsTexts = new String[]{
            "Кто устал и хочет в отпуск? Выигрывайте ПОДАРКИ от KITKAT Senses в акции.Бренд KITKAT представляет новую линейку шоколада – KITKAT Senses Gold Edition.\n" +
                    "\n" +
                    "Производитель заявляет, что продукт, созданный по уникальной рецептуре, обладает превосходным вкусом, который новинкам придает сочетание карамельного и белого шоколада с хрустящей вафлей в изысканном мраморном рисунке. Это элегантно подчеркивает стильный лаконичный дизайн золотой упаковки, который позволяет продукту выделяться на полке магазина, что вызовет, как ожидают, широкий интерес у покупателей.\n" +
                    "\n" +
                    "Ждем новинку!",
            "Сок рекомендуется пить утром за завтраком. Если же дело совсем плохо.Отметим, что это один из самых передовых и современных производственно-логистических центров занимает площадь 21 га.\n" +
                    "\n" +
                    "И выпускает соки с такими известными брендами, как \"Gracio\", \"ДаДа\" и \"Нектар Солнечный\", лимонады с сокосодержащим продуктом \"Нектар Солнечный\", холодные чаи \"Lipton\" и \"Пиала\", всемирно известный Pepsi, a также бутилированную воду \"A'SU\".\n" +
                    "\n" +
                    "Вся продукция сертифицирована и выпускается по международным стандартам качества пищевой промышленности, а также отвечает всем стандартам производства, согласно требованиям технических регламентов ТС.",

    };

    public static String[] subFavoriteNames = new String[]{
            "Чай Lipton",
            "Рыба",
            "Шоколад",
            "Творог",
            "Сыр ",
            "Сок",
            "Ручка",
            "Холодильник",

    };

    public static String[] jpgUrls = new String[]{
            "https://shop.coles.com.au/wcsstore/Coles-CAS/images/1/9/9/1993256.jpg",
            "https://assets.shop.loblaws.ca/products_jpeg/20175355001/en/20175355001_lrg_1_@1x.jpg",
            "https://cdn.webshopapp.com/shops/36165/files/238126463/leonidas-box-of-chocolates-1kg-220-lb.jpg"
    };

    public static Double prices[] = new Double[]
            {
                    new Double(32.5),
                    new Double(723.23),
                    new Double(33.23),
                    new Double(623.23),
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

    public static List<Product> genProducts(int count) {
        List<Product> products = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            Product product = new Product(productNames[random.nextInt(productNames.length)]);
            product.setDescription(newsTexts[random.nextInt(newsTexts.length)]);
            product.setPrice(random.nextInt(10000));
            products.add(product);
        }

        return products;
    }

    public static List<News> genNews(int count) {
        List<News> news = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            News new1 = new News(newsTexts[random.nextInt(newsTexts.length)]);
            new1.setLikes(random.nextInt(10000));
            new1.setLiked(random.nextBoolean());
            new1.setLinks("http://google.com");
            new1.setImage(jpgUrls[random.nextInt(jpgUrls.length)]);
            news.add(new1);
        }

        return news;
    }
    public static List<MoreNews> genMoreNews(int count) {
        List<MoreNews> moreNews = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            MoreNews moreNews1 = new MoreNews(MorenewsTexts[random.nextInt(MorenewsTexts.length)]);
            moreNews1.setLikes(random.nextInt(10000));
            moreNews1.setLiked(random.nextBoolean());
            moreNews1.setLinks("http://google.com");
            moreNews.add(moreNews1);
        }

        return moreNews;
    }

    public static List<Promo> genPromo(int count) {
        List<Promo> promos = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            Promo promo = new Promo(newsTexts[random.nextInt(newsTexts.length)]);
            promo.setOldPrice(prices[random.nextInt(prices.length)]);
            promo.setNewPrice(prices[random.nextInt(prices.length)]);
            promo.setName(productNames[random.nextInt(productNames.length)]);
            promo.setCount(1);
            promo.setPromoDescription(newsTexts[random.nextInt(newsTexts.length)]);
            promos.add(promo);
        }

        return promos;
    }

    public static List<Favorite> genFavorite(int count) {
        List<Favorite> favorites = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            Favorite favorite = new Favorite(newsTexts[random.nextInt(newsTexts.length)]);
            favorite.setPrice(prices[random.nextInt(prices.length)]);
            favorite.setName(productNames[random.nextInt(productNames.length)]);
            favorite.setImage(jpgUrls[random.nextInt(jpgUrls.length)]);
            favorites.add(favorite);
        }

        return favorites;
    }

    static String messageTexts[] = new String[]
            {
                    "Hello!",
                    "Salam!",
                    "Lorem ipsum dolor sit amet",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
            };

    public static List<Message> genMessage(int count) {
        Random random = new Random();
        List<Message> messages = new ArrayList<>();

        User users[] = new User[]{
                new User("01", "User 01"),
                new User("02", "User 02")
        };

        for (int i = 0; i < count; i++) {
            Message message = new Message(
                    String.valueOf(i),
                    messageTexts[random.nextInt(messageTexts.length)],
                    users[random.nextInt(users.length)]
            );
            messages.add(message);
        }
        return messages;
    }
}
