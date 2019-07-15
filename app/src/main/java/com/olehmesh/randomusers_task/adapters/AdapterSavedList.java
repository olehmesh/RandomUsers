package com.olehmesh.randomusers_task.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.olehmesh.randomusers_task.R;
import com.olehmesh.randomusers_task.database.EntityData;

import java.util.List;

public class AdapterSavedList extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<EntityData> dbEntityModels;
    private OnDeleteListener onDeleteListener;
    private Context context;

    public AdapterSavedList(Context context, List<EntityData> dbEntityModels) {
        this.context = context;
        this.dbEntityModels = dbEntityModels;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_list_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        final NewsViewHolder viewHolder = (NewsViewHolder) holder;

        viewHolder.savedName.setText(dbEntityModels.get(position).getName());
        viewHolder.savedCity.setText(dbEntityModels.get(position).getCity());

        Glide.with(context)
                .asBitmap()
                .load(dbEntityModels.get(position).getImage())
                .apply(new RequestOptions().override(Target.SIZE_ORIGINAL).encodeQuality(100))
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(viewHolder.ivSaved);
    }

    @Override
    public int getItemCount() {
        return dbEntityModels.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.savedName)
        public TextView savedName;

        @BindView(R.id.savedCity)
        public TextView savedCity;

        @BindView(R.id.ivSaved)
        public ImageView ivSaved;

        @BindView(R.id.delete)
        public TextView delete;

        NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            delete.setOnClickListener(view -> {
                onDeleteListener.onDelete(dbEntityModels.get(getAdapterPosition()));
                dbEntityModels.remove(getAdapterPosition());
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