package com.orange.myapplication;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.orange.myapplication.ui.dashboard.DashboardFragment;
import com.orange.myapplication.ui.home.HomeFragment;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    private ArrayList<RecyclerData> courseDataArrayList;
    private Fragment mcontext;
    public RecyclerViewAdapter(ArrayList<RecyclerData> recyclerDataArrayList, HomeFragment mcontext) {
        this.courseDataArrayList = recyclerDataArrayList;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new RecyclerViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.RecyclerViewHolder holder, int position) {
        // Set the data to textview and imageview.
        RecyclerData recyclerData = courseDataArrayList.get(position);
        holder.courseTV.setText(recyclerData.getTitle());
        holder.courseTV2.setText(recyclerData.getPrix());
        holder.courseIV.setImageResource(recyclerData.getImgid());
    }

    @Override
    public int getItemCount() {
        return courseDataArrayList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView courseTV;
        private TextView courseTV2;
        private ImageView courseIV;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            courseTV = itemView.findViewById(R.id.idTVCourse);
            courseTV2 = itemView.findViewById(R.id.idTVCourse2);
            courseIV = itemView.findViewById(R.id.idIVcourseIV);
        }
    }
}

