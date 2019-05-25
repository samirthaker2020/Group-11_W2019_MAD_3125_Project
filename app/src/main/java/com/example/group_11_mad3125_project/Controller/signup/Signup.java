package com.example.group_11_mad3125_project.Controller.signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.group_11_mad3125_project.Controller.Login.Login;

import com.example.group_11_mad3125_project.Modal.Customer.Customer;
import com.example.group_11_mad3125_project.R;

import java.util.Random;



public class Signup extends AppCompatActivity {
    Customer cust=Customer.getInstance();

private Button btn_cancel;
private Button btn_register;
private TextView txtfname;
private TextView txtlname;
private TextView txtemailid;
private TextView txtpassword;
private TextView txtaddress;
private TextView txtshipinfo;
private TextView txtccinfo;
String fname;
String lname;
String address;
String emailid;
String password;
String shipinfo;
String ccinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide(); // hide the title bar
      //  getSupportActionBar().setTitle("Back to Login");
getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        btn_cancel=findViewById(R.id.btn_cancel);
btn_register=findViewById(R.id.btn_register);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(Signup.this,Login.class);
                startActivity(LoginIntent);
            }
        });

        txtaddress=findViewById(R.id.txtaddress);
        txtemailid=findViewById(R.id.txtuid);
        txtpassword=findViewById(R.id.txtpass);
        txtccinfo=findViewById(R.id.txtccinfo);
        txtshipinfo=findViewById(R.id.txtshipinfo);
        txtfname=findViewById(R.id.txtfname);
        txtlname=findViewById(R.id.txtlname);
        fname=txtfname.getText().toString();
        lname=txtlname.getText().toString();
        address=txtaddress.getText().toString();
        ccinfo= txtccinfo.getText().toString();
        shipinfo=txtshipinfo.getText().toString();
        password=txtpassword.getText().toString();
        emailid=txtemailid.getText().toString();

btn_register.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Random rand = new Random();
        int x = rand.nextInt(10);
        Toast.makeText(Signup.this,"Registered Succesfully",Toast.LENGTH_LONG).show();
        Customer c3=new Customer(x,txtfname.getText().toString(),txtlname.getText().toString(),txtpassword.getText().toString(),txtaddress.getText().toString(),txtemailid.getText().toString(),txtshipinfo.getText().toString(),txtccinfo.getText().toString());
      //  Customer c4=new Customer();
        cust.register(c3);
        Intent LoginIntent = new Intent(Signup.this,Login.class);
        startActivity(LoginIntent);

    }
});

    }



    }




