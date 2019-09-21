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
import kg.itrun.android.aaa.adapters.NewsAdapter;
import kg.itrun.android.aaa.data.News;

public class NewsFragment extends AppFragment
        implements NewsAdapter.NewsAdapterListener {


    private RecyclerView recyclerViewNews;
    private NewsAdapter newsAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.news_fragment, container, false);
        initViews(view);
        return view;

    }

    private void initViews(View view) {
        recyclerViewNews = view.findViewById(R.id.news_recycler);
        newsAdapter = new NewsAdapter(getContext());
        newsAdapter.setListener(this);

        recyclerViewNews.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewNews.setAdapter(newsAdapter);
        newsAdapter.setNewsList(DataGen.genNews(35));
    }

    @Override
    public void onNewsClick(News news) {
        Bundle bundle = new Bundle();
        bundle.putInt(AppStatics.ACTION, AppStatics.NEWS_CLICKED);
        listener.onAction(bundle);
    }
}
