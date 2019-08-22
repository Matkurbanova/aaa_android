package kg.itrun.android.aaa.view.models;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import kg.itrun.android.aaa.data.Favorite;
import kg.itrun.android.aaa.data.Repository;

public class FavoriteViewModel extends ViewModel {
    private Repository repository;
    public FavoriteViewModel(){
        repository=Repository.getInstance();

    }
    public MutableLiveData<List<Favorite>>getFavorite(){
        return repository.getFavorite();
    }
}
