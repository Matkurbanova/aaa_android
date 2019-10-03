package kg.itrun.android.aaa.api.services;

import java.util.List;

import kg.itrun.android.aaa.data.Product;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProductServices {
    @GET("products")
    Call<List<Product>> getProducts(@Query("category_id")int category_id);

}
