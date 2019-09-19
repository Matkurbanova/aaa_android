package kg.itrun.android.aaa.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import kg.itrun.android.aaa.DataGen;
import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.adapters.PromoAdapter;


public class PromoFragment extends AppFragment {

    private RecyclerView recyclerViewPromo;
    private PromoAdapter promoAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.promo_fragment, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        recyclerViewPromo = view.findViewById(R.id.promo_recycler);
        promoAdapter = new PromoAdapter(getContext());
        recyclerViewPromo.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewPromo.setAdapter(promoAdapter);

        promoAdapter.setPromoList(DataGen.genPromo(15));
    }

}
