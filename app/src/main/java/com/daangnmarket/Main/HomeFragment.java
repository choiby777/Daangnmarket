package com.daangnmarket.Main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daangnmarket.Adapters.ProductListAdapter;
import com.daangnmarket.Models.Product;
import com.daangnmarket.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";

    private RecyclerView rcv_product_list;
    private List<Product> productList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_home, container, false);

        rcv_product_list = view.findViewById(R.id.rcv_product_list);

        productList = new ArrayList<>();

        for (int i=0; i<20; i++)
        {
            Product product = new Product();
            product.setTitle("사용하지 않는 물품 판매합니다.");
            product.setLocation("영통2동");
            product.setPrice(18000);
            product.setImageUrl("https://raw.githubusercontent.com/facebook/fresco/master/docs/static/logo.png");
            product.setRegisterTime(new Date());

            productList.add(product);
        }

        ProductListAdapter adapter = new ProductListAdapter(getContext() , productList);

        rcv_product_list.setHasFixedSize(true);
        rcv_product_list.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.VERTICAL , false));
        rcv_product_list.setAdapter(adapter);

        return view;
    }
}
