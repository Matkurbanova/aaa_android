package kg.itrun.android.aaa.view.models;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import kg.itrun.android.aaa.data.Favorite;
import kg.itrun.android.aaa.data.Product;
import kg.itrun.android.aaa.data.Repository;

public class BasketViewModel extends ViewModel {
    private Repository repository;

    public BasketViewModel() {
        repository = Repository.getInstance();
    }

    public MutableLiveData<List<Product>> getProducts() {
        return repository.getBasketProducts();
    }

    public void addProduct(Product product) {
        repository.addBasketProduct(product);
    }
    public MutableLiveData<List<Favorite>>getFavorite(){
        return repository.getBasketFavorite();

    }
    public void addFavorite(Favorite favorite){
        repository.addBasketFavorite(favorite);
    }
}
