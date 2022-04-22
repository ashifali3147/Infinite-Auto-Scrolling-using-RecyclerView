package com.example.gridview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class OrderScreen extends Fragment {

    Context context;
    public OrderScreen(Context context) {
        this.context = context;
    }
    TextView tv_plus, tv_minus, tv_count, tv_ripple;
    int count = 0;
    LinearLayout ll_submit, ll_addItemToCart;
    RelativeLayout root;
    ImageView slide_menu;
    Animation bounce, bubble, blink, move, move_rev, rotate, sequential, slide_up, slide_down;
    AnimationDrawable changing_effect;
    boolean sectionMenuDropDown = false;
    boolean visible = false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order_screen, container, false);

        tv_plus = (TextView) view.findViewById(R.id.tv_plus);
        tv_minus = (TextView) view.findViewById(R.id.tv_minus);
        tv_count = (TextView) view.findViewById(R.id.tv_count);
        ll_addItemToCart = (LinearLayout) view.findViewById(R.id.addItemToCart_lay);
        root = (RelativeLayout) view.findViewById(R.id.root);
        bounce = AnimationUtils.loadAnimation(context, R.anim.bounce);
        bubble = AnimationUtils.loadAnimation(context, R.anim.bubble);
        move = AnimationUtils.loadAnimation(context, R.anim.move);
        move_rev = AnimationUtils.loadAnimation(context, R.anim.move_rev);
        rotate = AnimationUtils.loadAnimation(context, R.anim.rotate);
        sequential = AnimationUtils.loadAnimation(context, R.anim.sequentional_anim);
        slide_up = AnimationUtils.loadAnimation(context,R.anim.slide_up);
        slide_down = AnimationUtils.loadAnimation(context,R.anim.slide_down);
        blink = AnimationUtils.loadAnimation(context,R.anim.blink);
        ll_submit = view.findViewById(R.id.ll_submit);
        slide_menu = view.findViewById(R.id.slide_menu);
        tv_ripple = view.findViewById(R.id.tv_ripple);
        tv_ripple.setOnClickListener(view1 -> {
            if (visible){
                visible = false;

            }
            else{
                visible = true;
            }
            Toast.makeText(getContext(), "Hi", Toast.LENGTH_SHORT).show();
            Transition transition = new Slide(Gravity.BOTTOM);
            transition.setDuration(600);
            transition.addTarget(R.id.addItemToCart_lay);
            TransitionManager.beginDelayedTransition(root,transition);
            ll_addItemToCart.setVisibility(visible ? View.VISIBLE : View.GONE);

        });
//        ll_submit.setBackgroundColor(Color.parseColor("#0976b8"));

//        slide_menu.setBackgroundResource(R.drawable.expand_collapse);
//        changing_effect = (AnimationDrawable) slide_menu.getBackground();
        slide_menu.setOnClickListener(view1 -> {
//            Resources res = context.getResources();
//            TransitionDrawable transition = (TransitionDrawable) res.getDrawable(R.drawable.expand_collapse);
////    ImageView image = (ImageView) findViewById(R.id.toggle_image);
//            slide_menu.setImageDrawable(transition);
//
//            transition.startTransition(5000);
//            changing_effect.start();
            //Ashif rotation animation

//            if (!sectionMenuDropDown){
//                sectionMenuDropDown = true;
//                RotateAnimation rotate_right = new RotateAnimation(0, 90, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//                rotate_right.setDuration(200);
//                rotate_right.setFillAfter(true);
//                rotate_right.setInterpolator(new LinearInterpolator());
//
//                slide_menu.startAnimation(rotate_right);
////                section_lay.setVisibility(VISIBLE);
//            }
            //Ashif added animation
            if (sectionMenuDropDown){
                sectionMenuDropDown = false;
                RotateAnimation rotate_left = new RotateAnimation(90, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotate_left.setDuration(200);
                rotate_left.setFillAfter(true);
                rotate_left.setInterpolator(new LinearInterpolator());

                slide_menu.setImageResource(R.drawable.menu_icon);
                slide_menu.startAnimation(rotate_left);
//                slide_menu.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.menu_icon));
                Toast.makeText(context, "Menu", Toast.LENGTH_SHORT).show();
//                section_lay.setVisibility(View.GONE);
            }
            else{
                sectionMenuDropDown = true;
                RotateAnimation rotate_right = new RotateAnimation(0, 90, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotate_right.setDuration(200);
                rotate_right.setFillAfter(true);
                rotate_right.setInterpolator(new LinearInterpolator());

                slide_menu.setImageResource(R.drawable.close_icon);
                slide_menu.startAnimation(rotate_right);
//                slide_menu.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.close_icon));
                Toast.makeText(context, "Close", Toast.LENGTH_SHORT).show();

            }
        });
        ll_submit.setOnClickListener(view1 -> {
            Toast.makeText(getContext(), "Submitted", Toast.LENGTH_SHORT).show();
        });
        count = 0;
        tv_plus.setOnClickListener(view1 -> {
            count++;
            visibilityCheck(count);
            tv_count.setText(""+count);
            tv_count.startAnimation(slide_down);
        });
        tv_minus.setOnClickListener(view1 -> {
            count--;
            visibilityCheck(count);
            tv_count.setText(""+count);
            tv_count.startAnimation(blink);
        });
        return view;
    }

    public void visibilityCheck(int count){
        if (count < 0){
            tv_count.setVisibility(View.GONE);
        }
        else{
            tv_count.setVisibility(View.VISIBLE);
        }
    }

}

/*/
[Today Work]
1. Solve animation lag problem in bottom navigation bar.
2. Add animation in MyOrder, AddOn, PastOrder.
3. Slide Up-Down animation added in CartMenu.

 */