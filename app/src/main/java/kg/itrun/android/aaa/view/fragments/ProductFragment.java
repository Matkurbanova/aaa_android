package kg.itrun.android.aaa.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import kg.itrun.android.aaa.AppStatics;
import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.data.Product;

public class ProductFragment extends Fragment {

    private TextView textViewTitle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.product_fragment, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View v) {
        textViewTitle = v.findViewById(R.id.textViewTitle);

        Bundle bundle = getArguments();
        if (bundle != null) {
            Product product = (Product) bundle.getSerializable(AppStatics.PRODUCT);
            initProduct(product);
        }
    }

    private void initProduct(Product product) {
        textViewTitle.setText(product.getName());
    }
}
