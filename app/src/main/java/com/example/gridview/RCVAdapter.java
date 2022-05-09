package com.example.gridview;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RCVAdapter extends RecyclerView.Adapter<RCVAdapter.MyViewHolder>{

    private final Context context;
    private final ArrayList<Integer> images;
    private final ArrayList<String> foodNames;

    public RCVAdapter(Context context, ArrayList<Integer> images, ArrayList<String> foodNames) {
        this.context = context;
        this.images = images;
        this.foodNames = foodNames;
    }

    @NonNull
    @Override
    public RCVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_ui_design, (ViewGroup) parent, false);
        MyViewHolder vh = new MyViewHolder(view);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull RCVAdapter.MyViewHolder holder, int position) {
//        if(position > foodNames.size()){
//            if (position % foodNames.size() == 0){
//                for(int i=0; i< foodNames.size() ; i++){
//                    if(i==0){
//                        holder.tv_grid.setText(foodNames.get((0)));
//                        holder.img_grid.setImageResource(images.get((0)));
//                        Log.e("RCV-if", "Index: " +((position % foodNames.size())));
//                    }
//                    else{
//                        holder.tv_grid.setText(foodNames.get((position % foodNames.size()) +i));
//                        holder.img_grid.setImageResource(images.get((position % foodNames.size()) +i));
//                        Log.e("RCV-else", "Index: " +((position % foodNames.size())+i));
//                    }
//
////                    Log.e("RCV", "Index: " +(position % foodNames.size()));
////                    Log.e("RCV", "Index: " +((position % foodNames.size())+i));
//                }
//            }
//
//
//
//            else{
//                holder.tv_grid.setText(foodNames.get((position % foodNames.size())));
//                holder.img_grid.setImageResource(images.get((position % foodNames.size())));
//
////                Log.e("RCV-Else", "Index: " +(position % foodNames.size()));
//            }
//        }
//        else{
//            holder.tv_grid.setText(foodNames.get((position % foodNames.size())));
//            holder.img_grid.setImageResource(images.get((position % foodNames.size())));
//            Log.e("RCV-Else []", "Index: " +(position % foodNames.size()));
//        }
//        holder.tv_grid.setText(foodNames.get((position % foodNames.size())));
//        holder.img_grid.setImageResource(images.get((position % foodNames.size())));

        holder.img_grid.setOnClickListener(view -> {
            Toast.makeText(context, "Item: " +foodNames.get((position % foodNames.size())), Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public int getItemCount() {
//        return foodNames.size();
        return Integer.MAX_VALUE;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img_grid;
        TextView tv_grid;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_grid = (ImageView) itemView.findViewById(R.id.item_img);
            tv_grid = (TextView) itemView.findViewById(R.id.foodItemName);
        }
    }
}



