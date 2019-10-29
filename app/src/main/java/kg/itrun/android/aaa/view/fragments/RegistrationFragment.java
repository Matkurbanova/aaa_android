package kg.itrun.android.aaa.view.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import kg.itrun.android.aaa.AppStatics;
import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.ValidationException;
import kg.itrun.android.aaa.utils.Validator;


public class RegistrationFragment extends AppFragment
        implements View.OnClickListener {

    private final int GOOGLE_SIGNIN_CODE = 1001;

    private View view;
    private Validator validator;
    private FirebaseAuth mAuth;
    private SignInButton signInButton;
    private GoogleSignInOptions gso;
    private GoogleSignInClient googleSignInClient;

    private EditText editTextName, editTextUsername, editTextPhone, editTextEmail, editTextPassword, editTextConfirmPassword, editTextHB;
    private TextView textViewHB, textViewGender, textViewText, textViewOr;
    private LoginButton buttonFacebookLogin;
    private Button buttonConfirmPhone;
    private RadioButton radioButtonFemale, radioButtonMale;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_registration, container, false);
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(getActivity(), gso);
        mAuth = FirebaseAuth.getInstance();

//        googleSignInClient.signOut();
        initViews(view);
        validator = new Validator(getContext());
        return view;

    }

    private void signIn() {
        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, GOOGLE_SIGNIN_CODE);
    }

    private void initViews(View v) {
        signInButton = v.findViewById(R.id.ButtonGoogle);
        signInButton.onClick(v);
        signInButton.setOnClickListener(this);
        buttonFacebookLogin = v.findViewById(R.id.buttonFacebook);
        editTextName = v.findViewById(R.id.editTextName);
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null)
            editTextName.setText(user.getDisplayName());
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
            case R.id.ButtonGoogle:
                signIn();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GOOGLE_SIGNIN_CODE) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            editTextName.setText(account.getFamilyName());
            editTextUsername.setText(account.getGivenName());
            editTextEmail.setText(account.getEmail());
        } catch (ApiException e) {
            Toast.makeText(getActivity(), "ERROR: " + e.getMessage(), Toast.LENGTH_SHORT)
                    .show();
        }
    }
}