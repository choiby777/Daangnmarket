package com.daangnmarket.Main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daangnmarket.Adapters.ProductListAdapter;
import com.daangnmarket.Adapters.RecommendShopListAdapter;
import com.daangnmarket.Models.Product;
import com.daangnmarket.Models.Shop;
import com.daangnmarket.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ArroundFragment extends Fragment {

    private static final String TAG = "ArroundFragment";

    private RecyclerView rcv_recommend_shops;
    private List<Shop> shopList;

    public ArroundFragment() {
        Log.d(TAG, "ArroundFragment: created");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_around, container, false);

        rcv_recommend_shops = view.findViewById(R.id.rcv_recommend_shops);

        shopList = new ArrayList<>();

        for (int i=0; i<10; i++)
        {
            Shop shop = new Shop();
            shop.setName("가나다라");

            shopList.add(shop);
        }

        RecommendShopListAdapter adapter = new RecommendShopListAdapter(shopList);

        rcv_recommend_shops.setHasFixedSize(true);
        rcv_recommend_shops.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL, false));
        rcv_recommend_shops.setAdapter(adapter);

        return view;
    }
}
