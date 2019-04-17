package com.example.group_11_mad3125_project.Controller.Product;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.group_11_mad3125_project.MinMaxFilter;
import com.example.group_11_mad3125_project.Modal.MProduct.MProduct;
import com.example.group_11_mad3125_project.R;

public class ProductDetails extends AppCompatActivity {
private TextView pid,pname,price,desc,qty;
private ImageView pd_img1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setTitle("Product Details");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        pid=findViewById(R.id.pd_pid);
        pname=findViewById(R.id.pd_pname);
        price=findViewById(R.id.pd_price);
        desc=findViewById(R.id.pd_desc);
        qty=findViewById(R.id.txtqty);
        pd_img1=findViewById(R.id.pd_img1);
        qty.setFilters(new InputFilter[]{ new MinMaxFilter("1", "5")});
        Intent i=getIntent();
        MProduct probj = (MProduct) i.getExtras().getSerializable("pdetails");
        pid.setText("Product ID::"+probj.getPid());
        pname.setText("Product Name::"+probj.getPname());
        price.setText("Price:$:"+probj.getPrice());
        desc.setText("Description:"+probj.getDescription());
        int imageId = this.getResources().getIdentifier(probj.getPimage(),"drawable", this.getPackageName());
        this.pd_img1.setImageResource(imageId);
    }
}
