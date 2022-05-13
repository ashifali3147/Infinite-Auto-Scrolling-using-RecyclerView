package com.example.gridview;

import android.content.Context;
import android.graphics.Color;
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

import com.sackcentury.shinebuttonlib.ShineButton;

import java.util.ArrayList;
import java.util.List;

public class RCVAdapter extends RecyclerView.Adapter<RCVAdapter.MyViewHolder>{

    private final Context context;
    private final ArrayList<Integer> images;
    private final ArrayList<String> foodNames;
    List<Boolean> isLiked = new ArrayList<>();
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
        addData();
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
        checkLikeDislike(position, holder);
        holder.like.setOnClickListener(view1 -> {
            if (isLiked.get(position)){
                isLiked.add(position,false);
//                myviewHolder.like.
                holder.like.setBtnColor(Color.GRAY);
                holder.like.setBtnFillColor(Color.GRAY);
                Toast.makeText(context, "Dislike", Toast.LENGTH_SHORT).show();
            }
            else{
                isLiked.add(position,true);
                holder.like.setBtnFillColor(Color.parseColor("#673AB7"));
                Toast.makeText(context, "Like", Toast.LENGTH_SHORT).show();
            }

        });

    }

    @Override
    public int getItemCount() {
        return foodNames.size();
//        return Integer.MAX_VALUE;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img_grid;
        TextView tv_grid;
        ShineButton like;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_grid = (ImageView) itemView.findViewById(R.id.item_img);
            tv_grid = (TextView) itemView.findViewById(R.id.foodItemName);
            like = itemView.findViewById(R.id.like);
            like.setBtnColor(Color.GRAY);
            like.setBtnFillColor(Color.parseColor("#673AB7"));
        }
    }
    public void addData(){
        isLiked.add(false);
        isLiked.add(false);
        isLiked.add(true);
        isLiked.add(true);
        isLiked.add(false);
        isLiked.add(true);
        isLiked.add(false);
        isLiked.add(true);
        isLiked.add(false);
        isLiked.add(true);
    }
    public void checkLikeDislike(int position, MyViewHolder viewHolder){
        if (isLiked.get(position)){
//            isLiked.add(position,false);
            viewHolder.like.setBtnColor(Color.parseColor("#673AB7"));

//            Toast.makeText(context, "Dislike", Toast.LENGTH_SHORT).show();
        }
        else{
//            isLiked.add(i,true);
//            viewHolder.like.setBtnFillColor(Color.parseColor("#673AB7"));
//            Toast.makeText(context, "Like", Toast.LENGTH_SHORT).show();

            viewHolder.like.setBtnColor(Color.GRAY);
        }
    }
}



