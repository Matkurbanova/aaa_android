package kg.itrun.android.aaa.view.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import kg.itrun.android.aaa.R;


public class CodeFragment extends AppFragment
        implements View.OnClickListener {

    private View view;
    private EditText editCode;
    private TextView submit, backToLoginBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_code, container, false);
        initViews(view);
        return view;

    }

    private void initViews(View v) {
        view = v.findViewById(R.id.view);
        editCode = v.findViewById(R.id.editCode);
        backToLoginBtn = v.findViewById(R.id.backToLoginBtn);
        submit = v.findViewById(R.id.sumbit);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backToLoginBtn:
            case R.id.sumbit:


                break;


        }

    }
}
