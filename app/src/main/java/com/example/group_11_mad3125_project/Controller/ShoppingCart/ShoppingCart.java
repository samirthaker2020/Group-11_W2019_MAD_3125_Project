package com.example.group_11_mad3125_project.Controller.ShoppingCart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.group_11_mad3125_project.Adapter.CartAdapter;
import com.example.group_11_mad3125_project.Adapter.ProductAdapter;
import com.example.group_11_mad3125_project.Modal.MProduct.MProduct;
import com.example.group_11_mad3125_project.Modal.Order.OrderDetails;
import com.example.group_11_mad3125_project.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.group_11_mad3125_project.Controller.Product.ProductDetails.or;

public class ShoppingCart extends AppCompatActivity {
    private List<OrderDetails> cartArrayList=new ArrayList<>();
    private List<String> cdetails;
    private RecyclerView lstcart;
    private CartAdapter cAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        getSupportActionBar().setTitle("Your Cart");
       OrderDetails tmp =OrderDetails.getInstance( );
       OrderDetails o=new OrderDetails();
lstcart=findViewById(R.id.rc_cart);

for(OrderDetails o1:o.getCartdetails())
{
    Log.d("checkd",o1.getProductname());
}
        cAdapter = new CartAdapter(or.getCartdetails());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        lstcart.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
        lstcart.setHasFixedSize(false);
        lstcart.setLayoutManager(mLayoutManager);
        lstcart.setItemAnimator(new DefaultItemAnimator());
        lstcart.setAdapter(cAdapter);

        cAdapter.notifyDataSetChanged();
    }
}
