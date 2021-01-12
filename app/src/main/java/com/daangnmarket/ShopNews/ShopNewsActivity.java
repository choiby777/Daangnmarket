package com.daangnmarket.ShopNews;

import android.os.Bundle;

import com.daangnmarket.Adapters.ShopImagePagerAdapter;
import com.daangnmarket.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import me.relex.circleindicator.CircleIndicator;

public class ShopNewsActivity extends AppCompatActivity {

    private static final String TAG = "ShopNewsActivity";
    private ViewPager pager;
    private ShopImagePagerAdapter pagerAdapter;
    private CircleIndicator indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_news);

        pager = findViewById(R.id.pager_images);
        pagerAdapter = new ShopImagePagerAdapter(this);
        pager.setAdapter(pagerAdapter);

        indicator = findViewById(R.id.indicator);
        indicator.setViewPager(pager);
    }
}
