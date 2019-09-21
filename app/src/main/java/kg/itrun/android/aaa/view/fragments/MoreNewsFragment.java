package kg.itrun.android.aaa.view.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import kg.itrun.android.aaa.R;

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
        return view;
    }

    public void initView(View v) {
        imageViewMoreNews = v.findViewById(R.id.imageViewNews);
        btnLike = v.findViewById(R.id.btnLike);
        btnShare = v.findViewById(R.id.btnShare);
        textViewText = v.findViewById(R.id.textViewText);
        textSwitcher = v.findViewById(R.id.tsLikesCounter);


    }


}



