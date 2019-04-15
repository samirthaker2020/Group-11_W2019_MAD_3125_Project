package com.example.group_11_mad3125_project.Controller.Login;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.group_11_mad3125_project.Controller.signup.Signup;
import com.example.group_11_mad3125_project.Modal.User.Customer;
import com.example.group_11_mad3125_project.R;

public class Login extends AppCompatActivity {
    Customer cust=Customer.getInstance();
   Customer cs=new Customer();
private Button btn_signup;
private Button btn_signin;
String email,pass;
private TextView txtpassword,txtemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        btn_signup=findViewById(R.id.btn_signup);
        btn_signin=findViewById(R.id.btn_login);
        txtemail=findViewById(R.id.txtuid1);
        txtpassword=findViewById(R.id.txtpass1);
Customer c1=new Customer(1,"samir","thaker","123","toronto","s@gmail.com","scarborough",123456789);
        Customer c2=new Customer(2,"mandeep","kaur","1234","toronto","s@gmail.com","scarborough",123456789);

 cust.register(c1,"s@gmail.com");cust.register(c2,"s@gmail.com");


        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(Login.this, Signup.class);
                startActivity(LoginIntent);
            }
        });


btn_signin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Boolean ch=false;
        email=txtemail.getText().toString();
        pass=txtpassword.getText().toString();

        ch=cust.checklogin(email,pass);
        if(ch==true)
        {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    Login.this);

            // set title
            alertDialogBuilder.setTitle("Login ok");
            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        }
        else
        {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    Login.this);

            // set title
            alertDialogBuilder.setTitle("Login fail");
            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        }
    }
});
    }

    @Override
    public void onBackPressed() {
        finish();
        System.exit(0);
    }


}
