package com.daangnmarket.Adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daangnmarket.Models.Product;
import com.daangnmarket.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder> {

    private List<Product> productList;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ProductListViewHolder extends RecyclerView.ViewHolder {

        private TextView txt_title;
        private TextView txt_location;
        private TextView txt_price;
        private TextView txt_timeInfo;
        private SimpleDraweeView img_productImage;
        private Product product;

        public ProductListViewHolder(View v) {
            super(v);

            txt_title = v.findViewById(R.id.txt_title);
            txt_location = v.findViewById(R.id.txt_location);
            txt_price = v.findViewById(R.id.txt_price);
            txt_timeInfo = v.findViewById(R.id.txt_time_info);
            img_productImage = (SimpleDraweeView)v.findViewById(R.id.img_thumbnail);
        }

        public void setProduct(Product product){
            this.product = product;

            txt_title.setText(product.getTitle());
            txt_location.setText(product.getLocation());
            txt_price.setText(product.getPriceString());
            txt_timeInfo.setText(product.getRegisterTimeString());
            img_productImage.setImageURI(product.getImageUrl());
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ProductListAdapter(Context context , List<Product> productList) {
        this.productList = productList;

    }

    // Create new views (invoked by the layout manager)
    @Override
    public ProductListAdapter.ProductListViewHolder onCreateViewHolder(ViewGroup parent,
                                                                       int viewType) {
        // create a new view
        RelativeLayout v = (RelativeLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);

        ProductListViewHolder vh = new ProductListViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ProductListViewHolder holder, int position) {

        Product product = productList.get(position);

        holder.setProduct(product);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return productList.size();
    }
}