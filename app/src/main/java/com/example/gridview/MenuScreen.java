package com.example.gridview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.SimpleColorFilter;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieValueCallback;

public class MenuScreen extends Fragment {

    private final Context context;
    boolean isClicked = false;
    LottieAnimationView like;
    public MenuScreen(Context context) {
        // Required empty public constructor
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_screen, container, false);

        like = view.findViewById(R.id.like);
//


        like.setOnClickListener(view1 -> {



            if (isClicked){
                isClicked = false;
                SimpleColorFilter dislike = new SimpleColorFilter(Color.GRAY);
                LottieValueCallback<ColorFilter> callback1 = new LottieValueCallback<ColorFilter>(dislike);
                KeyPath keyPath = new KeyPath("**");
                like.addValueCallback(keyPath, LottieProperty.COLOR_FILTER, callback1);
            }
            else{
                isClicked = true;
                SimpleColorFilter cl_like = new SimpleColorFilter(Color.parseColor("#673AB7"));
                LottieValueCallback<ColorFilter> callback2 = new LottieValueCallback<ColorFilter>(cl_like);
                KeyPath keyPath2 = new KeyPath("**");
                like.addValueCallback(keyPath2, LottieProperty.COLOR_FILTER, callback2);
                like.playAnimation();
            }

        });
        return view;
    }
}

/*/
[Today Work]
1. Favourite Items Activity, List, Adapter work.
2. Work on favourite button animation (library & custom).

 */