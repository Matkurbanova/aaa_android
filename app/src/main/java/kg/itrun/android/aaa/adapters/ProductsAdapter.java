package kg.itrun.android.aaa.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.data.Product;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductsVH> {

    private List<Product> productsList = new ArrayList<>();

    private LayoutInflater inflater;

    public ProductsAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setCategoriesList(List<Product> products) {
        productsList.clear();
        productsList.addAll(products );
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
        Product products = productsList.get(position);
        holder.textViewName.setText(products.getName());
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
            textViewPrice = itemView.findViewById(R.id.textViewSom);
            imageViewProduct = itemView.findViewById(R.id.imageViewProduct);
        }
    }
}