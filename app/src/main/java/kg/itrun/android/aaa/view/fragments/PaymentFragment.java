package kg.itrun.android.aaa.view.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import kg.itrun.android.aaa.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentFragment extends AppFragment {

    private EditText editTextName, editTextPhone, editTextAddress, editTextAdditionalInfo, editTextDoorCode;
    private Button buttonToOrder;
    private RadioButton buttonCart, buttonCash;

    public PaymentFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment, container, false);
        initView(view);
        return view;
    }

    public void initView(View v) {
        editTextName = v.findViewById(R.id.editTextNamePayment);
        editTextPhone = v.findViewById(R.id.editTextPhonePayment);
        editTextAddress = v.findViewById(R.id.editTextAddressPayment);
        editTextDoorCode = v.findViewById(R.id.editTextDoorCode);
        editTextAdditionalInfo = v.findViewById(R.id.editTextAdditionalInfo);

        buttonToOrder = v.findViewById(R.id.buttonToOrder);
        buttonCart = v.findViewById(R.id.radioButtonCartPayment);
        buttonCash = v.findViewById(R.id.radioButtonCashPayment);
    }
}
