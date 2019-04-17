package com.example.group_11_mad3125_project.Modal.Order;

import android.util.Log;

import com.example.group_11_mad3125_project.Modal.Customer.Customer;

import java.util.ArrayList;
import java.util.List;

public class OrderDetails {
    private static  OrderDetails or=new OrderDetails();
    private String productid;
    private String productname;
    private double unitprice;
    private double Subtotal;
    private double quantity;
    private String productimage;
    private List<OrderDetails> cartdetails = new ArrayList<>();

    public OrderDetails(List<OrderDetails> cartdetails) {
        this.cartdetails = cartdetails;
    }
    public static OrderDetails getInstance( ) {
        return or;
    }
    public OrderDetails()
    {
        this.productid="";
        this.productimage="";
        this.productname="";
        this.quantity=0.0;
        this.unitprice=0.0;
        this.Subtotal=0.0;
       // this.cartdetails = new ArrayList<>();
    }

    public OrderDetails(String productid, String productname, double unitprice, double subtotal, double quantity, String productimage) {
        this.productid = productid;
        this.productname = productname;
        this.unitprice = unitprice;
        Subtotal = subtotal;
        this.quantity = quantity;
        this.productimage = productimage;
    }

    public List<OrderDetails> getCartdetails() {
        return cartdetails;
    }

    public void setCartdetails(List<OrderDetails> cartdetails) {
        this.cartdetails = cartdetails;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }

    public double getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(double subtotal) {
        Subtotal = subtotal;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getProductimage() {
        return productimage;
    }

    public void setProductimage(String productimage) {
        this.productimage = productimage;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "productid='" + productid + '\'' +
                ", productname='" + productname + '\'' +
                ", unitprice=" + unitprice +
                ", Subtotal=" + Subtotal +
                ", quantity=" + quantity +
                ", productimage='" + productimage + '\'' +
                ", cartdetails=" + cartdetails +
                '}';
    }


    public void addtocart(OrderDetails or)
    {
        this.cartdetails.add(or);

        for(OrderDetails o:this.cartdetails)
        {
            Log.d("det",o.productname);
            Log.d("det",String.valueOf(o.getSubtotal()));
        }
    }
}
