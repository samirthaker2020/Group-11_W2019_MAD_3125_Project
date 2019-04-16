package com.example.group_11_mad3125_project.Modal.Product;

public class Product {

    private String pid;
    private String pname;
    private String price;
    private String pimage;
    private String description;

    public Product(String pid, String pname, String price, String pimage, String description) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.pimage = pimage;
        this.description = description;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", price='" + price + '\'' +
                ", pimage='" + pimage + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
