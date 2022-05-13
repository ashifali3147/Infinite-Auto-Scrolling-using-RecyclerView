package com.example.gridview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.SimpleColorFilter;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieValueCallback;

public class MenuScreen extends Fragment {

    private final Context context;
    boolean isClicked = false;
    LottieAnimationView like;
    ImageView double_tap, like_dislike;
    RelativeLayout ll_like_dislike;
    Animation bounce, bubble, blink, move, move_rev, rotate, sequential, slide_up, slide_down;
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
        double_tap = view.findViewById(R.id.double_tap);
        like_dislike = view.findViewById(R.id.like_dislike);
        ll_like_dislike = view.findViewById(R.id.ll_like_dislike);
        bounce = AnimationUtils.loadAnimation(context, R.anim.bounce);
        bubble = AnimationUtils.loadAnimation(context, R.anim.bubble);
        move = AnimationUtils.loadAnimation(context, R.anim.move);
        move_rev = AnimationUtils.loadAnimation(context, R.anim.move_rev);
        rotate = AnimationUtils.loadAnimation(context, R.anim.rotate);
        sequential = AnimationUtils.loadAnimation(context, R.anim.sequentional_anim);
        slide_up = AnimationUtils.loadAnimation(context,R.anim.slide_up);
        slide_down = AnimationUtils.loadAnimation(context,R.anim.slide_down);
        blink = AnimationUtils.loadAnimation(context,R.anim.blink);
        ll_like_dislike.setOnClickListener(view1 -> {
            like_dislike.startAnimation(bounce);
            like_dislike.setColorFilter(R.color.green, android.graphics.PorterDuff.Mode.MULTIPLY);
        });
//
            final GestureDetector gd = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){


                //here is the method for double tap


                @Override
                public boolean onDoubleTap(MotionEvent e) {

                    //your action here for double tap e.g.
                    //Log.d("OnDoubleTapListener", "onDoubleTap");
                    Toast.makeText(getContext(), "DDDD", Toast.LENGTH_SHORT).show();

                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    super.onLongPress(e);

                }

                @Override
                public boolean onDoubleTapEvent(MotionEvent e) {
                    return true;
                }

                @Override
                public boolean onDown(MotionEvent e) {
                    return true;
                }


            });
        
        double_tap.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return gd.onTouchEvent(motionEvent);
            }
        });

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
1. Product image bug fix in Listing Activity.
2. MainActivity work for fragment changes.
2. Complete Favourite item list work and push in wl_v6.

1. Work on add & remove button.
2. Favourite List page work.
3. Adapter work.

1. Favourite Items Activity, List, Adapter work.
2. Work on favourite button animation (library & custom).

 */