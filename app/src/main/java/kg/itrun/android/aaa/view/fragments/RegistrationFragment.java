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

import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import kg.itrun.android.aaa.AppStatics;
import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.ValidationException;
import kg.itrun.android.aaa.utils.Validator;


public class RegistrationFragment extends AppFragment
        implements View.OnClickListener {

    private View view;
    private Validator validator;

    private EditText editTextName, editTextUsername, editTextPhone, editTextEmail, editTextPassword, editTextConfirmPassword, editTextHB;
    private TextView textViewHB, textViewGender, textViewText, textViewOr;
    private Button ButtonGoogle;
    private LoginButton buttonFacebookLogin;
    private Button buttonConfirmPhone;
    private RadioButton radioButtonFemale, radioButtonMale;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_registration, container, false);
        initViews(view);
        validator = new Validator(getContext());
        return view;

    }

    private void initViews(View v) {
        ButtonGoogle = v.findViewById(R.id.ButtonGoogle);
        buttonFacebookLogin = v.findViewById(R.id.buttonFacebook);
        editTextName = v.findViewById(R.id.editTextName);
        editTextUsername = v.findViewById(R.id.editTextUsername);
        editTextPhone = v.findViewById(R.id.editTextPhone);
        editTextEmail = v.findViewById(R.id.editTextEmail);
        editTextPassword = v.findViewById(R.id.editTextPassword);
        editTextConfirmPassword = v.findViewById(R.id.editTextConfirmPassword);
        editTextHB = v.findViewById(R.id.editTextHB);
        textViewGender = v.findViewById(R.id.textViewGender);
        textViewText = v.findViewById(R.id.textViewText);
        textViewOr = v.findViewById(R.id.textViewOr);

        buttonConfirmPhone = v.findViewById(R.id.buttonConfirmPhone);
        radioButtonFemale = v.findViewById(R.id.radioButtonFemale);
        radioButtonMale = v.findViewById(R.id.radioButtonMale);

        buttonConfirmPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonConfirmPhone:
                try {
                    validator.validate(editTextName, null, R.string.put_name);
                    validator.validate(editTextPhone, AppStatics.Rgxs.PHONE_NUMBER, R.string.put_number);
                    validator.validate(editTextPassword, AppStatics.Rgxs.PASSWORD, R.string.wrong_format);
                    validator.validate(editTextConfirmPassword, AppStatics.Rgxs.PASSWORD, R.string.wrong_format);
                    validator.validateEquals(editTextPassword, editTextConfirmPassword,
                            R.string.passwords_not_maches);

                    notifyFragmentListener(AppStatics.CODE);
                } catch (ValidationException ex) {
                    EditText editText = this.view.findViewById(ex.getViewId());
                    editText.setError(ex.getMessage());
                }
                break;

        }
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
    }
}