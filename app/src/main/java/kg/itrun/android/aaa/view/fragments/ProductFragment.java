package kg.itrun.android.aaa.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import kg.itrun.android.aaa.AppStatics;
import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.data.Product;

public class ProductFragment extends AppFragment {

    private CarouselView carouselView;
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
        carouselView = v.findViewById(R.id.imageViewProduct);

        Bundle bundle = getArguments();
        if (bundle != null) {
            Product product = (Product) bundle.getSerializable(AppStatics.PRODUCT);
            initProduct(product);

            ImageListener imageListener = (position, imageView) -> Picasso.with(getContext())
                    .load(product.getImages().get(position))
                    .into(imageView);

            carouselView.setPageCount(product.getImages().size());
            carouselView.setImageListener(imageListener);
        }
    }

    private void initProduct(Product product) {
        textViewTitle.setText(product.getName());
    }
}
