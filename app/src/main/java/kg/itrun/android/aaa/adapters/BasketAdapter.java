package kg.itrun.android.aaa.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.data.Product;

public class BasketAdapter extends RecyclerView.Adapter<BasketAdapter.BasketVH> {

    private LayoutInflater inflater;

    private List<Product> products;

    public BasketAdapter(Context context){
        inflater = LayoutInflater.from(context);
        products = new ArrayList<>();
    }

    public void setProducts(List<Product>list){
        this.products.clear();
        this.products.addAll(list);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public BasketVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_basket, parent, false);
        return new BasketVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BasketVH holder, final int position) {
        final Product product = products.get(position);
        holder.textViewTitle.setText(product.getName());
        holder.textViewDescription.setText(product.getDescription());
        holder.editTextCount.setText(String.valueOf(product.getCount()));
        holder.textViewPrice.setText(String.valueOf(product.getPrice()));
        holder.imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                products.remove(position);
                notifyDataSetChanged();
            }
        });
        holder.imageViewRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product.decrementCount();
                notifyDataSetChanged();
            }
        });
        holder.imageViewPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product.incrementCount();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getSum(){
        double sum= 0;
        for (Product p : products) {
            sum = sum + p.getPrice() * p.getCount();
        }
        return sum;
    }

    class BasketVH extends RecyclerView.ViewHolder {

        private TextView textViewTitle, textViewDescription,textViewPrice;
        private EditText editTextCount;
        private ImageView imageViewIcon,imageViewPlus, imageViewRemove, imageViewDelete;


        public BasketVH(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.titleBasket);
            textViewDescription = itemView.findViewById(R.id.descriptionBasket);
            editTextCount = itemView.findViewById(R.id.textViewCount);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);

            imageViewIcon = itemView.findViewById(R.id.imageViewMain);
            imageViewPlus = itemView.findViewById(R.id.imageViewPlus);
            imageViewRemove = itemView.findViewById(R.id.imageViewMinus);
            imageViewDelete = itemView.findViewById(R.id.imageViewDelete);
        }
    }
}
