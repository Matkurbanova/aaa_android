package kg.itrun.android.aaa.view.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import kg.itrun.android.aaa.R;

public class PersonalFragment extends Fragment
        implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private DatePickerDialog datePickerDialog;

    private ImageView imageViewAvatar;
    private TextView name;
    private TextView Bonus, Skidki, BonusSum, SkidkiSum;
    private Button buttonEdit;
    private ConstraintLayout layoutUserData;
    private EditText editName, editSrName, Namber, DpNamber, Password;
    private EditText editTextEmail;
    private TextView textViewBirthDate, textViewPol;
    private RadioButton radioButton1, radioButton2;

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
        radioButton1=v.findViewById(R.id.radioButton1);
        radioButton2=v.findViewById(R.id.radioButton2);
        buttonEdit.setOnClickListener(this);
        layoutUserData = v.findViewById(R.id.layoutUserData);
        layoutUserData.setVisibility(View.GONE);

        textViewBirthDate = v.findViewById(R.id.textViewDR);
        textViewBirthDate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnEdit:
                if (layoutUserData.getVisibility() != View.VISIBLE)
                    layoutUserData.setVisibility(View.VISIBLE);
                else
                    layoutUserData.setVisibility(View.GONE);
                break;
            case R.id.textViewDR:
                Calendar calendar = Calendar.getInstance();

                if (datePickerDialog != null && datePickerDialog.isShowing())
                    return;
                datePickerDialog =
                        new DatePickerDialog(getContext(), this,
                                calendar.get(Calendar.YEAR),
                                calendar.get(Calendar.MONTH),
                                calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
                break;
        }
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        String dateString = new SimpleDateFormat("dd-MM-YYYY")
                .format(calendar.getTime());
        textViewBirthDate.setText(dateString);
    }
}
