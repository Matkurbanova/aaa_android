package kg.itrun.android.aaa.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.List;

import kg.itrun.android.aaa.AppStatics;
import kg.itrun.android.aaa.DataGen;
import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.adapters.NewsAdapter;
import kg.itrun.android.aaa.api.AppApi;
import kg.itrun.android.aaa.data.News;
import kg.itrun.android.aaa.data.Product;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFragment extends AppFragment
        implements NewsAdapter.NewsAdapterListener {


    private RecyclerView recyclerViewNews;
    private NewsAdapter newsAdapter;
    private CarouselView carouselView;
    private TextView textView;
    private Observer<List<News>> observer = new Observer<List<News>>() {
        @Override
        public void onChanged(List<News> news) {
            newsAdapter.setNewsList(news);
        }
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.news_fragment, container, false);


        initViews(view);
        return view;

    }

    private void initViews(View view) {
        recyclerViewNews = view.findViewById(R.id.news_recycler);
        carouselView=view.findViewById(R.id.imageViewNews);
        newsAdapter = new NewsAdapter(getContext());
        newsAdapter.setListener(this);
        textView=view.findViewById(R.id.textViewText);

        recyclerViewNews.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewNews.setAdapter(newsAdapter);

        Bundle bundle = getArguments();
        if (bundle != null) {
            News news = (News) bundle.getSerializable(AppStatics.NEWS);
            initNew(news);

        ImageListener imageListener = (position, imageViewNews) -> Picasso.with(getContext())
                .load(news.getImage().get(position))
                .into(imageViewNews);

        carouselView.setPageCount(news.getImage().size());
        carouselView.setImageListener(imageListener);

    }
        getNews();

    }

    private void getNews(){
        AppApi.getNews(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                newsAdapter.setNewsList(response.body());
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {

            }
        });
    }
    @Override
    public void onNewsClick(News news) {
        Bundle bundle = new Bundle();
        bundle.putInt(AppStatics.ACTION, AppStatics.NEWS_CLICKED);
        bundle.putSerializable(AppStatics.NEWS, news);
        listener.onAction(bundle);
    }

    @Override
    public boolean onSearch(String query) {
        if (query.isEmpty())
            newsAdapter.setNewsList(DataGen.genNews(35));
        else
            newsAdapter.filter(query);
        return true;
    }
    private void initNew(News news) {
        textView.setText(news.getText());
}}
