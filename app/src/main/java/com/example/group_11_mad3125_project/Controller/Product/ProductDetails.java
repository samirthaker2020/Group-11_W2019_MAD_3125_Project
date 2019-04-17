package com.example.group_11_mad3125_project.Controller.Product;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.group_11_mad3125_project.Controller.Main_menu.Main_menu;
import com.example.group_11_mad3125_project.Controller.ShoppingCart.ShoppingCart;
import com.example.group_11_mad3125_project.MinMaxFilter;
import com.example.group_11_mad3125_project.Modal.MProduct.MProduct;
import com.example.group_11_mad3125_project.Modal.Order.OrderDetails;
import com.example.group_11_mad3125_project.R;

public class ProductDetails extends AppCompatActivity {
   OrderDetails tmp = OrderDetails.getInstance( );
private TextView pid,pname,price,desc,qty;
private ImageView pd_img1;
private Button btnadd;
private BottomNavigationView b;
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        b=findViewById(R.id.bottomproduct);
        b.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                boolean ch=false;
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        Intent intent = new Intent(ProductDetails.this, Main_menu.class);
                        startActivity(intent);
                        return true;
                    case R.id.cart:
                        Intent intentCart = new Intent(ProductDetails.this, ShoppingCart.class);
                        startActivity(intentCart);
                        return true;
                }
                return  false;
            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    double tot = Double.parseDouble(probj.getPrice()) * Double.parseDouble(qty.getText().toString());

                    OrderDetails addorder = new OrderDetails(probj.getPid(), probj.getPname(), Double.parseDouble(probj.getPrice()), tot, Double.parseDouble(qty.getText().toString()), probj.getPimage());
                    or.addtocart(addorder);
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ProductDetails.this);

                    alertDialogBuilder.setTitle("Added To Cart");
                    alertDialogBuilder

                            .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();




            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                // ProjectsActivity is my 'home' activity
                startActivityAfterCleanup(Main_menu.class);
                return true;
        }
        return (super.onOptionsItemSelected(menuItem));
    }

    private void startActivityAfterCleanup(Class<?> cls) {

        Intent intent = new Intent(getApplicationContext(), cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
