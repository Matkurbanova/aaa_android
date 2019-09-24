package kg.itrun.android.aaa.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kg.itrun.android.aaa.AppStatics;
import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.adapters.ProductsAdapter;
import kg.itrun.android.aaa.data.Product;
import kg.itrun.android.aaa.view.models.BasketViewModel;
import kg.itrun.android.aaa.view.models.ProductsViewModel;

public class ProductsFragment extends AppFragment
        implements ProductsAdapter.ProductAdapterListener {

    private RecyclerView recyclerViewProducts;
    private ProductsAdapter productsAdapter;
    private ProductsViewModel productsViewModel;
    private BasketViewModel basketViewModel;

    private Observer<List<Product>> observer = new Observer<List<Product>>() {
        @Override
        public void onChanged(List<Product> products) {
            productsAdapter.setProductsList(products);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.products_fragment, container, false);
        initViews(view);
        ViewModelProvider provider = ViewModelProviders.of(this);
        productsViewModel = provider.get(ProductsViewModel.class);
        productsViewModel.getProducts().observe(this, observer);

        ViewModelProvider basketProvider = ViewModelProviders.of(this);
        basketViewModel = basketProvider.get(BasketViewModel.class);
        return view;
    }

    private void initViews(View view) {
        recyclerViewProducts = view.findViewById(R.id.products_recycler);
        productsAdapter = new ProductsAdapter(getContext());
        productsAdapter.setListener(this);
        recyclerViewProducts.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerViewProducts.setAdapter(productsAdapter);
    }

    @Override
    public void onProductClick(Product product) {
        Bundle bundle = createAction(AppStatics.PRODUCT_SELECTED);
        bundle.putSerializable(AppStatics.PRODUCT, product);
        notifyFragmentListener(bundle);
    }

    @Override
    public boolean onSearch(String query) {
        productsAdapter.filter(query);
        return true;
    }
}