package com.daangnmarket.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.daangnmarket.Models.Shop;
import com.daangnmarket.Models.ShowNews;
import com.daangnmarket.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class ShopNewsListAdapter extends RecyclerView.Adapter<ShopNewsListAdapter.RecommendShopListViewHolder>{

    private List<ShowNews> shopNewsList;

    public static class RecommendShopListViewHolder extends RecyclerView.ViewHolder {

        public RecommendShopListViewHolder(View v) {
            super(v);
        }
    }

    public ShopNewsListAdapter(List<ShowNews> shopList) {
        this.shopNewsList = shopList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ShopNewsListAdapter.RecommendShopListViewHolder onCreateViewHolder(ViewGroup parent,
                                                                              int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_shop_news, parent, false);

        ShopNewsListAdapter.RecommendShopListViewHolder vh = new ShopNewsListAdapter.RecommendShopListViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ShopNewsListAdapter.RecommendShopListViewHolder holder, int position) {

        //Product product = productList.get(position);

        //holder.setProduct(product);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return shopNewsList.size();
    }
}
