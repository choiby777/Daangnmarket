package com.daangnmarket.Main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daangnmarket.Adapters.RecommendShopListAdapter;
import com.daangnmarket.Adapters.ShopNewsListAdapter;
import com.daangnmarket.Models.Shop;
import com.daangnmarket.Models.ShowNews;
import com.daangnmarket.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ArroundFragment extends Fragment {

    private static final String TAG = "ArroundFragment";

    private RecyclerView rcv_shop_news;
    private List<ShowNews> shopNewsList;

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
        rcv_shop_news = view.findViewById(R.id.rv_shop_news);

        createRecommendShopListView();
        createShopNewsListView();

        return view;
    }

    private void createShopNewsListView() {

        shopNewsList = new ArrayList<>();

        for (int i=0; i<4; i++)
        {
            ShowNews news = new ShowNews();

            shopNewsList.add(news);
        }

        ShopNewsListAdapter adapter = new ShopNewsListAdapter(shopNewsList);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext() , 2);

        rcv_shop_news.setHasFixedSize(true);
        rcv_shop_news.setLayoutManager(layoutManager);
        rcv_shop_news.setAdapter(adapter);
    }

    private void createRecommendShopListView() {

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
    }
}
