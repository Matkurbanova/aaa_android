package kg.itrun.android.aaa.api.services;

import kg.itrun.android.aaa.data.Category;
import kg.itrun.android.aaa.data.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {

    @GET("login")
    Call<User>login(@Query("phone")String phone, @Query("password")String password);

    @GET("users/{user}")
    Call<User> getUser(@Path("user") String login);
}
