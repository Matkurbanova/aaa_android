package kg.itrun.android.aaa.view.fragments;

import android.content.Context;
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
import androidx.fragment.app.Fragment;

import kg.itrun.android.aaa.AppStatics;
import kg.itrun.android.aaa.R;

public class AuthorizationFragment extends AppFragment implements View.OnClickListener {

    private ImageView imageViewLogo;
    private TextView remember, registr;
    private EditText editTextNamber, editTextPassword;
    private Button buttonSignIn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.authorization_fragment, container, false);
        initViews(view);
        return view;

    }

    private void initViews(View v) {
        imageViewLogo = v.findViewById(R.id.imageViewLogo);
        remember = v.findViewById(R.id.textViewRemember);
        registr = v.findViewById(R.id.textViewRegistr);
        buttonSignIn = v.findViewById(R.id.buttonOk);
        editTextNamber = v.findViewById(R.id.editTextEmail);
        editTextPassword = v.findViewById(R.id.editTextPassword);

        registr.setOnClickListener(this);
        buttonSignIn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonOk:
                buttonSignIn.setEnabled(false);
                String login = editTextNamber.getText().toString();
                String password = editTextPassword.getText().toString();
                if (login.isEmpty()) {
                    editTextNamber.setError("Введите номер");
                    return;

                }
                if (password.isEmpty()) {
                    editTextPassword.setError("Введите пароль");
                    return;

                }
                
Bundle bundle1 =new Bundle();
         bundle1.putInt(AppStatics.ACTION, AppStatics.PAYMENT);
                listener.onAction(bundle1);
                break;
            case R.id.textViewRegistr:
                Bundle bundle = new Bundle();
                bundle.putInt(AppStatics.ACTION, AppStatics.REGISTRATION);
                listener.onAction(bundle);
                break;
        }
    }
}

