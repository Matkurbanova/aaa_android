package kg.itrun.android.aaa.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.data.Basket;

public class BasketAdapter extends RecyclerView.Adapter<BasketAdapter.BasketVH> {

    private LayoutInflater inflater;
    private BasketListener listener;

    public void setListener(BasketListener listener) {
        this.listener = listener;
    }

    private List<Basket> basketList;

    public BasketAdapter(Context context){
        inflater = LayoutInflater.from(context);
        basketList = new ArrayList<>();
    }

    public void setBasket(List<Basket>list){
        this.basketList.clear();
        this.basketList.addAll(list);
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
        final Basket basket = basketList.get(position);
        holder.textViewTitle.setText(basket.getName());
        holder.textViewDescription.setText(basket.getDescription());
        holder.editTextCount.setText(String.valueOf(basket.getCount()));
        holder.textViewPrice.setText(String.valueOf(basket.getPrice()));
        holder.imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basketList.remove(position);
                notifyDataSetChanged();
            }
        });
        holder.imageViewRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basket.decrementCount();
                listener.update();
                notifyDataSetChanged();
            }
        });
        holder.imageViewPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basket.incrementCount();
                listener.update();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return basketList.size();
    }

    public List<Basket> getBasket() {
        return basketList;
    }

    public double getSum(){
        double sum= 0;
        for (Basket p : basketList) {
            sum = sum + p.getPrice() * p.getCount();
        }
        return sum;
    }

    class BasketVH extends RecyclerView.ViewHolder {

        private TextView textViewTitle, textViewDescription,textViewPrice;
        private EditText editTextCount;
        private ImageView imageViewIcon,imageViewPlus, imageViewRemove, imageViewDelete;
        private Button buttonBuy;


        public BasketVH(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.titleBasket);
            textViewDescription = itemView.findViewById(R.id.descriptionBasket);
            editTextCount = itemView.findViewById(R.id.textViewCountText);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);

            imageViewIcon = itemView.findViewById(R.id.imageViewMain);
            imageViewPlus = itemView.findViewById(R.id.imageViewPlus);
            imageViewRemove = itemView.findViewById(R.id.imageViewMinus);
            imageViewDelete = itemView.findViewById(R.id.imageViewDelete);

            buttonBuy = itemView.findViewById(R.id.buttonBuy);
        }
    }

    public interface BasketListener{
        void update();
    }
}
