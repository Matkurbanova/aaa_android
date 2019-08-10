package kg.itrun.android.aaa.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import kg.itrun.android.aaa.DataGen;
import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.adapters.CategoriesAdapter;
import kg.itrun.android.aaa.adapters.ProductsAdapter;

public class ProductsFragment extends Fragment {

    private RecyclerView recyclerViewProducts;
    private ProductsAdapter productsAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.products_fragment, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        recyclerViewProducts = view.findViewById(R.id.products_recycler);
        productsAdapter = new ProductsAdapter(getContext());
        recyclerViewProducts.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerViewProducts.setAdapter(productsAdapter);

        productsAdapter.setCategoriesList(DataGen.genProducts(25));
    }
}
