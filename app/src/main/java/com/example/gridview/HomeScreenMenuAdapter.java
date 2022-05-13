package com.example.gridview;

import android.content.Context;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.sackcentury.shinebuttonlib.ShineButton;

import java.util.ArrayList;
import java.util.List;

public class HomeScreenMenuAdapter extends RecyclerView.Adapter<HomeScreenMenuAdapter.MyviewHolder> {
    Context context;

//    boolean isLiked = false;
    List<Boolean> isLiked = new ArrayList<>();
    public HomeScreenMenuAdapter(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_ui_design, viewGroup, false);
        MyviewHolder myviewHolder = new MyviewHolder(view);
        addData();
        return myviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder myviewHolder, int i) {
        checkLikeDislike(i, myviewHolder);
        myviewHolder.like.setOnClickListener(view1 -> {
            if (isLiked.get(i)){
                isLiked.add(i,false);
//                myviewHolder.like.
                myviewHolder.like.setBtnColor(Color.GRAY);
                myviewHolder.like.setBtnFillColor(Color.GRAY);
                Toast.makeText(context, "Dislike", Toast.LENGTH_SHORT).show();
            }
            else{
                isLiked.add(i,true);
                myviewHolder.like.setBtnFillColor(Color.parseColor("#673AB7"));
                Toast.makeText(context, "Like", Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        ShineButton like;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
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
    public void checkLikeDislike(int position, MyviewHolder viewHolder){
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
