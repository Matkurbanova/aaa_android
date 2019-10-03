package kg.itrun.android.aaa;

public class AppStatics {
    public static final String PRODUCT = "product";
    public static final String CATEGORY = "category";
    public static final String CATEGORY_ID = "category_id";
    public static final String ACTION = "action";
    public static final String NEWS = "news";

    public static final int REGISTRATION = 0;
    public static final int LOGIN = 1;
    public static final int CODE = 2;
    public static final int PAYMENT = 3;
    public static final int CATEGORY_SELECTED = 4;
    public static final int SUBCATEGORY_SELECTED = 5;
    public static final int PRODUCT_SELECTED = 6;
    public static final int PAY_CLICKED = 7;
    public static final int NEWS_CLICKED = 8;
    public static final int MORE_NEWS = 9;

    public static class Rgxs {
        public static final String PHONE_NUMBER = "\\+996(55|70|77|50|99)[0-9]{7}";
        public static final String PASSWORD = "[a-zA-Z@!#$%^&*(_+=\\-0-9/,.|\\\\]{6,}";
    }
}
