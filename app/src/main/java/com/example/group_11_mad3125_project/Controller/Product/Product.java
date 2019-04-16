package com.example.group_11_mad3125_project.Controller.Product;

import android.content.Intent;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenu;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.group_11_mad3125_project.Adapter.ProductAdapter;
import com.example.group_11_mad3125_project.Controller.Login.Login;
import com.example.group_11_mad3125_project.Controller.Main_menu.Main_menu;
import com.example.group_11_mad3125_project.Controller.signup.Signup;
import com.example.group_11_mad3125_project.Modal.MProduct.MProduct;
import com.example.group_11_mad3125_project.R;

import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.List;

public class Product extends AppCompatActivity {
 private Button bhome;
    private List<MProduct> productArrayList;
    private List<String> image;
    private RecyclerView lstproduct;
    private ProductAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
      bhome=findViewById(R.id.phome);
      getdata();
      bhome.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent LoginIntent = new Intent(Product.this, Main_menu.class);
              startActivity(LoginIntent);
          }
      });

        lstproduct=findViewById(R.id.rcproduct);
        image = new ArrayList<>();
        for (MProduct str : productArrayList) {
            image.add(str.getPname());
            image.add(str.getPimage());
        }
        mAdapter = new ProductAdapter(productArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        lstproduct.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
        lstproduct.setHasFixedSize(false);
       lstproduct.setLayoutManager(mLayoutManager);
        lstproduct.setItemAnimator(new DefaultItemAnimator());
        lstproduct.setAdapter(mAdapter);

        mAdapter.notifyDataSetChanged();
    }


    public void getdata()
    {
        productArrayList = new ArrayList<>();
            productArrayList.add(new MProduct("1","HardDisk","50","1.jpg","HDD-1TB-5400RPM"));
        productArrayList.add(new MProduct("2","PenDrive","10","2.jpg","ScanDisk 4GB USB3.0"));
    }
}
