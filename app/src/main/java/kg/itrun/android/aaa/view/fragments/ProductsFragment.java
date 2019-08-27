package kg.itrun.android.aaa.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kg.itrun.android.aaa.DataGen;
import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.adapters.ProductsAdapter;
import kg.itrun.android.aaa.data.Basket;
import kg.itrun.android.aaa.data.Product;
import kg.itrun.android.aaa.view.models.BasketViewModel;
import kg.itrun.android.aaa.view.models.ProductsViewModel;

public class ProductsFragment extends Fragment
        implements ProductsAdapter.ProductAdapterListener {

    private RecyclerView recyclerViewProducts;
    private ProductsAdapter productsAdapter;
    private ProductsViewModel productsViewModel;
    private BasketViewModel basketViewModel;

    private ProductsFragmentListener listener;

    private Observer<List<Product>> observer = new Observer<List<Product>>() {
        @Override
        public void onChanged(List<Product> products) {
            productsAdapter.setCategoriesList(products);
        }
    };

    @Override
    public void onAttach(Context context) {
        if (context instanceof ProductsFragmentListener)
            listener = (ProductsFragmentListener) context;
        super.onAttach(context);
    }

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
        listener.onProductSelect(product);
    }

    public interface ProductsFragmentListener {
        void onProductSelect(Product product);
        basketViewModel.addProduct(new Basket(product));
        System.out.println("ADD TO BASKET: " + product.getName());
    }
}