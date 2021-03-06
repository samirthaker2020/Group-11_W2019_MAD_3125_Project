package com.example.group_11_mad3125_project.Controller.Main_menu;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.TextureView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.group_11_mad3125_project.Controller.Login.Login;
import com.example.group_11_mad3125_project.Controller.Login.Profile;
import com.example.group_11_mad3125_project.Controller.NeedHelp.NeedHelp;
import com.example.group_11_mad3125_project.Controller.Product.Product;
import com.example.group_11_mad3125_project.Controller.Product.ProductDetails;
import com.example.group_11_mad3125_project.Controller.ShoppingCart.ShoppingCart;
import com.example.group_11_mad3125_project.Controller.signup.Signup;
import com.example.group_11_mad3125_project.R;
import com.example.group_11_mad3125_project.Splash_screen;

public class Main_menu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TextView userlogin1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        View mHeaderView =  navigationView.getHeaderView(0);

        // View
        userlogin1= (TextView) mHeaderView.findViewById(R.id.userlogin);
        Bundle mbundle = getIntent().getExtras();
        if (mbundle != null) {
            if (mbundle.containsKey("email")) {
                String name = mbundle.getString("email");
                userlogin1.setText(name);
            }
        }



        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case R.id.home:

            Intent LoginIntent = new Intent(Main_menu.this, Main_menu.class);
            startActivity(LoginIntent);
            case R.id.nav_viewcart:

                Intent  d = new Intent(Main_menu.this, ShoppingCart.class);
                startActivity(d);
        }

        //noinspection SimplifiableIfStatement



        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_viewprofile) {
            // Handle the camera action
            Intent LoginIntent = new Intent(Main_menu.this, Profile.class);
            startActivity(LoginIntent);
        } else if (id == R.id.nav_viewproducts) {
            Intent LoginIntent = new Intent(Main_menu.this, Product.class);
            startActivity(LoginIntent);

        } else if (id == R.id.nav_viewcart) {
            Intent LoginIntent = new Intent(Main_menu.this, ShoppingCart.class);
            startActivity(LoginIntent);
        } else if (id == R.id.nav_vieworders) {

        } else if (id == R.id.nav_needhelp) {
            Intent LoginIntent = new Intent(Main_menu.this, NeedHelp.class);
            startActivity(LoginIntent);
        } else if (id == R.id.nav_contactus) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Main_menu.this);

            alertDialogBuilder.setTitle("Mandeep@gmail.com");
            alertDialogBuilder

                    .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
        else if (id == R.id.nav_logout) {
            Intent LoginIntent = new Intent(Main_menu.this, Splash_screen.class);
            startActivity(LoginIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
