package kg.itrun.android.aaa;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import kg.itrun.android.aaa.view.fragments.RegistrationFragment;


public class AuthorizationActivity extends AppCompatActivity {
    private Fragment currentFragment;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    private void showFragment(Class fragmentClass, String tag, Bundle bundle) {
        try {
            Fragment fragment = (Fragment) fragmentClass.newInstance();
            fragment.setArguments(bundle);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment);
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

    @SuppressWarnings("StatementWithEmptyBody")
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.textViewRegistr:
                showFragment(RegistrationFragment.class);
                break;
        }

        return true;
    }
    }
