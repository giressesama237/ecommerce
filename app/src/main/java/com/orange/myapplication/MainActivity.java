package com.orange.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.orange.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.SplittableRandom;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE ="product" ;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);


    }

    public void openDetailsProduct(View view) {

        TextView mTextViewName = findViewById(R.id.idTVCourse);
        TextView mTextViewPrice = findViewById(R.id.idTVCourse2);
        ImageView imageView = findViewById(view.getId());
        String mImageDescription = imageView.getContentDescription().toString();
        String mProductName = mTextViewName.getText().toString();
        String mProductPrice = mTextViewPrice.getText().toString();
        Product product = new Product(mProductName,mProductPrice,mImageDescription);
        //Toast.makeText(this,product.getProductDescription(),Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,DetailsProduct.class);
        intent.putExtra(EXTRA_MESSAGE,product);
        startActivity(intent);
    }

    public void addProductCart(View view) {
        Toast.makeText(this,"Added to cart", Toast.LENGTH_LONG).show();
    }

    public void checkout(View view) {
        Intent intent = new Intent(this,Checkout.class);
        startActivity(intent);
    }
}