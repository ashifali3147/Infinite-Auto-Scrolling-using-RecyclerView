package com.example.gridview;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


public class HomeScreen extends Fragment {

    private final Context context;
    RecyclerView recyclerView;
    RCVAdapter rcvAdapter;
    CountDownTimer timer;
    int i,j = 0;
    ArrayList<Integer> images;
    ArrayList<String> foodNames;
    RecyclerView recyclerView_menu;
    HomeScreenMenuAdapter homeScreenMenuAdapter;
    Button btn_activity, btn_otp_activity;
    public HomeScreen(Context context){
        this.context = context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_screen, container, false);
        images = new ArrayList<Integer>();
        foodNames = new ArrayList<>();
        images.add(R.drawable.food_1); foodNames.add("Food 1");
        images.add(R.drawable.food_2); foodNames.add("Food 2");
        images.add(R.drawable.food_3); foodNames.add("Food 3");
        images.add(R.drawable.food_4); foodNames.add("Food 4");
        images.add(R.drawable.food_5); foodNames.add("Food 5");
        images.add(R.drawable.chicken); foodNames.add("Food 6");

        recyclerView_menu = view.findViewById(R.id.rv_menu);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv);
        recyclerView_menu.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        rcvAdapter = new RCVAdapter(context, images, foodNames);
        recyclerView_menu.setAdapter(rcvAdapter);


//        recyclerView_menu.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
//        homeScreenMenuAdapter = new HomeScreenMenuAdapter(getActivity());
//        recyclerView_menu.setAdapter(homeScreenMenuAdapter);
        btn_activity = view.findViewById(R.id.btn_activity1);
        btn_otp_activity = view.findViewById(R.id.btn_otp_activity);
        btn_activity.setOnClickListener(view1 -> {
            Bundle c = ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle();
            startActivity(new Intent(context, Activity1.class), c);
        });
        btn_otp_activity.setOnClickListener(view1 -> {
            startActivity(new Intent(context, OTPActivity.class));
        });
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
//                recyclerView.setScrollBarFadeDuration(i);
                i++;
            }

            @Override
            public void onFinish() {


            }
        }.start();
        // Inflate the layout for this fragment
        return view;
    }
}

/*/
[Today Work]
1. Complete new Card UI for HomeScreen menu & implement in coffee-to-go.
2. Add item details in menu items from Admin Dashboards.

1. Merge Login & OTP Activity in NewLoginActivity & push in wl_v6.
2. Create new dummy UI for menu order.
 */