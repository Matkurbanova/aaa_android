package kg.itrun.android.aaa.api.services;

import java.util.List;

import kg.itrun.android.aaa.data.Category;
import kg.itrun.android.aaa.data.SubCategory;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CategoryServices {
    @GET("categories")
    Call<List<Category>> getCategories(@Query("offset") int offset,
                                       @Query("limit") int limit);

    @GET("sub-categories")
    Call<List<SubCategory>> getSubCategories(@Query("super_id") int superId,
                                             @Query("offset") int offset,
                                             @Query("limit") int limit);
}
