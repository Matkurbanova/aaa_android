package kg.itrun.android.aaa;

import android.os.Bundle;

import kg.itrun.android.aaa.view.fragments.*;


public class AuthorizationActivity extends AppActivity {

    public AuthorizationActivity() {
        super(R.id.authorization_frame);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        onAction(getIntent().getExtras());
    }

    @Override
    public void onAction(Bundle bundle) {
        int action = bundle.getInt(AppStatics.ACTION);
        switch (action) {
            case AppStatics.LOGIN:
                showFragment(AuthorizationFragment.class);
                shortToast(R.string.added);
                break;
            case AppStatics.REGISTRATION:
                showFragment(RegistrationFragment.class);
                break;
            case AppStatics.CODE:
                showFragment(CodeFragment.class);
                break;
            case AppStatics.PAYMENT:
                showFragment(BasketFragment.class);

        }
    }
}
