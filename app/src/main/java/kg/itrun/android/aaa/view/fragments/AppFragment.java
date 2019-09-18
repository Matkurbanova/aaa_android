package kg.itrun.android.aaa.view.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import kg.itrun.android.aaa.AppStatics;

public class AppFragment extends Fragment {
    public FragmentListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentListener)
            listener = (FragmentListener) context;
        else
            throw new IllegalArgumentException("Must implement " + FragmentListener.class.getName());
    }

    public void notifyFragmentListener(int action) {
        if (listener != null)
            listener.onAction(createAction(action));
    }

    public void notifyFragmentListener(Bundle bundle) {
        if (listener != null)
            listener.onAction(bundle);
    }

    public Bundle createAction(int action) {
        Bundle bundle = new Bundle();
        bundle.putInt(AppStatics.ACTION, action);
        return bundle;
    }
}
