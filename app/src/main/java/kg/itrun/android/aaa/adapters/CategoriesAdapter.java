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
import kg.itrun.android.aaa.data.Category;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryVH> {

    private List<Category> categoriesList = new ArrayList<>();

    private LayoutInflater inflater;

    private CategoryListener listener;

    public CategoriesAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setCategoriesList(List<Category> categories) {
        categoriesList.clear();
        categoriesList.addAll(categories);
        notifyDataSetChanged();
    }

    public void setListener(CategoryListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public CategoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_category, parent, false);
        return new CategoryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryVH holder, int position) {
        final Category category = categoriesList.get(position);
        holder.textViewName.setText(category.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onCategoryClick(category);
                System.out.println(category.getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    class CategoryVH extends RecyclerView.ViewHolder {

        private TextView textViewName;
        private ImageView imageViewIcon;

        public CategoryVH(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            imageViewIcon = itemView.findViewById(R.id.imageViewIcon);
        }
    }
}
