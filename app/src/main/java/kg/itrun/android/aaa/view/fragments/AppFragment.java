package kg.itrun.android.aaa.view.fragments;

import android.content.Context;

import androidx.fragment.app.Fragment;

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
}
