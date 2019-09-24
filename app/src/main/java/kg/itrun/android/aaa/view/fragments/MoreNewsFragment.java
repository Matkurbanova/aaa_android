package kg.itrun.android.aaa.view.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import kg.itrun.android.aaa.AppStatics;
import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.data.News;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreNewsFragment extends AppFragment {

    private ImageView imageViewMoreNews, btnLike, btnShare;
    private TextView textViewText;
    private TextSwitcher textSwitcher;


    public MoreNewsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.more_news_fragment, container, false);
        initView(view);

        Bundle bundle = getArguments();
        if (bundle != null) {
            News news = (News) bundle.getSerializable(AppStatics.NEWS);
            initNews(news);
        }
        return view;
    }

    public void initView(View v) {
        imageViewMoreNews = v.findViewById(R.id.imageViewNews);
        btnLike = v.findViewById(R.id.btnLike);
        btnShare = v.findViewById(R.id.btnShare);
        textViewText = v.findViewById(R.id.textViewText);
        textSwitcher = v.findViewById(R.id.tsLikesCounter);
    }

    private void initNews(News news) {
        if (news != null) {
            textViewText.setText(news.getText());
            textSwitcher.setText(String.valueOf(news.getLikes()));
        }
    }
}



