package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.CountDownTimer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RCVAdapter rcvAdapter;
    CountDownTimer timer;
    int i,j = 0;
    ArrayList<Integer> images;
    ArrayList<String> foodNames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        images = new ArrayList<Integer>();
        foodNames = new ArrayList<>();
        images.add(R.drawable.food_1); foodNames.add("Food 1");
        images.add(R.drawable.food_2); foodNames.add("Food 2");
        images.add(R.drawable.food_3); foodNames.add("Food 3");
        images.add(R.drawable.food_4); foodNames.add("Food 4");
        images.add(R.drawable.food_5); foodNames.add("Food 5");
        images.add(R.drawable.chicken); foodNames.add("Food 6");


        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rcvAdapter = new RCVAdapter(MainActivity.this, images, foodNames);
        recyclerView.setAdapter(rcvAdapter);

        timer = new CountDownTimer(Long.MAX_VALUE, 1500) {
            @Override
            public void onTick(long l) {
//                if(i < rcvAdapter.getItemCount()){
//                    recyclerView.smoothScrollToPosition(i);
////                    recyclerView.scrollToPosition(i);
//                    i++;
//
//                }
//                else if(i == rcvAdapter.getItemCount()){
//                    recyclerView.smoothScrollToPosition(rcvAdapter.getItemCount() - j);
//                    j++;
//                    if(j == rcvAdapter.getItemCount()){
//                        i = 0;
//                        j = 0;
//                    }
//                }
                recyclerView.smoothScrollToPosition(i);
                i++;
            }

            @Override
            public void onFinish() {


            }
        }.start();
    }
}

/*/

[Today Work]

1. Study Booklet- Multiple Sending documentation.
2. Learn about AWS Codecommit for git.
3. Implement Auto-Scroll recyclerview.
 */