package kg.itrun.android.aaa.view.models;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import kg.itrun.android.aaa.data.Product;
import kg.itrun.android.aaa.data.Repository;

public class ProductsViewModel extends ViewModel {
    private Repository repository;
    public ProductsViewModel(){
        repository = Repository.getInstance();
    }

    public MutableLiveData<List<Product>> getProducts(){
        return repository.getProducts();
    }
}
