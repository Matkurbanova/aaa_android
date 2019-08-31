package kg.itrun.android.aaa.view.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.facebook.login.widget.LoginButton;

import kg.itrun.android.aaa.R;


public class RegistrationFragment extends Fragment implements View.OnClickListener {
    private EditText editTextName, editTextUsername,editTextPhone,editTextEmail,editTextPassword,editTextConfirmPassword,editTextHB;
    private TextView textViewHB,textViewGender,textViewText,textViewOr;
    private ImageView imageViewGoogle;
    private LoginButton buttonFacebookLogin;
    private Button buttonConfirmPhone;
    private RadioButton radioButtonFemale,radioButtonMale;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_registration, container, false);
        initViews(view);
        return view;

    }
    private void initViews(View v) {
        imageViewGoogle = v.findViewById(R.id.imageViewGoogle);
        buttonFacebookLogin = v.findViewById(R.id.buttonFacebook);
        editTextName = v.findViewById(R.id.editTextName);
        editTextUsername = v.findViewById(R.id.editTextUsername);
        editTextPhone = v.findViewById(R.id.editTextPhone);
        editTextEmail = v.findViewById(R.id.editTextEmail);
        editTextPassword = v.findViewById(R.id.editTextPassword);
        editTextConfirmPassword = v.findViewById(R.id.editTextConfirmPassword);
        editTextHB=v.findViewById(R.id.editTextHB);
        textViewGender = v.findViewById(R.id.textViewGender);
        textViewText = v.findViewById(R.id.textViewText);
        textViewOr = v.findViewById(R.id.textViewOr);

        buttonConfirmPhone=v.findViewById(R.id.buttonConfirmPhone) ;
        radioButtonFemale=v.findViewById(R.id.radioButtonFemale);
        radioButtonMale=v.findViewById(R.id.radioButtonMale);
    }

    @Override
    public void onClick(View view) {


    }
}
