package com.example.gridview;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeScreenMenuAdapter extends RecyclerView.Adapter<HomeScreenMenuAdapter.MyviewHolder> {
    Context context;
    public HomeScreenMenuAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_ui_design, viewGroup, false);
        MyviewHolder myviewHolder = new MyviewHolder(view);
        return myviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder myviewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
