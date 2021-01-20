package com.daangnmarket.Main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daangnmarket.Adapters.ProductListAdapter;
import com.daangnmarket.Models.Article;
import com.daangnmarket.Models.News;
import com.daangnmarket.Models.Product;
import com.daangnmarket.R;
import com.daangnmarket.Service.NewsApiService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";

    private RecyclerView rcv_product_list;
    private List<Product> productList;
    private ProductListAdapter adapter;
    private static final String APIKEY = "8a973bcb078b4731ae1e7543d1acdd88";
    private int currentPangeIndex;
    private Retrofit retrofit;
    private NewsApiService newsApi;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_home, container, false);

        setViewWidgets(view);

        productList = new ArrayList<>();

        adapter = new ProductListAdapter(getContext() , productList);

        rcv_product_list.setHasFixedSize(true);
        rcv_product_list.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.VERTICAL , false));
        rcv_product_list.setAdapter(adapter);
        rcv_product_list.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                LinearLayoutManager layoutManager = LinearLayoutManager.class.cast(recyclerView.getLayoutManager());
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int pastVisibleItems = layoutManager.findFirstCompletelyVisibleItemPosition();

                if(pastVisibleItems+visibleItemCount >= totalItemCount - 3){
                    Log.i(TAG, "onScrollStateChanged: More!!!1");

                    loadNextNewsListFromApi(++currentPangeIndex);
                }

                if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    Log.i(TAG, "onScrollStateChanged: End !!");
                }
            }
        });

        createNewsApiService();

        loadNewsList();

//        for (int i=0; i<20; i++)
//        {
//            Product product = new Product();
//            product.setTitle("사용하지 않는 물품 판매합니다.");
//            product.setLocation("영통2동");
//            product.setPrice(18000);
//            //product.setImageUrl("https://raw.githubusercontent.com/facebook/fresco/master/docs/static/logo.png");
//            product.setImageUrl("http://m.sinsadog.com/web/product/big/201901/babc1d9eb0a0f194fa43d022a87aeaa0.jpg");
//            product.setRegisterTime(new Date());
//
//            productList.add(product);
//        }
//
//        adapter.setProductList(productList);
//        adapter.notifyDataSetChanged();

        return view;
    }

    private void createNewsApiService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(NewsApiService.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        newsApi = retrofit.create(NewsApiService.class);
    }

    private void setViewWidgets(View view) {
        rcv_product_list = view.findViewById(R.id.rcv_product_list);
    }

    private void loadNextNewsListFromApi(int pageIndex){
        Call<News> newsList = newsApi.everything(APIKEY, "bitcoin", pageIndex);
        String url = newsList.request().url().toString();

        int lastPosition = productList.size() - 1;

        newsList.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {

                News news = response.body();

                if (news == null) return;

                Article[] articles = news.getArticles();

                for (Article article : articles) {
                    Product product = new Product();
                    product.setTitle(article.getTitle());
                    product.setLocation("영통2동");
                    product.setPrice(18000);
                    product.setImageUrl(article.getUrlToImage());
                    product.setRegisterTime(new Date());

                    productList.add(product);
                }

                adapter.setProductList(productList);
                adapter.notifyItemRangeInserted(lastPosition + 1 ,  articles.length);
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }

    private void loadNewsList() {
        Call<News> newsList = newsApi.everything(APIKEY, "bitcoin");
        String url = newsList.request().url().toString();

        productList.clear();

        newsList.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {

                News news = response.body();

                if (news == null) return;

                Article[] articles = news.getArticles();

                for (Article article : articles) {
                    Product product = new Product();
                    product.setTitle(article.getTitle());
                    product.setLocation("영통2동");
                    product.setPrice(18000);
                    product.setImageUrl(article.getUrlToImage());
                    product.setRegisterTime(new Date());

                    productList.add(product);
                }

                adapter.setProductList(productList);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }
}
