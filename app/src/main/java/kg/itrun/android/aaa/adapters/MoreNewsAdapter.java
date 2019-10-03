package kg.itrun.android.aaa.adapters;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.data.MoreNews;
import kg.itrun.android.aaa.data.News;


public class MoreNewsAdapter extends RecyclerView.Adapter<MoreNewsAdapter.MoreNewsVH>  {
    private List<News> newsList = new ArrayList<>();

    private LayoutInflater inflater;
    private Context context;

    public MoreNewsAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void setMoreNewsList(List<News> news) {
        newsList.clear();
        newsList.addAll(news);
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public MoreNewsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_more_news, parent, false);
        return new MoreNewsAdapter.MoreNewsVH(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MoreNewsVH holder, int position) {

        final News news = newsList.get(position);
        holder.textViewText.setText(news.getText());
        holder.updateLike(news);
        holder.btnLike.setOnClickListener(v -> {
            news.switchLike();
            holder.updateLike(news);
        });

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


    public class MoreNewsVH extends RecyclerView.ViewHolder {
        private ImageView imageViewMoreNews;
        private ImageView btnLike;
        private ImageView btnShare;
        private TextView textViewText;
        private TextSwitcher textSwitcher;


        public MoreNewsVH(@NonNull View itemView) {
            super(itemView);

            textViewText = itemView.findViewById(R.id.textViewText);
            btnLike = itemView.findViewById(R.id.btnLike);
            btnShare = itemView.findViewById(R.id.btnShare);
            imageViewMoreNews = itemView.findViewById(R.id.imageViewMoreNews);
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
}
