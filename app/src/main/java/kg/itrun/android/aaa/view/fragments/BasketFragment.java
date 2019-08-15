package kg.itrun.android.aaa.view.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import kg.itrun.android.aaa.DataGen;
import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.adapters.BasketAdapter;
import kg.itrun.android.aaa.data.Product;
import kg.itrun.android.aaa.view.models.BasketViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class BasketFragment extends Fragment {

    private BasketViewModel viewModel;

    private RecyclerView recyclerView;
    private BasketAdapter basketAdapter;
    private TextView textViewSum, textViewDelivery, textViewTotal;
    private Button buttonBuy;

    private Observer<List<Product>> observer = new Observer<List<Product>>() {
        @Override
        public void onChanged(List<Product> products) {
            System.out.println(products.size());
            basketAdapter.setProducts(products);
            math();
        }
    };

    public BasketFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_basket, container, false);
        initRecyclerView(view);
        initView(view);

        ViewModelProvider provider = ViewModelProviders.of(this);
        viewModel = provider.get(BasketViewModel.class);
        viewModel.getProducts().observe(this, observer);

        return view;
    }

    public void initRecyclerView(View v) {
        recyclerView = v.findViewById(R.id.basketRecycler);
        basketAdapter = new BasketAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(basketAdapter);
    }

    public void initView(View vi) {
        textViewDelivery = vi.findViewById(R.id.textViewDelivery);
        textViewSum = vi.findViewById(R.id.textViewSum);
        textViewTotal = vi.findViewById(R.id.textViewTotal);
        buttonBuy = vi.findViewById(R.id.buttonBuy);
    }

    public void math() {
        double sum = basketAdapter.getSum();
        textViewSum.setText(String.valueOf(sum));
        textViewTotal.setText(String.valueOf(sum + 160));
    }

}
