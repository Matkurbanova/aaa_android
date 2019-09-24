package kg.itrun.android.aaa.adapters;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.data.News;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsVH> {
    private List<News> newsList = new ArrayList<>();

    private LayoutInflater inflater;
    private Context context;
    private NewsAdapterListener listener;

    public NewsAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public NewsAdapterListener getListener() {
        return listener;
    }

    public void setListener(NewsAdapterListener listener) {
        this.listener = listener;
    }

    public void setNewsList(List<News> news) {
        newsList.clear();
        newsList.addAll(news);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_news, parent, false);


        return new NewsAdapter.NewsVH(view);

    }

    @Override
    public void onBindViewHolder(@NonNull NewsVH holder, int position) {

        final News news = newsList.get(position);
        holder.textViewText.setText(news.getText());
        holder.updateLike(news);
        holder.btnLike.setOnClickListener(v -> {
            news.switchLike();
            holder.updateLike(news);
        });

        Picasso.with(context)
                .load(news.getImage())
                .placeholder(R.drawable.news)
                .into(holder.imageViewNews);

        holder.textViewText.setOnClickListener(v -> listener.onNewsClick(news));

        holder.btnShare.setOnClickListener(v -> shareNews(news.getLinks()));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    private void shareNews(String url) {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, url);
        context.startActivity(Intent.createChooser(share, context.getString(R.string.share_news)));
    }

    public class NewsVH extends RecyclerView.ViewHolder {
        private ImageView imageViewNews;
        private ImageView btnLike;
        private ImageView btnShare;
        private TextView textViewText;
        private TextSwitcher textSwitcher;


        public NewsVH(@NonNull View itemView) {
            super(itemView);

            textViewText = itemView.findViewById(R.id.textViewText);
            btnLike = itemView.findViewById(R.id.btnLike);
            btnShare = itemView.findViewById(R.id.btnShare);
            imageViewNews = itemView.findViewById(R.id.imageViewNews);

            textSwitcher = itemView.findViewById(R.id.tsLikesCounter);
        }


        void updateLike(News news) {
            if (news.isLiked()) {
                this.btnLike.setImageDrawable(context.getDrawable(R.drawable.heart_50));
            } else {
                this.btnLike.setImageResource(R.drawable.ic_heart_outline_grey);
            }
            this.textSwitcher.setText(String.valueOf(news.getLikes()));
        }
    }

    public interface NewsAdapterListener {
        void onNewsClick(News news);
    }
}

