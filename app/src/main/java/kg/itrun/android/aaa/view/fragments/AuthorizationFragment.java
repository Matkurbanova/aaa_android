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

import com.squareup.picasso.Picasso;

import java.io.IOException;

import kg.itrun.android.aaa.AppStatics;
import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.api.AppApi;
import kg.itrun.android.aaa.data.User;
import kg.itrun.android.aaa.utils.Validator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthorizationFragment extends AppFragment implements View.OnClickListener {

    private Validator validator;
    private View view;
    private ImageView imageViewLogo;
    private TextView remember, registr;
    private EditText editTextNumber, editTextPassword;
    private Button buttonSignIn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.authorization_fragment, container, false);
        initViews(view);
        validator = new Validator(getContext());
        return view;
    }

    private void initViews(View v) {
        imageViewLogo = v.findViewById(R.id.imageViewLogo);
        remember = v.findViewById(R.id.textViewRemember);
        registr = v.findViewById(R.id.textViewRegistr);
        buttonSignIn = v.findViewById(R.id.buttonOk);
        editTextNumber = v.findViewById(R.id.editTextEmail);
        editTextPassword = v.findViewById(R.id.editTextPassword);

        registr.setOnClickListener(this);
        buttonSignIn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonOk:
                String phone = editTextNumber.getText().toString();
                String password = editTextPassword.getText().toString();
                AppApi.login(phone,password, new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful()) {
                            System.out.println(response.body().getName());
                            System.out.println(response.body().getSurname());
                            Picasso.with(getContext())
                                    .load(response.body().getAvatar())
                                    .into(imageViewLogo);
                        } else {
                            try {
                                System.out.println(response.errorBody().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        t.printStackTrace();
                    }
                });








//                try {
//                    validator.validate(editTextNumber, AppStatics.Rgxs.PHONE_NUMBER, R.string.put_number);
//                    validator.validate(editTextPassword, AppStatics.Rgxs.PASSWORD, R.string.wrong_format);
//
//                    Bundle bundle = new Bundle();
//                    bundle.putInt(AppStatics.ACTION, AppStatics.PAYMENT);
//                    listener.onAction(bundle);
//                } catch (ValidationException ex) {
//                    EditText editText = this.view.findViewById(ex.getViewId());
//                    editText.setError(ex.getMessage());
//                }
                break;
            case R.id.textViewRegistr:
                System.out.println();

                Bundle bundle = new Bundle();
                bundle.putInt(AppStatics.ACTION, AppStatics.REGISTRATION);
                listener.onAction(bundle);
                break;


        }
    }
}