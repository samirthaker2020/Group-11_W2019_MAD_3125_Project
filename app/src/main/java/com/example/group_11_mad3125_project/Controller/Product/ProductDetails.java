package com.example.group_11_mad3125_project.Controller.Product;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.group_11_mad3125_project.Modal.MProduct.MProduct;
import com.example.group_11_mad3125_project.R;

public class ProductDetails extends AppCompatActivity {
private TextView pid,pname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        pid=findViewById(R.id.pd_pid);
        pname=findViewById(R.id.pd_pname);
        Intent i=getIntent();
        MProduct proobj = (MProduct) i.getExtras().getSerializable("pdetails");
        pid.setText("Product ID::"+proobj.getPid());
        pname.setText("Product Name::"+proobj.getPname());
    }
}
