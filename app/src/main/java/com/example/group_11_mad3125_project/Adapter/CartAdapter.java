package com.example.group_11_mad3125_project.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.group_11_mad3125_project.Controller.ShoppingCart.ShoppingCart;
import com.example.group_11_mad3125_project.Controller.signup.Signup;
import com.example.group_11_mad3125_project.Modal.MProduct.MProduct;
import com.example.group_11_mad3125_project.Modal.Order.OrderDetails;
import com.example.group_11_mad3125_project.R;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.Myviewholder> {

    public static ShoppingCart cart=new ShoppingCart();
    private List<OrderDetails> cartList;
    private Context mcontext;

    public CartAdapter(List<OrderDetails> cartList) {
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public CartAdapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_cart, viewGroup, false);
        mcontext = viewGroup.getContext();
        return new CartAdapter.Myviewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.Myviewholder myviewholder, int i) {
        final OrderDetails cart = cartList.get(i);
        myviewholder.txtname.setText("ProductName::"+cart.getProductname());
        myviewholder.txtid.setText("ProductID::"+cart.getProductid());
        myviewholder.txtsubtotal.setText("SubTotal::$:"+String.valueOf(cart.getSubtotal()));
        myviewholder.txtqty.setText("Quantity::"+String.valueOf(cart.getQuantity()));

        int imageId = mcontext.getResources().getIdentifier(cart.getProductimage(),"drawable", mcontext.getPackageName());
        myviewholder.img1.setImageResource(imageId);

    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }


    public class Myviewholder extends RecyclerView.ViewHolder
    {
        private ImageView img1;
        private TextView txtname,txtqty,txtsubtotal,txtid;
        private Button btn_checkout;


        public Myviewholder(  View itemView) {
            super(itemView);
            img1=(ImageView) itemView.findViewById(R.id.cimage);
            txtname=(TextView) itemView.findViewById(R.id.cname);
            txtid=(TextView) itemView.findViewById(R.id.cid);
            txtqty=(TextView) itemView.findViewById(R.id.cqty);
            txtsubtotal=(TextView) itemView.findViewById(R.id.csubtotal);
           // btn_checkout=(Button) itemView.findViewById(R.id.btn_checkout);



        }
    }
}
