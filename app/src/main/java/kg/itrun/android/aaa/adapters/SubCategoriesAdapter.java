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
import kg.itrun.android.aaa.data.SubCategory;

public class SubCategoriesAdapter extends RecyclerView.Adapter<SubCategoriesAdapter.SubCategoryVH> {
    private List<SubCategory> subcategoriesList = new ArrayList<>();

    private LayoutInflater inflater;
    private SubCatListener subCatListener;
    private Context context;

    public SubCategoriesAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void setSubCategoriesList(List<SubCategory> subcategories) {
        subcategoriesList.clear();
        subcategoriesList.addAll(subcategories);
        notifyDataSetChanged();
    }

    public void setSubCatListener(SubCatListener subCatListener) {
        this.subCatListener = subCatListener;
    }

    @NonNull
    @Override
    public SubCategoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_subcategory, parent, false);
        return new SubCategoryVH(view);

    }

    @Override
    public void onBindViewHolder(@NonNull SubCategoryVH holder, int position) {
        final SubCategory subcategory = subcategoriesList.get(position);
        holder.textViewName.setText(subcategory.getName());
        holder.itemView.setOnClickListener(view -> subCatListener.onSubCategoryClick(subcategory));
        Picasso.with(context)
                .load(subcategory.getIcon_url())
                .into(holder.imageViewIcon);
    }

    @Override
    public int getItemCount() {
        return subcategoriesList.size();
    }

    public class SubCategoryVH extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private ImageView imageViewIcon;

        public SubCategoryVH(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewTitle);
            imageViewIcon = itemView.findViewById(R.id.imageViewIcon);
        }
    }

    public interface SubCatListener {
        void onSubCategoryClick(SubCategory subCategory);
    }
}
