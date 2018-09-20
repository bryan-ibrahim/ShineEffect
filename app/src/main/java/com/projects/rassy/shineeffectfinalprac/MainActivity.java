package com.projects.rassy.shineeffectfinalprac;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imgShine = findViewById(R.id.imgShineEffect);
        ImageView imgShine2 = findViewById(R.id.imgShineEffect2);
        Button btnAnimate = findViewById(R.id.btnAnimate);
        RelativeLayout rlAnimator = findViewById(R.id.rlAnimator);

        Animation animation = new TranslateAnimation(0,btnAnimate.getWidth() + 450,0,0);
        animation.setDuration(1200);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(ValueAnimator.INFINITE);
        animation.setStartOffset(1200);
        imgShine.startAnimation(animation);
        imgShine2.startAnimation(animation);

        ObjectAnimator translationAnimator = ObjectAnimator.ofFloat(rlAnimator,"translationY",50);
        translationAnimator.setRepeatCount(ValueAnimator.INFINITE);
        translationAnimator.setRepeatMode(ValueAnimator.REVERSE);

        ObjectAnimator textColorAnimator = ObjectAnimator.ofObject(btnAnimate,"textColor",
                new ArgbEvaluator(),Color.BLACK,Color.BLUE);
        textColorAnimator.setRepeatCount(ValueAnimator.INFINITE);
        textColorAnimator.setRepeatMode(ValueAnimator.REVERSE);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(translationAnimator,textColorAnimator);
        animatorSet.setDuration(800);
        animatorSet.start();
    }
}
