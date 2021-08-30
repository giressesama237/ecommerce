package com.orange.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    private String productName;
    private String productPrice;
     private  String productDescription;
    public Product(){

    }
    public Product(String productName,String productPrice,String productDescription){
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
    }

    protected Product(Parcel in) {
        productName = in.readString();
        productPrice = in.readString();
        productDescription = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(productName);
        parcel.writeString(productPrice);
        parcel.writeString(productDescription);
    }
}
