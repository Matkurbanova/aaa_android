package kg.itrun.android.aaa.api;

import java.util.List;

import kg.itrun.android.aaa.api.services.CategoryServices;
import kg.itrun.android.aaa.api.services.UserService;
import kg.itrun.android.aaa.data.Category;
import kg.itrun.android.aaa.data.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppApi {

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://080803ee-0edc-40f7-9a49-8d73e2ffae15.mock.pstmn.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static void getUser(String login, Callback<User> callback) {
        UserService service = retrofit.create(UserService.class);
        Call<User> call = service.getUser(login);
        call.enqueue(callback);
    }

    public static void login(String phone, String password, Callback<User>callback){
        UserService service = retrofit.create(UserService.class);
        Call<User> call = service.login(phone,password);
        call.enqueue(callback);
    }
    public static void getCategories(int offset, int limit, Callback<List<Category>> callback){
        CategoryServices services = retrofit.create(CategoryServices.class);
        Call<List<Category>> call = services.getCategories(offset,limit);
        call.enqueue(callback);
    }
}
