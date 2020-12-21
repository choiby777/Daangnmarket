package com.daangnmarket.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.daangnmarket.Models.Product;
import com.daangnmarket.Models.Shop;
import com.daangnmarket.R;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

public class RecommendShopListAdapter extends RecyclerView.Adapter<RecommendShopListAdapter.RecommendShopListViewHolder>{

    private List<Shop> shopList;

    public static class RecommendShopListViewHolder extends RecyclerView.ViewHolder {

        public RecommendShopListViewHolder(View v) {
            super(v);
        }
    }

    public RecommendShopListAdapter( List<Shop> shopList) {
        this.shopList = shopList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecommendShopListAdapter.RecommendShopListViewHolder onCreateViewHolder(ViewGroup parent,
                                                                       int viewType) {
        // create a new view
        RelativeLayout v = (RelativeLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recommend_shop, parent, false);

        RecommendShopListAdapter.RecommendShopListViewHolder vh = new RecommendShopListAdapter.RecommendShopListViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecommendShopListAdapter.RecommendShopListViewHolder holder, int position) {

        //Product product = productList.get(position);

        //holder.setProduct(product);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return shopList.size();
    }
}
