package kg.itrun.android.aaa.api.services;

import java.util.List;

import kg.itrun.android.aaa.data.News;
import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsServices {
    @GET("news")
    Call<List<News>>getNews();
}
