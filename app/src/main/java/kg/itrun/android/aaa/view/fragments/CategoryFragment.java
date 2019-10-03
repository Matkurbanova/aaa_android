package kg.itrun.android.aaa.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import kg.itrun.android.aaa.AppStatics;
import kg.itrun.android.aaa.DataGen;
import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.adapters.CategoriesAdapter;
import kg.itrun.android.aaa.api.AppApi;
import kg.itrun.android.aaa.data.Category;
import kg.itrun.android.aaa.data.SubCategory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryFragment extends AppFragment
        implements CategoriesAdapter.CategoryListener {

    private RecyclerView recyclerViewCategories;
    private CategoriesAdapter categoriesAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.categories_fragment, container, false);
        initViews(view);
        return view;
    }


    private void initViews(View view) {
        recyclerViewCategories = view.findViewById(R.id.categories_recycler);
        categoriesAdapter = new CategoriesAdapter(getContext());
        categoriesAdapter.setListener(this);
        recyclerViewCategories.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewCategories.setAdapter(categoriesAdapter);

        AppApi.getCategories(0, 10, new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.isSuccessful()) {
                    categoriesAdapter.setCategoriesList(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onCategoryClick(Category category) {
        Bundle bundle = new Bundle();
        bundle.putInt(AppStatics.ACTION, AppStatics.CATEGORY_SELECTED);
        bundle.putSerializable(AppStatics.CATEGORY, category);
        notifyFragmentListener(bundle);
    }
}
