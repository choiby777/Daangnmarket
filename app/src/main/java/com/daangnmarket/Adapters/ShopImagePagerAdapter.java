package com.daangnmarket.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.daangnmarket.R;

public class ShopImagePagerAdapter extends PagerAdapter {

    private static final String TAG = "ShopNewsPagerAdapter";
    private int[] images = {R.drawable.car, R.drawable.ballon , R.drawable.fruit , R.drawable.house};
    private Context context;

    public ShopImagePagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (View)object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.pager_shop_news_image, container , false);

        ImageView imageView = view.findViewById(R.id.img_shop_news);
        imageView.setImageResource(images[position]);

        container.addView(view);

        return view;
    }
}
