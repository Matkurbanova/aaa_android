package kg.itrun.android.aaa.api;

import com.google.gson.JsonObject;

import kg.itrun.android.aaa.api.services.UserService;
import kg.itrun.android.aaa.data.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppApi {

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static void getUser(String login, Callback<User> callback) {
        UserService service = retrofit.create(UserService.class);
        Call<User> call = service.getUser(login);
        call.enqueue(callback);
    }
}
