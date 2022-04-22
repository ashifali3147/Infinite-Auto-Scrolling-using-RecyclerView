package com.example.gridview;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.SimpleColorFilter;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieValueCallback;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.Timer;

import br.com.simplepass.loadingbutton.customViews.CircularProgressButton;
import br.com.simplepass.loadingbutton.customViews.CircularProgressImageButton;


public class UserScreen extends Fragment {

    public Dialog dialog, reward;
    Button dialog_button, reward_button, btn_cancel;
    CircularProgressButton circular_button;
    CircularProgressImageButton circular_img_btn;
    private final Context context;
    int i = 0;
    boolean isClicked = false;
    public UserScreen(Context context) {
        // Required empty public constructor
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_screen, container, false);
        circular_button = (CircularProgressButton) view.findViewById(R.id.btn_id);
        circular_img_btn = (CircularProgressImageButton) view.findViewById(R.id.btn_img);
        TimeZone timeZone = TimeZone.getDefault();
        timeZone.getID();
        circular_img_btn.setOnClickListener(view1 -> {
            circular_img_btn.startAnimation();
        });
        circular_button.setOnClickListener(view1 -> {
            if (isClicked){
//                circular_button.revertAnimation();
//                circular_button.stopAnimation();
                isClicked = false;
                Toast.makeText(getContext(), "False", Toast.LENGTH_SHORT).show();
            }
            else {
                circular_button.startAnimation();
//                circular_button.setProgress(10);
                isClicked = true;
                Toast.makeText(getContext(), "True-> " +convertTimeZone(), Toast.LENGTH_SHORT).show();
            }

        });
        dialog_button = view.findViewById(R.id.dialog_button);
        reward_button = view.findViewById(R.id.reward_button);
        btn_cancel = view.findViewById(R.id.btn_stop);
        btn_cancel.setOnClickListener(view1 -> {
            circular_button.revertAnimation();
        });
        reward_button.setOnClickListener(view1 -> {
            reward();
        });
        dialog_button.setOnClickListener(view1 -> {
            dialog();
        });

        return view;
    }
    public void dialog(){
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.custom_dialog_lay);
        LottieAnimationView lottieAnimationView=dialog.findViewById(R.id.lottie_loader);
//        lottieAnimationView.setColorFilter(Color.BLACK);
        SimpleColorFilter simpleColorFilter1 = new SimpleColorFilter(Color.parseColor("#359edf"));
        SimpleColorFilter simpleColorFilter2 = new SimpleColorFilter(Color.parseColor("#e68612"));
        SimpleColorFilter simpleColorFilter3 = new SimpleColorFilter(Color.parseColor("#37e610"));
        KeyPath keyPath = new KeyPath("**");
//        CountDownTimer timer = new CountDownTimer(Long.MAX_VALUE, 1800) {
//            @Override
//            public void onTick(long l) {
//                i++;
//                if (i == 1){
//                    LottieValueCallback<ColorFilter> callback1 = new LottieValueCallback<ColorFilter>(simpleColorFilter1);
//                    lottieAnimationView.addValueCallback(keyPath, LottieProperty.COLOR_FILTER, callback1);
//                    dialog.show();
//                }
//                else if(i == 2){
//                    LottieValueCallback<ColorFilter> callback2 = new LottieValueCallback<ColorFilter>(simpleColorFilter2);
//                    lottieAnimationView.addValueCallback(keyPath, LottieProperty.COLOR_FILTER, callback2);
//                    dialog.show();
//                }
//                else if (i == 3){
//                    LottieValueCallback<ColorFilter> callback3 = new LottieValueCallback<ColorFilter>(simpleColorFilter3);
//                    lottieAnimationView.addValueCallback(keyPath, LottieProperty.COLOR_FILTER, callback3);
//                    dialog.show();
//                }
//                else if (i == 4){
//                    i = 1;
//                }
//            }
//
//            @Override
//            public void onFinish() {
//
//            }
//        }.start();
        TextView tv = dialog.findViewById(R.id.loading_text);
        tv.setText("Custom");



        dialog.show();
    }
    public void reward(){
        reward = new Dialog(context);
        reward.requestWindowFeature(Window.FEATURE_NO_TITLE);
        reward.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        reward.setCancelable(true);
        reward.setContentView(R.layout.reward_claimed);
        reward.show();
    }
    public String convertTimeZone(){
        SimpleDateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sourceFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date parsed = null; // => Date is in UTC now
        try {
            parsed = sourceFormat.parse("2011-03-01 15:10:37");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        TimeZone tz = TimeZone.getTimeZone("America/Chicago");
        SimpleDateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        destFormat.setTimeZone(tz);

        String result = destFormat.format(parsed);
        return  result;
    }

}

/*/
[Today Work]
1. Confirm, Failed order popup animation work.
2. Reward popup animation work.
3. Work on Cancel Order timezone problem.

1. Complete Loader work & push it in wl_v6.
2. Done minor changes in button animation & push in wl_v7.
 */