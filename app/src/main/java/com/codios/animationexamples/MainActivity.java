package com.codios.animationexamples;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    private static final long ANIM_DURATION_MS = 10 * 1000;

    private Button startAnimBtn;
    private Button stopAnimBtn;
    private LinearLayout animationLeftLL;
    private LinearLayout animationRightLL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_activity);
        initViews();
    }

    private void initViews() {
        startAnimBtn = (Button) findViewById(R.id.btn_start_animation);
        stopAnimBtn = (Button) findViewById(R.id.btn_stop_animation);
        animationLeftLL = (LinearLayout) findViewById(R.id.ll_animation_views_left);
        animationRightLL = (LinearLayout) findViewById(R.id.ll_animation_views_right);

        startAnimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationLeftLL.setVisibility(View.VISIBLE);
                animationRightLL.setVisibility(View.VISIBLE);
                startLoading(animationLeftLL, "translationX", ANIM_DURATION_MS, 0f, -((float) animationLeftLL.getWidth()));
                startLoading(animationRightLL, "translationX", ANIM_DURATION_MS, (float) animationLeftLL.getWidth(), 0f);
            }
        });

        stopAnimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationLeftLL.clearAnimation();
                animationRightLL.clearAnimation();
                animationLeftLL.setVisibility(View.GONE);
                animationRightLL.setVisibility(View.GONE);
            }
        });
    }

    private void startLoading(View view, String animPropertyName, long duration, float... values) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, animPropertyName, values);
        objectAnimator.setDuration(duration);
        objectAnimator.setRepeatCount(Integer.MAX_VALUE);
        objectAnimator.start();
    }
}
