package kg.itrun.android.aaa.adapters;

import android.content.Context;
import android.graphics.Paint;
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
import kg.itrun.android.aaa.data.Promo;

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.PromoVH> {

    private List<Promo> promoList = new ArrayList<>();

    private LayoutInflater inflater;
    private Context context;

    public PromoAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void setPromoList(List<Promo> promo) {
        promoList.clear();
        promoList.addAll(promo);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PromoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_promo, parent, false);
        return new PromoVH(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PromoAdapter.PromoVH holder, final int position) {
        final Promo promo = promoList.get(position);
        holder.textViewName.setText(promo.getName());
        holder.textViewNewPrice.setText("" + promo.getNewPrice());
        holder.textViewOldPrice.setPaintFlags(holder.textViewOldPrice.getPaintFlags() |
                Paint.STRIKE_THRU_TEXT_FLAG);
        holder.textViewProductInfo.setText(promo.getPromoDescription());

        holder.textQuantity.setText(String.valueOf(promo.getCount()));

        holder.promoMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                promo.decrementCount();
                notifyDataSetChanged();
            }
        });
        holder.promoPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                promo.incrementCount();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return promoList.size();

    }

    public class PromoVH extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewOldPrice;
        private TextView textViewNewPrice;
        private TextView textViewProductInfo;
        private TextView textQuantity;
        private ImageView share, promoMinus, promoPlus;


        public PromoVH(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textViewName);
            textViewOldPrice = itemView.findViewById(R.id.OldPrice);
            textViewNewPrice = itemView.findViewById(R.id.NewPrice);
            textViewProductInfo = itemView.findViewById(R.id.PromoInfo);
            promoPlus = itemView.findViewById(R.id.promoPlus);
            promoMinus = itemView.findViewById(R.id.promoMinus);
            textQuantity = itemView.findViewById(R.id.Quantity);

            share = itemView.findViewById(R.id.btnShare);
        }
    }


}
