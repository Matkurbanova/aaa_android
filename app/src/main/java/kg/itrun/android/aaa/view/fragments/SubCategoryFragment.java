package kg.itrun.android.aaa.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import kg.itrun.android.aaa.AppStatics;
import kg.itrun.android.aaa.DataGen;
import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.adapters.SubCategoriesAdapter;
import kg.itrun.android.aaa.data.SubCategory;


public class SubCategoryFragment extends AppFragment implements SubCategoriesAdapter.SubCatListener {

    private RecyclerView recyclerViewSubCategories;
    private SubCategoriesAdapter subcategoriesAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.subcategories_fragment, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        recyclerViewSubCategories = view.findViewById(R.id.subcategories_recycler);
        subcategoriesAdapter = new SubCategoriesAdapter(getContext());
        subcategoriesAdapter.setSubCatListener(this);
        recyclerViewSubCategories.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewSubCategories.setAdapter(subcategoriesAdapter);

        subcategoriesAdapter.setSubCategoriesList(DataGen.genSubCategories(35));
    }

    @Override
    public void onSubCategoryClick(SubCategory subCategory) {
        Bundle bundle = createAction(AppStatics.SUBCATEGORY_SELECTED);
        bundle.putSerializable(AppStatics.CATEGORY, subCategory);
        notifyFragmentListener(bundle);
    }
}
