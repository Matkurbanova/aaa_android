package kg.itrun.android.aaa.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import kg.itrun.android.aaa.DataGen;
import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.adapters.CategoriesAdapter;
import kg.itrun.android.aaa.adapters.SubCategoriesAdapter;
import kg.itrun.android.aaa.data.SubCategory;


public class SubCategoryFragment extends Fragment implements SubCategoriesAdapter.SubCatListener {

    private RecyclerView recyclerViewSubCategories;
    private SubCategoriesAdapter subcategoriesAdapter;

    private SubCategoryFragmentListener subCategoryFragmentListener;

    @Override
    public void onAttach(Context context) {
        if (context instanceof SubCategoryFragmentListener)
            subCategoryFragmentListener = (SubCategoryFragmentListener) context;
        super.onAttach(context);
    }

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
        subCategoryFragmentListener.onSubCategorySelect(subCategory);
    }

    public interface SubCategoryFragmentListener {
        void onSubCategorySelect(SubCategory subCategory);
    }
}
