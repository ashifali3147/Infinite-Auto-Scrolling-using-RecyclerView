package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    HomeScreen homeScreen;
    OrderScreen orderScreen;
    MenuScreen menuScreen;
    UserScreen userScreen;
    boolean isClick;
    ImageView tab_home, tab_menu, tab_order, tab_user, test_anim, loader;
    Animation bounce, bubble, move, move_rev, rotate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab_home = (ImageView) findViewById(R.id.tab_home);
        tab_menu = (ImageView) findViewById(R.id.tab_menu);
        tab_order = (ImageView) findViewById(R.id.tab_order);
        tab_user = (ImageView) findViewById(R.id.tab_user);
        test_anim = (ImageView) findViewById(R.id.test_anim);
        loader = (ImageView) findViewById(R.id.loader);

        bounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
        bubble = AnimationUtils.loadAnimation(this, R.anim.bubble);
        move = AnimationUtils.loadAnimation(this, R.anim.move);
        move_rev = AnimationUtils.loadAnimation(this, R.anim.move_rev);
        rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);

        homeScreen = new HomeScreen(this);
        orderScreen = new OrderScreen(this);
        menuScreen = new MenuScreen(this);
        userScreen = new UserScreen(this);

//        loader.startAnimation(rotate);
        loader.setVisibility(View.GONE);
        loader.setOnClickListener(view -> {
            loader.clearAnimation();
        });

        test_anim.setOnClickListener(view -> {

            test_anim.startAnimation(move_rev);

            Log.e("Boolean", "isClick " +isClick);
            if (isClick){
                Log.e("Boolean-if", "isClick " +isClick);
                test_anim.startAnimation(move_rev);
                isClick = false;
            }
            else{
                Log.e("Boolean-else", "isClick " +isClick);
                test_anim.startAnimation(move);
                isClick = true;
            }


        });
        setFragment(homeScreen);
        tab_home.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
            setFragment(homeScreen);
            setBackgroundForAll();
            tab_home.setBackgroundColor(Color.parseColor("#57DAD7D7"));
            tab_home.startAnimation(bounce);
        });
        tab_menu.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "Menu", Toast.LENGTH_SHORT).show();
            setFragment(menuScreen);
            setBackgroundForAll();
            tab_menu.setBackgroundColor(Color.parseColor("#57DAD7D7"));
            tab_menu.startAnimation(bounce);
        });
        tab_order.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "Order", Toast.LENGTH_SHORT).show();
            setFragment(orderScreen);
            setBackgroundForAll();
            tab_order.setBackgroundColor(Color.parseColor("#57DAD7D7"));
            tab_order.startAnimation(bounce);
        });
        tab_user.setOnClickListener(view -> {
//            Toast.makeText(getApplicationContext(), "User", Toast.LENGTH_SHORT).show();
            setFragment(userScreen);
            setBackgroundForAll();
            tab_user.setBackgroundColor(Color.parseColor("#57DAD7D7"));
            tab_user.startAnimation(bounce);

        });
    }

    public void setFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        fragmentTransaction.replace(R.id.frame_home, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();



//        fragmentTransaction.commit();
//        fragmentTransaction.replace()

        tab_home.setBackgroundColor(Color.parseColor("#57DAD7D7"));
    }

    public void setBackgroundForAll(){
        tab_home.setBackgroundColor(Color.WHITE);
        tab_menu.setBackgroundColor(Color.WHITE);
        tab_order.setBackgroundColor(Color.WHITE);
        tab_user.setBackgroundColor(Color.WHITE);
    }
}

/*/
[Today Work]

1. UI discussion with Vivek.
2. Make changes in Section Menu.
3. Go through some new android Transition & functions.
 */

