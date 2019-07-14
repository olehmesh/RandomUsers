package com.olehmesh.randomusers_task.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.olehmesh.randomusers_task.R;
import com.olehmesh.randomusers_task.database.EntityData;

import java.util.List;

public class AdapterSavedList extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<EntityData> dataModels;
    private OnDeleteListener onDeleteListener;
    private Context context;

    public AdapterSavedList(Context context, List<EntityData> dataModels) {
        this.context = context;
        this.dataModels = dataModels;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_list_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final NewsViewHolder viewHolder = (NewsViewHolder) holder;
        viewHolder.savedName.setText(dataModels.get(position).getName());

        viewHolder.savedCity.setText(dataModels.get(position).getCity());
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.savedName)
        public TextView savedName;
        @BindView(R.id.savedCity)
        public TextView savedCity;

        @BindView(R.id.delete)
        public TextView delete;

        public NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            delete.setOnClickListener(view -> {
                onDeleteListener.onDelete(dataModels.get(getAdapterPosition()));
                dataModels.remove(getAdapterPosition());
                notifyItemRemoved(getAdapterPosition());
            });
        }
    }

    public void setOnDeleteListener(OnDeleteListener onDeleteListener) {
        this.onDeleteListener = onDeleteListener;
    }

    public interface OnDeleteListener {
        void onDelete(EntityData entityDatabase);
    }
}