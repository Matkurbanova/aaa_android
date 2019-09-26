package kg.itrun.android.aaa.data;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import kg.itrun.android.aaa.DataGen;

public class Repository {

    private static Repository instance;

    public static Repository getInstance() {
        if (instance == null)
            instance = new Repository();
        return instance;
    }

    private Repository() {
        productsList.addAll(DataGen.genProducts(25));

        products.setValue(productsList);

        favoriteList.addAll(DataGen.genFavorite(25));
        favorite.setValue(favoriteList);
    }

    private MutableLiveData<List<Favorite>> favorite = new MutableLiveData<>();
    private MutableLiveData<List<Favorite>> basketFavorite = new MutableLiveData<>();
    private List<Favorite> basketFavoriteList = new ArrayList<>();
    private List<Favorite> favoriteList = new ArrayList<>();


    private MutableLiveData<List<Product>> products = new MutableLiveData<>();
    private MutableLiveData<List<Basket>> basketProducts = new MutableLiveData<>();

    private List<Basket> basketProductsList = new ArrayList<>();
    private List<Product> productsList = new ArrayList<>();

    public MutableLiveData<List<Basket>> getBasketProducts() {
        return basketProducts;
    }

    public MutableLiveData<List<Product>> getProducts() {
        return products;
    }


    public void addBasketProduct(Basket product) {
        basketProductsList.add(product);
        basketProducts.setValue(basketProductsList);
    }

    public MutableLiveData<List<Favorite>> getFavorite() {
        return favorite;
    }

    public MutableLiveData<List<Favorite>> getBasketFavorite() {
        return basketFavorite;
    }

    public void addBasketFavorite(Favorite favorite) {
        basketFavoriteList.add(favorite);
        basketFavorite.setValue(basketFavoriteList);
    }
}
