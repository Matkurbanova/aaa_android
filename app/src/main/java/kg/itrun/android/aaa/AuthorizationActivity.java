package kg.itrun.android.aaa;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import kg.itrun.android.aaa.view.fragments.AuthorizationFragment;
import kg.itrun.android.aaa.view.fragments.BasketFragment;
import kg.itrun.android.aaa.view.fragments.CodeFragment;
import kg.itrun.android.aaa.view.fragments.FragmentListener;
import kg.itrun.android.aaa.view.fragments.RegistrationFragment;


public class AuthorizationActivity extends AppCompatActivity
        implements FragmentListener {


    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        onAction(getIntent().getExtras());
    }


    private void showFragment(Class fragmentClass, String tag, Bundle bundle) {
        try {
            Fragment fragment = (Fragment) fragmentClass.newInstance();
            fragment.setArguments(bundle);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction().replace(R.id.authorization_frame, fragment);
            transaction.addToBackStack(tag);
            transaction.commit();

            currentFragment = fragment;
        } catch (IllegalAccessException | InstantiationException ex) {
            ex.printStackTrace();
        }
    }

    private void showFragment(Class fragmentClass, String tag) {
        showFragment(fragmentClass, tag, null);
    }

    private void showFragment(Class fragmentClass) {
        showFragment(fragmentClass, null);
    }

    @Override
    public void onAction(Bundle bundle) {
        int action = bundle.getInt(AppStatics.ACTION);
        switch (action) {
            case AppStatics.LOGIN:
                showFragment(AuthorizationFragment.class);
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
