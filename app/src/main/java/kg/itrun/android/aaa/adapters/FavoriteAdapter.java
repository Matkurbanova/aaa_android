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
import kg.itrun.android.aaa.data.Favorite;


public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteVH> {
    private List<Favorite> favoriteList = new ArrayList<>();

    private LayoutInflater inflater;
    private Context context;

    public FavoriteAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
    }
    public void setFavoriteList(List<Favorite> favorite) {
        favoriteList.clear();
        favoriteList.addAll(favorite );
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public FavoriteVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_favorite, parent, false);
        return new FavoriteAdapter.FavoriteVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteAdapter.FavoriteVH holder, final int position) {
        final Favorite favorite = favoriteList.get(position);
        holder.textViewSubName.setText(favorite.getText());
        holder.textViewProductName.setText(favorite.getText());

        holder.textViewPrice.setText("" + favorite.getPrice());

        holder.imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                favoriteList.remove(position);
                notifyDataSetChanged();
            }
        });

    }



    @Override
    public int getItemCount() {
        return favoriteList.size();
    }

    public class FavoriteVH extends RecyclerView.ViewHolder {
        private TextView textViewSubName;
        private TextView textViewProductName;
        private ImageView imageViewFavorite;
        private TextView textViewPrice;
        private ImageView imageViewDelete;

        public FavoriteVH(@NonNull View itemView) {
            super(itemView);

            textViewSubName = itemView.findViewById(R.id.textViewSubName);
            textViewProductName = itemView.findViewById(R.id.textViewProductName);
            imageViewFavorite = itemView.findViewById(R.id.imageViewFavorite);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageViewDelete = itemView.findViewById(R.id.imageViewDelete);

        }
    }
}
