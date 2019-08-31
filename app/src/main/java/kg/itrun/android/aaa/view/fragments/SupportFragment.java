package kg.itrun.android.aaa.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.stfalcon.chatkit.messages.MessagesList;
import com.stfalcon.chatkit.messages.MessagesListAdapter;

import kg.itrun.android.aaa.DataGen;
import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.data.Message;

public class SupportFragment extends Fragment {

    private MessagesList messagesList;
    private MessagesListAdapter<Message> listAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_support, container, false);
        initView(view);
        listAdapter = new MessagesListAdapter<>("01", null);
        listAdapter.addToEnd(DataGen.genMessage(10), true);
        messagesList.setAdapter(listAdapter);
        return view;
    }

    private void initView(View v) {
        messagesList = v.findViewById(R.id.messageList);
    }
}