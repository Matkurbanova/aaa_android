package kg.itrun.android.aaa.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.data.Basket;
import kg.itrun.android.aaa.data.Product;
import kg.itrun.android.aaa.data.Repository;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductsVH> {

    private List<Product> productsList = new ArrayList<>();

    private LayoutInflater inflater;

    private ProductAdapterListener listener;
    private Context context;

    public ProductsAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void setListener(ProductAdapterListener listener) {
        this.listener = listener;
    }

    public void setProductsList(List<Product> products) {
        productsList.clear();
        productsList.addAll(products);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_products, parent, false);
        return new ProductsVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsVH holder, int position) {
        final Product products = productsList.get(position);
        holder.textViewName.setText(products.getName());
        String firstImageUrl = "";
        if (products.getImages().size() > 0)
            firstImageUrl = products.getImages().get(0);

        Picasso.with(context)
                .load(firstImageUrl)
                .into(holder.imageViewProduct);

        holder.itemView.setOnClickListener(view -> {
            if (listener != null) {
                listener.onProductClick(products);
            }
        });
    }

    public void filter(String filter) {
        List<Product> filtered = new ArrayList<>();
        for (Product product : productsList) {
            if (product.getName().toUpperCase()
                    .startsWith(filter.toUpperCase()))
                filtered.add(product);
        }
        productsList.clear();
        productsList.addAll(filtered);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    class ProductsVH extends RecyclerView.ViewHolder {

        private TextView textViewName;
        private TextView textViewPrice;
        private ImageView imageViewProduct;

        public ProductsVH(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewTitle);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageViewProduct = itemView.findViewById(R.id.imageViewProduct);
        }
    }

    public interface ProductAdapterListener {
        void onProductClick(Product product);
    }
}