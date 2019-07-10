package com.olehmesh.randomusers_task.views;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.olehmesh.randomusers_task.R;
import com.olehmesh.randomusers_task.custom_views.CustomTextView;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.tvDetailEmail)
    TextView tvDetailEmail;
    @BindView(R.id.tvDetailPhone)
    TextView tvDetailPhone;
    @BindView(R.id.tvDetailName)
    CustomTextView tvDetailName;
    @BindView(R.id.tvDetailCity)
    CustomTextView tvDetailCity;
    @BindView(R.id.ivDetailLarge)
    ImageView ivDetailLarge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        tvDetailName.setText("Name: " + getIntent().getStringExtra(String.valueOf(R.string.name)));
        tvDetailCity.setText("City: " + getIntent().getStringExtra(String.valueOf(R.string.city)));

        Glide.with(this).asBitmap()
                .load(getIntent().getStringExtra(String.valueOf(R.string.image)))
                .apply(new RequestOptions().override(Target.SIZE_ORIGINAL).encodeQuality(100))
                .into(ivDetailLarge);

        tvDetailEmail.setText("E-mail: " + getIntent().getStringExtra(String.valueOf(R.string.email)));
        tvDetailPhone.setText("Phone: " + getIntent().getStringExtra(String.valueOf(R.string.phone)));
    }

}
