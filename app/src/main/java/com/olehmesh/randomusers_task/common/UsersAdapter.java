package com.olehmesh.randomusers_task.common;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.olehmesh.randomusers_task.R;
import com.olehmesh.randomusers_task.custom_views.CustomTextView;
import com.olehmesh.randomusers_task.models.Result;
import com.olehmesh.randomusers_task.views.DetailActivity;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ItemViewHolder> {

    Context context;
    List<Result> mlist;
    Intent intent;

    public UsersAdapter(Context context, List<Result> list) {
        this.context = context;
        this.mlist = list;

    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder itemViewHolder, int i) {
        itemViewHolder.list = mlist.get(i);

        itemViewHolder.tvName.setText(mlist.get(i).getName().getFirst());
        itemViewHolder.tvCity.setText(mlist.get(i).getLocation().getCity());

        Glide.with(itemViewHolder.itemView.getContext())
                .asBitmap()
                .load(mlist.get(i).getPicture().getLarge())
                .apply(new RequestOptions()
                .override(Target.SIZE_ORIGINAL).encodeQuality(100))
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(itemViewHolder.ivAvatar);

        itemViewHolder.setOnItemClickListener(new ItemViewHolder.OnItemClickListener() {

            @Override
            public void onClick(View view, int position, boolean isLongClick) {

                intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra(String.valueOf(R.string.name), itemViewHolder.tvName.getText());
                intent.putExtra(String.valueOf(R.string.city), itemViewHolder.tvCity.getText());

             // itemViewHolder.ivAvatar.setDrawingCacheEnabled(true);
            //  Bitmap bitmap = itemViewHolder.ivAvatar.getDrawingCache();
             // intent.putExtra(String.valueOf(R.string.bitmap), bitmap);


                intent.putExtra(String.valueOf(R.string.image), mlist.get(position).getPicture().getLarge());

                intent.putExtra(String.valueOf(R.string.email), mlist.get(position).getEmail());
                intent.putExtra(String.valueOf(R.string.phone), mlist.get(position).getPhone());

                view.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        if (mlist == null) {
            return 0;
        }
        return mlist.size();
    }

    public void setData(List<Result> mlist) {
        this.mlist = mlist;
        notifyDataSetChanged();
    }

  public static class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

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
}
