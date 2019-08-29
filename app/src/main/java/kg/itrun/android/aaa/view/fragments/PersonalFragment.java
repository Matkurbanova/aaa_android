package kg.itrun.android.aaa.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import kg.itrun.android.aaa.R;

public class PersonalFragment extends Fragment implements View.OnClickListener {

    private ImageView imageViewAvatar;
    private TextView name;
    private TextView Bonus, Skidki, BonusSum, SkidkiSum;
    private Button buttonEdit;
    private ConstraintLayout layoutUserData;
    private EditText editName, editSrName, Namber, DpNamber, Password;
    private EditText editTextEmail;
    private TextView textViewDateRoj, textViewPol;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.personal_fragment, container, false);
        initViews(view);
        return view;

    }

    private void initViews(View v) {
        imageViewAvatar = v.findViewById(R.id.avatar);
        name = v.findViewById(R.id.textViewName);
        Bonus = v.findViewById(R.id.bonus);
        Skidki = v.findViewById(R.id.Skidki);
        BonusSum = v.findViewById(R.id.bonusSum);
        SkidkiSum = v.findViewById(R.id.SkidkiSum);
        buttonEdit = v.findViewById(R.id.btnEdit);
        buttonEdit.setOnClickListener(this);
        layoutUserData = v.findViewById(R.id.layoutUserData);
        layoutUserData.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnEdit:
                if (layoutUserData.getVisibility() != View.VISIBLE)
                    layoutUserData.setVisibility(View.VISIBLE);
                else
                    layoutUserData.setVisibility(View.GONE);
        }
    }
}
