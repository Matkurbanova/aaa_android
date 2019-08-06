package kg.itrun.android.aaa.view.fragments;

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

public class CategoryFragment extends Fragment {

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
        recyclerViewCategories.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewCategories.setAdapter(categoriesAdapter);

        categoriesAdapter.setCategoriesList(DataGen.genCategories(25));
    }
}
