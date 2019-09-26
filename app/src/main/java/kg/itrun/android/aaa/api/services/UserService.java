package kg.itrun.android.aaa.api.services;

import com.google.gson.JsonObject;

import kg.itrun.android.aaa.data.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {
    @GET("users/{user}")
    Call<User> getUser(@Path("user") String login);
}
