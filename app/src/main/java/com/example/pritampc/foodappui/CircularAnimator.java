package com.example.pritampc.foodappui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;

import java.sql.Time;

import jp.wasabeef.blurry.Blurry;

/**
 * Created by pritamPC on 1/22/2018.
 */

public class CircularAnimator {
    private static final String TAG="MAIN";
    Context context;
    public CircularAnimator(Context context) {
        this.context=context;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void enterReveal(View v, final RelativeLayout design)
    {
            final float startRad = 0f;
            int w=v.getWidth();
            int h=v.getHeight();
            Log.d(TAG, "enterReveal:width "+ w +" height " + h);
            float endRad =  (int)Math.hypot(w, h);
            Log.d(TAG, "enterReveal: hypo" + endRad);
            Animator animator = ViewAnimationUtils.createCircularReveal(v, w, h, startRad, endRad);
            v.setVisibility(View.VISIBLE);
            animator.setInterpolator(new LinearInterpolator());
            animator.setDuration(200);
            Blurry.with(context).radius(20).sampling(10).color(Color.argb(66, 255, 255, 0)).async().animate(200).onto(design);
            animator.start();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void exitReveal(final View v,RelativeLayout design)
    {
        int w=v.getWidth();
        int h=v.getHeight();
        final float startRad=(int)Math.hypot(w,h);
        final float endrad=0f;
        Animator animator=ViewAnimationUtils.createCircularReveal(v,w,h,startRad,endrad);
        animator.setInterpolator(new FastOutLinearInInterpolator());
        //animator.setDuration(500);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                v.setVisibility(View.INVISIBLE);
            }
        });
        animator.start();
        Blurry.delete(design);
    }
}
