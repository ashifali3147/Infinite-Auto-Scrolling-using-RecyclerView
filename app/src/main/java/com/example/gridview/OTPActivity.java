package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class OTPActivity extends AppCompatActivity {
    Button btn_otp;
    EditText edt_number;
    Animation otp_appear, otp_hide, otp_appear_reverse, otp_hide_reverse;
    LinearLayout ll_number, ll_otp;
    boolean isClick = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpactivity);
        btn_otp  = findViewById(R.id.btn_otp);
        edt_number = findViewById(R.id.edt_number);
        ll_number = findViewById(R.id.ll_edt_number);
        ll_otp = findViewById(R.id.ll_edt_otp);
        otp_hide = AnimationUtils.loadAnimation(this, R.anim.otp_hide);
        otp_hide_reverse = AnimationUtils.loadAnimation(this, R.anim.otp_hide_reverse);
        otp_appear = AnimationUtils.loadAnimation(this, R.anim.otp_appear);
        otp_appear_reverse = AnimationUtils.loadAnimation(this, R.anim.otp_appear_reverse);

        btn_otp.setOnClickListener(view -> {

            if (isClick){
                btn_otp.setText("Send OTP");
                ll_otp.startAnimation(otp_appear_reverse);
                otp_appear_reverse.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
//                        ll_number.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        ll_number.setVisibility(View.VISIBLE);
                        ll_number.startAnimation(otp_appear);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
//                ll_otp.startAnimation(otp_hide_reverse);
                isClick = false;
            }
            else{
                btn_otp.setText("Enter OTP");
                ll_number.startAnimation(otp_hide);
                otp_hide.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        ll_number.setVisibility(View.GONE);
                        ll_otp.startAnimation(otp_hide_reverse);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
//                ll_otp.startAnimation(otp_appear_reverse);

                isClick = true;
            }
        });
    }
}