package com.daangnmarket.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.daangnmarket.Models.Shop;
import com.daangnmarket.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class RecommendKeywordListAdapter extends RecyclerView.Adapter<RecommendKeywordListAdapter.RecommendKeywordListViewHolder>{

    private List<String> keywordList;

    public static class RecommendKeywordListViewHolder extends RecyclerView.ViewHolder {

        public RecommendKeywordListViewHolder(View v) {
            super(v);
        }
    }

    public RecommendKeywordListAdapter(List<String> keywordList) {
        this.keywordList = keywordList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecommendKeywordListViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        // create a new view
        RelativeLayout v = (RelativeLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recommend_keyword, parent, false);

        RecommendKeywordListViewHolder vh = new RecommendKeywordListViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecommendKeywordListViewHolder holder, int position) {

        //Product product = productList.get(position);

        //holder.setProduct(product);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return keywordList.size();
    }
}
