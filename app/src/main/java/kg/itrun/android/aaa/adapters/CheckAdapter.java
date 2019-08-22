package kg.itrun.android.aaa.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import kg.itrun.android.aaa.R;

class CheckAdapter extends RecyclerView.Adapter<CheckAdapter.CheckVH> {

    private LayoutInflater inflater;
    private Context context;

    public CheckAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public CheckVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_check, parent, false);
        return new CheckVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class CheckVH extends RecyclerView.ViewHolder {

        public CheckVH(@NonNull View itemView) {
            super(itemView);
        }
    }
}
