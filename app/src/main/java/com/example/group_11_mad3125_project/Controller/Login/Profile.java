package com.example.group_11_mad3125_project.Controller.Login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.group_11_mad3125_project.Modal.Customer.Customer;
import com.example.group_11_mad3125_project.R;

public class Profile extends AppCompatActivity {

    private TextView fname,lname;
    Customer cust=Customer.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        fname=findViewById(R.id.pfname);
        fname.setText(cust.getFname());
    }
}
