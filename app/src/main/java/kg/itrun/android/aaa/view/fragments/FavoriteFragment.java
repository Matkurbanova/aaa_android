package kg.itrun.android.aaa.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import kg.itrun.android.aaa.DataGen;
import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.adapters.FavoriteAdapter;
import kg.itrun.android.aaa.data.Favorite;
import kg.itrun.android.aaa.view.models.FavoriteViewModel;

public class FavoriteFragment extends Fragment implements FavoriteAdapter.FavoriteAdapterListener {

    private RecyclerView recyclerViewFavorite;
    private FavoriteAdapter favoriteAdapter;
    private FavoriteFragmentListener listener;
    private FavoriteViewModel favoriteViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.favorite_fragment, container, false);
        initViews(view);
        return view;


    }
    private void initViews(View view) {
        recyclerViewFavorite = view.findViewById(R.id.favorite_recycler);
        favoriteAdapter = new FavoriteAdapter(getContext());

        recyclerViewFavorite.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewFavorite.setLayoutManager(new GridLayoutManager(getContext(), 2));

        recyclerViewFavorite.setAdapter(favoriteAdapter);
        favoriteAdapter.setFavoriteList(DataGen.genFavorite(35));
    }

    @Override
    public void onFavoriteClick(Favorite favorite) {
        listener.onFavoriteSelect(favorite);

    }
    public interface FavoriteFragmentListener{
        void onFavoriteSelect(Favorite favorite);
    }
}
