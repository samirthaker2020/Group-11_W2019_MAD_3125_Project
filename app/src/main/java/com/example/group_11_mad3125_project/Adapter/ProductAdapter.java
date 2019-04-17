package com.example.group_11_mad3125_project.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.group_11_mad3125_project.Controller.Product.ProductDetails;
import com.squareup.picasso.Picasso;

import com.squareup.picasso.Picasso;
import com.example.group_11_mad3125_project.Modal.MProduct.MProduct;
import com.example.group_11_mad3125_project.R;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.Myviewholder> {
    private List<MProduct> productList;
    private Context mcontext;

    public ProductAdapter(List<MProduct> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductAdapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_product, viewGroup, false);
        mcontext = viewGroup.getContext();
        return new Myviewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder myviewholder, int i) {
        final MProduct pro = productList.get(i);


            myviewholder.txtname.setText(pro.getPname());

            int imageId = mcontext.getResources().getIdentifier(pro.getPimage(),"drawable", mcontext.getPackageName());
            myviewholder.img1.setImageResource(imageId);
        //myviewholder.img1.setImageResource(R.drawable.hdd);
           // Picasso.with(mcontext).load("https://lh3.googleusercontent.com/0-BzaWtxoAnsBjQ_wzUcKxyF07XE7v2Kkg1ogPVUdzmQpvaz118uHQEGU6BdtzJuzfo=h1264").into(myviewholder.img1);
           // Picasso.get().load("https://lh3.googleusercontent.com/0-BzaWtxoAnsBjQ_wzUcKxyF07XE7v2Kkg1ogPVUdzmQpvaz118uHQEGU6BdtzJuzfo=h1264").into(myviewholder.img1);
          //  myviewholder.img1.setBackgroundColor(Color.rgb(255,255,255));


        myviewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(mcontext, ProductDetails.class);
                i.putExtra("pdetails",pro);
                mcontext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
    public class Myviewholder extends RecyclerView.ViewHolder
    {
        public ImageView img1;
        private TextView txtname;

        public Myviewholder(  View itemView) {
            super(itemView);
            img1=(ImageView) itemView.findViewById(R.id.productimage);
            txtname=(TextView) itemView.findViewById(R.id.productname);
           // Picasso.get().load(products.getImage()).into(productImage);


        }
    }
}
