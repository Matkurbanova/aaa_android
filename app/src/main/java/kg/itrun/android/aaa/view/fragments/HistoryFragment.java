package kg.itrun.android.aaa.view.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.time.Year;
import java.util.Calendar;
import java.util.Date;

import kg.itrun.android.aaa.MainActivity;
import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.adapters.PromoAdapter;

public class HistoryFragment extends AppFragment implements DatePickerDialog.OnDateSetListener {


    private TextView textViewFrom, textViewTo;
    private Calendar date = Calendar.getInstance();
    private DatePickerDialog datePickerDialog;
    private int i = -1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.history_fragment, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        textViewFrom = view.findViewById(R.id.textViewFrom);
        textViewTo = view.findViewById(R.id.textViewTo);
        setInitialDateTime();
        textViewFrom.setOnClickListener(view1 -> selectDate(0));

        textViewTo.setOnClickListener(view12 -> selectDate(1));


    }

    public void selectDate(int i) {
        this.i = i;
        datePickerDialog = new DatePickerDialog(getContext(), this,
                date.get(Calendar.YEAR),
                date.get(Calendar.MONTH),
                date.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();

    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        month++;
        if (i == 0)
            textViewFrom.setText(day + "-" + month + "-" + year);
        else if(i==1)
            textViewTo.setText(day + "-" + month + "-" + year);

    }

    private void setInitialDateTime() {
        textViewFrom.setText(DateUtils.formatDateTime(getContext(),
                date.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR | DateUtils.FORMAT_NUMERIC_DATE));

        textViewTo.setText(DateUtils.formatDateTime(getContext(),
                date.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR | DateUtils.FORMAT_NUMERIC_DATE));
    }


}
