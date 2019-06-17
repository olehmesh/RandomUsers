package com.olehmesh.randomusers_task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

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



       // Bundle b = getIntent().getExtras();
      //  Bitmap bitmap = b.getParcelable(String.valueOf(R.string.bitmap));
     //   ivDetailLarge.setImageBitmap(bitmap);

        Glide.with(this).asBitmap()
                .load(getIntent().getStringExtra(String.valueOf(R.string.image)))
                .apply(new RequestOptions().override(Target.SIZE_ORIGINAL).encodeQuality(100))
                .into(ivDetailLarge);

        tvDetailEmail.setText("E-mail: " + getIntent().getStringExtra(String.valueOf(R.string.email)));
        tvDetailPhone.setText("Phone: " + getIntent().getStringExtra(String.valueOf(R.string.phone)));
    }

}
