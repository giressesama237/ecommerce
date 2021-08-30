package com.orange.myapplication.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.orange.myapplication.R;
import com.orange.myapplication.RecyclerData;
import com.orange.myapplication.RecyclerViewAdapter;
import com.orange.myapplication.RecyclerViewAdapterCart;
import com.orange.myapplication.databinding.FragmentDashboardBinding;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;
    private ArrayList<RecyclerData> recyclerDataArrayList;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textDashboard;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                //textView.setText(s);
            }
        });
        final RecyclerView recyclerView=binding.idCartRV;
        // created new array list..
        recyclerDataArrayList=new ArrayList<>();

        // added data to array list
        recyclerDataArrayList.add(new RecyclerData("BeefSteak", "1 000 FCFA",R.drawable.chips));
        recyclerDataArrayList.add(new RecyclerData("Pommes de terre","800 FCFA",R.drawable.potato));
        recyclerDataArrayList.add(new RecyclerData("Légumes","500 FCFA",R.drawable.legumes));
        recyclerDataArrayList.add(new RecyclerData("Keebab","200 FCFA",R.drawable.potato_fruit));
        // added data from arraylist to adapter class.
        RecyclerViewAdapterCart adapter=new RecyclerViewAdapterCart(recyclerDataArrayList,this);

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),1);

        // at last set adapter to recycler view.
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}