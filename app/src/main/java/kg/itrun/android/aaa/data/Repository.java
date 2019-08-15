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
    }

    private MutableLiveData<List<Product>> products = new MutableLiveData<>();
    private MutableLiveData<List<Product>> basketProducts = new MutableLiveData<>();

    private List<Product> basketProductsList = new ArrayList<>();
    private List<Product> productsList = new ArrayList<>();

    public MutableLiveData<List<Product>> getBasketProducts() {
        return basketProducts;
    }

    public MutableLiveData<List<Product>> getProducts() {
        return products;
    }

    public void addBasketProduct(Product product) {
        basketProductsList.add(product);
        basketProducts.setValue(basketProductsList);
    }
}
