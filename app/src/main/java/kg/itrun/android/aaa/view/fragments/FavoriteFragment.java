package kg.itrun.android.aaa.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kg.itrun.android.aaa.DataGen;
import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.adapters.FavoriteAdapter;
import kg.itrun.android.aaa.data.Favorite;
import kg.itrun.android.aaa.data.News;
import kg.itrun.android.aaa.view.models.BasketViewModel;
import kg.itrun.android.aaa.view.models.FavoriteViewModel;

public class FavoriteFragment extends AppFragment
        implements FavoriteAdapter.FavoriteAdapterListener {

    private RecyclerView recyclerViewFavorite;
    private FavoriteAdapter favoriteAdapter;
    private FavoriteViewModel favoriteViewModel;
    private BasketViewModel basketViewModel;
    private Observer<List<Favorite>> observer = new Observer<List<Favorite>>() {
        @Override
        public void onChanged(List<Favorite> favorites) {
            favoriteAdapter.setFavoriteList(favorites);
        }
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.favorite_fragment, container, false);
        initViews(view);
        ViewModelProvider basketProvider = ViewModelProviders.of(this);
        basketViewModel = basketProvider.get(BasketViewModel.class);
        return view;


    }

    private void initViews(View view) {
        recyclerViewFavorite = view.findViewById(R.id.favorite_recycler);
        favoriteAdapter = new FavoriteAdapter(getContext());
        favoriteAdapter.setListener(this);

        recyclerViewFavorite.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewFavorite.setLayoutManager(new GridLayoutManager(getContext(), 2));

        recyclerViewFavorite.setAdapter(favoriteAdapter);
        favoriteAdapter.setFavoriteList(DataGen.genFavorite(35));
    }

    @Override
    public void onFavoriteClick(Favorite favorite) {
        basketViewModel.addProduct(favorite);
        Toast.makeText(getContext(), getString(R.string.added), Toast.LENGTH_LONG).show();
    }
}
