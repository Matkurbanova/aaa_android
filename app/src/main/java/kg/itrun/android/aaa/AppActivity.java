package kg.itrun.android.aaa;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import kg.itrun.android.aaa.view.fragments.AppFragment;
import kg.itrun.android.aaa.view.fragments.FragmentListener;

public abstract class AppActivity extends AppCompatActivity
        implements FragmentListener {
    private AppFragment currentFragment;

    private int frameLayoutId;

    public AppActivity(int frameLayoutId) {
        this.frameLayoutId = frameLayoutId;
    }


    public void showFragment(Class fragmentClass, String tag, Bundle bundle) {
        try {
            AppFragment fragment = (AppFragment) fragmentClass.newInstance();
            fragment.setArguments(bundle);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction().replace(frameLayoutId, fragment);
            transaction.addToBackStack(tag);
            transaction.commit();

            currentFragment = fragment;
        } catch (IllegalAccessException | InstantiationException ex) {
            ex.printStackTrace();
        }
    }

    public void showFragment(Class fragmentClass, String tag) {
        showFragment(fragmentClass, tag, null);
    }

    public void showFragment(Class fragmentClass) {
        if (currentFragment != null)
            showFragment(fragmentClass, currentFragment.getTag());
        else
            showFragment(fragmentClass, null);
    }

    void shortToast(@StringRes int string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    void longToast(@StringRes int string) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }

    public AppFragment getCurrentFragment() {
        return currentFragment;
    }
}
