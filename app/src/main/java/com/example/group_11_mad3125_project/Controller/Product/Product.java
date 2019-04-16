package com.example.group_11_mad3125_project.Controller.Product;

import android.content.Intent;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenu;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.group_11_mad3125_project.Controller.Login.Login;
import com.example.group_11_mad3125_project.Controller.Main_menu.Main_menu;
import com.example.group_11_mad3125_project.Controller.signup.Signup;
import com.example.group_11_mad3125_project.R;

import java.sql.BatchUpdateException;

public class Product extends AppCompatActivity {
 private Button bhome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
      bhome=findViewById(R.id.phome);
      bhome.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent LoginIntent = new Intent(Product.this, Main_menu.class);
              startActivity(LoginIntent);
          }
      });



    }
}
