package kg.itrun.android.aaa.view.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import kg.itrun.android.aaa.DataGen;
import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.adapters.BasketAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class BasketFragment extends Fragment {

    private RecyclerView recyclerView;
    private BasketAdapter basketAdapter;
    private TextView textViewSum, textViewDelivery,textViewTotal;
    private Button buttonBuy;

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
        math();
        return view;
    }

    public void initRecyclerView(View v){
        recyclerView = v.findViewById(R.id.basketRecycler);
        basketAdapter = new BasketAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(basketAdapter);

        basketAdapter.setProducts(DataGen.genProducts(20));
    }
    public void initView(View vi){
        textViewDelivery = vi.findViewById(R.id.textViewDelivery);
        textViewSum = vi.findViewById(R.id.textViewSum);
        textViewTotal = vi.findViewById(R.id.textViewTotal);
        buttonBuy = vi.findViewById(R.id.buttonBuy);
    }

    public void math(){
        double sum = basketAdapter.getSum();
        textViewSum.setText(String.valueOf(sum));
        textViewTotal.setText(String.valueOf(sum+160));
    }

}
