package com.olehmesh.randomusers_task.adapters;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.olehmesh.randomusers_task.R;
import com.olehmesh.randomusers_task.custom_views.CustomTextView;
import com.olehmesh.randomusers_task.models.Result;

public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    OnItemClickListener onItemClickListener;

    Result list;

    @BindView(R.id.tvFirstName)
    CustomTextView tvName;
    @BindView(R.id.tvCity)
    CustomTextView tvCity;
    @BindView(R.id.ivAvatar)
    ImageView ivAvatar;


    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }


    public interface OnItemClickListener {
        void onClick(View view, int position, boolean isLongClick);
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.onItemClickListener = itemClickListener;
    }


    @Override
    public void onClick(View view) {
        onItemClickListener.onClick(view, getAdapterPosition(), false);
    }
}
