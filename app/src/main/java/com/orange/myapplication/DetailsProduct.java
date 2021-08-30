package com.orange.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_product);
        Product product = new Product();
        Intent intent = getIntent();
        product =  intent.getParcelableExtra(MainActivity.EXTRA_MESSAGE);
        TextView mTextViewName = findViewById(R.id.textViewName);
        TextView mDescriptionTextView = findViewById(R.id.description_textview);
        TextView mPrixTextView = findViewById(R.id.price_texview);
        mTextViewName.setText(product.getProductName());
        mDescriptionTextView.setText(product.getProductDescription());
        mPrixTextView.setText(product.getProductPrice());
    }

    public void addProductCart(View view) {
        Toast.makeText(this,"Added to cart", Toast.LENGTH_LONG).show();
    }
}