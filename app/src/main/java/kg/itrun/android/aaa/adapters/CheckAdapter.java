package kg.itrun.android.aaa.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kg.itrun.android.aaa.R;
import kg.itrun.android.aaa.data.HistoryItem;

public class CheckAdapter extends RecyclerView.Adapter<CheckAdapter.CheckVH> {

    private LayoutInflater inflater;
    private Context context;

    private List<HistoryItem> historyItems = new ArrayList<>();

    public CheckAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void setHistoryItems(List<HistoryItem> historyItems) {
        this.historyItems.clear();
        this.historyItems.addAll(historyItems);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CheckVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_history, parent, false);
        return new CheckVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckVH holder, int position) {
        HistoryItem item = historyItems.get(position);
        holder.textViewCount.setText(String.valueOf(item.getProductsCount()));
        holder.textViewSum.setText(String.valueOf(item.getSum()));
        holder.textViewDate.setText(item.getDate());
    }

    @Override
    public int getItemCount() {
        return historyItems.size();
    }

    class CheckVH extends RecyclerView.ViewHolder {
        TextView textViewCount;
        TextView textViewSum;
        TextView textViewDate;

        public CheckVH(@NonNull View itemView) {
            super(itemView);
            textViewCount = itemView.findViewById(R.id.textViewCount);
            textViewSum = itemView.findViewById(R.id.textViewSum);
            textViewDate = itemView.findViewById(R.id.textViewDate);
        }
    }
}
