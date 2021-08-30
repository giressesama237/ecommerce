package com.orange.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.orange.myapplication.ui.dashboard.DashboardFragment;
import com.orange.myapplication.ui.home.HomeFragment;

import java.util.ArrayList;

public class RecyclerViewAdapterCart extends RecyclerView.Adapter<RecyclerViewAdapterCart.RecyclerViewHolder> {
    private ArrayList<RecyclerData> courseDataArrayList;
    private Fragment mcontext;

    public RecyclerViewAdapterCart(ArrayList<RecyclerData> recyclerDataArrayList, DashboardFragment mcontext) {
        this.courseDataArrayList = recyclerDataArrayList;
        this.mcontext = mcontext;
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new RecyclerViewAdapterCart.RecyclerViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
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
    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView courseTV;
        private TextView courseTV2;
        private ImageView courseIV;
        private RecyclerViewAdapterCart mAdaptaterCart;
        public RecyclerViewHolder(@NonNull View itemView, RecyclerViewAdapterCart adapterCart) {
            super(itemView);
            this.mAdaptaterCart = adapterCart;
            courseTV = itemView.findViewById(R.id.idTVCourse);
            courseTV2 = itemView.findViewById(R.id.idTVCourse2);
            courseIV = itemView.findViewById(R.id.idIVcourseIV);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int mPosition = getLayoutPosition();
            RecyclerData recyclerData = courseDataArrayList.get(mPosition);
            courseDataArrayList.remove(recyclerData);
            Toast.makeText(mcontext.getContext(), "Product delete",Toast.LENGTH_LONG).show();
            mAdaptaterCart.notifyDataSetChanged();

        }
    }
}
