package kg.itrun.android.aaa.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import kg.itrun.android.aaa.DataGen;
import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.adapters.CategoriesAdapter;
import kg.itrun.android.aaa.adapters.CategoryListener;
import kg.itrun.android.aaa.data.Category;

public class CategoryFragment extends Fragment implements CategoryListener {

    private RecyclerView recyclerViewCategories;
    private CategoriesAdapter categoriesAdapter;
    private CategoryFragmentListener listener;

    @Override
    public void onAttach(Context context) {
        if (context instanceof CategoryFragmentListener)
            listener = (CategoryFragmentListener) context;
        super.onAttach(context);
    }

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

        categoriesAdapter.setCategoriesList(DataGen.genCategories(25));
    }

    @Override
    public void onCategoryClick(Category category) {
        if (listener != null)
            listener.onCategoryClick(category);
    }
}
