package com.example.group_11_mad3125_project.Controller.ShoppingCart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.group_11_mad3125_project.Adapter.CartAdapter;
import com.example.group_11_mad3125_project.Adapter.ProductAdapter;
import com.example.group_11_mad3125_project.Modal.MProduct.MProduct;
import com.example.group_11_mad3125_project.Modal.Order.OrderDetails;
import com.example.group_11_mad3125_project.R;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart extends AppCompatActivity {
    private List<OrderDetails> cartArrayList=new ArrayList<>();
    //private List<String> image;
    private RecyclerView lstcart;
    private ProductAdapter cAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        getSupportActionBar().setTitle("Your Cart");
lstcart=findViewById(R.id.rc_cart);
        mAdapter = new CartAdapter(cartArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        lstproduct.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
        lstproduct.setHasFixedSize(false);
        lstproduct.setLayoutManager(mLayoutManager);
        lstproduct.setItemAnimator(new DefaultItemAnimator());
        lstproduct.setAdapter(mAdapter);

        mAdapter.notifyDataSetChanged();
    }
}
