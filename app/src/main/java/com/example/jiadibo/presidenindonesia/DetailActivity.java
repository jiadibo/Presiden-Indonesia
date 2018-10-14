package com.example.jiadibo.presidenindonesia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {
    private ImageView imgPres;
    private TextView tvName, tvKet, tvDesc, tvLahir, tvWafat, tvTinggi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        President p = getIntent().getParcelableExtra("PRESIDENT_OBJ");

        imgPres = findViewById(R.id.image);
        tvName = findViewById(R.id.tv_item_name);
        tvKet = findViewById(R.id.tv_ket);
        tvDesc = findViewById(R.id.tv_desc);
        tvLahir = findViewById(R.id.tv_lahir);
        tvWafat = findViewById(R.id.tv_wafat);
        tvTinggi = findViewById(R.id.tv_tinggi);

        Glide.with(this).load(p.getPhoto()).into(imgPres);
        tvName.setText(p.getName());
        tvKet.setText(p.getRemarks());






    }
}
