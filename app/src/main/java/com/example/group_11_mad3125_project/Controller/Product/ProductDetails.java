package com.example.group_11_mad3125_project.Controller.Product;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.group_11_mad3125_project.MinMaxFilter;
import com.example.group_11_mad3125_project.Modal.MProduct.MProduct;
import com.example.group_11_mad3125_project.Modal.Order.OrderDetails;
import com.example.group_11_mad3125_project.R;

public class ProductDetails extends AppCompatActivity {
   OrderDetails tmp = OrderDetails.getInstance( );
private TextView pid,pname,price,desc,qty;
private ImageView pd_img1;
private Button btnadd;
public static OrderDetails or=new OrderDetails();
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
        btnadd=findViewById(R.id.pd_btnadd);
        qty.setFilters(new InputFilter[]{ new MinMaxFilter("1", "5")});
        Intent i=getIntent();
        final MProduct probj = (MProduct) i.getExtras().getSerializable("pdetails");
        pid.setText("Product ID::"+probj.getPid());
        pname.setText("Product Name::"+probj.getPname());
        price.setText("Price:$:"+probj.getPrice());
        desc.setText("Description:"+probj.getDescription());
        int imageId = this.getResources().getIdentifier(probj.getPimage(),"drawable", this.getPackageName());
        this.pd_img1.setImageResource(imageId);


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double tot=Double.parseDouble(probj.getPrice()) * Double.parseDouble( qty.getText().toString());

                OrderDetails addorder=new OrderDetails(probj.getPid(),probj.getPname(),Double.parseDouble(probj.getPrice()),tot,Double.parseDouble(qty.getText().toString()),probj.getPimage());
                or.addtocart(addorder);
            }
        });
    }
}
