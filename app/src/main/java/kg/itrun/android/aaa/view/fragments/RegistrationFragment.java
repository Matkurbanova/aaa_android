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
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import com.facebook.login.widget.LoginButton;

import kg.itrun.android.aaa.AppStatics;
import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.ValidationException;


public class RegistrationFragment extends AppFragment
        implements View.OnClickListener {

    private View view;

    private EditText editTextName, editTextUsername, editTextPhone, editTextEmail, editTextPassword, editTextConfirmPassword, editTextHB;
    private TextView textViewHB, textViewGender, textViewText, textViewOr;
    private ImageView imageViewGoogle;
    private LoginButton buttonFacebookLogin;
    private Button buttonConfirmPhone;
    private RadioButton radioButtonFemale, radioButtonMale;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_registration, container, false);
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
                    validate(editTextName, null, R.string.put_name);
                    validate(editTextPhone, AppStatics.Rgxs.PHONE_NUMBER, R.string.put_number);
                    validate(editTextPassword, AppStatics.Rgxs.PASSWORD, R.string.wrong_format);
                    validate(editTextConfirmPassword, AppStatics.Rgxs.PASSWORD, R.string.wrong_format);

                    if (!editTextPassword.getText().toString()
                            .equals(editTextConfirmPassword.getText().toString()))
                        throw new ValidationException(editTextConfirmPassword.getId(),
                                getString(R.string.passwords_not_maches));

                    Bundle bundle = new Bundle();
                    bundle.putInt(AppStatics.ACTION, AppStatics.CODE);
                    listener.onAction(bundle);
                } catch (ValidationException ex) {
                    EditText editText = this.view.findViewById(ex.getViewId());
                    editText.setError(ex.getMessage());
                }
                break;
        }
    }

    private void validate(EditText editText, String regex, @StringRes int res)
            throws ValidationException {
        validate(editText.getText().toString(), regex, getString(res), editText.getId());
    }

    private void validate(EditText editText, String regex, String errorMessage)
            throws ValidationException {
        validate(editText.getText().toString(), regex, errorMessage, editText.getId());
    }

    /**
     * Validates EditText fields
     *
     * @param text         - string that must be validate
     * @param regex        - regular expression
     * @param errorMessage - error message if not valid
     * @param viewId       - view id to identify exception
     * @throws ValidationException
     */
    private void validate(String text, String regex, String errorMessage, int viewId)
            throws ValidationException {
        if (text == null || text.isEmpty())
            throw new ValidationException(viewId, errorMessage);

        if (regex != null && !text.matches(regex))
            throw new ValidationException(viewId, getString(R.string.wrong_format));
    }
}
