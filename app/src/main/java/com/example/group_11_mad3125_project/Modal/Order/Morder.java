package com.example.group_11_mad3125_project.Modal.Order;

import android.util.Log;

import java.util.HashMap;
import java.util.List;

public class Morder {

    private int orderid;
    private HashMap<Integer, List<OrderDetails>> custorder;

    public Morder(int orderid, HashMap<Integer, List<OrderDetails>> custorder) {
        this.orderid = orderid;
        this.custorder = custorder;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public HashMap<Integer, List<OrderDetails>> getCustorder() {
        return custorder;
    }

    public void setCustorder(HashMap<Integer, List<OrderDetails>> custorder) {
        this.custorder = custorder;
    }

    @Override
    public String toString() {
        return "Morder{" +
                "orderid=" + orderid +
                ", custorder=" + custorder +
                '}';
    }

    public void checkout(List<OrderDetails> odetails) {

    }
}
