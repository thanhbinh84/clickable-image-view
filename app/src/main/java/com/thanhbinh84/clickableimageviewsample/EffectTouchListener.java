package com.thanhbinh84.clickableimageviewsample;

/**
 * Created by ntbinh on 5/30/17.
 */

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * To make image view received touch effect like as button
 */

public class EffectTouchListener implements View.OnTouchListener {

    private static final int FILTERED_GREY = Color.argb(120, 0, 0, 0);

    public EffectTouchListener(){}

    Rect rect; // Variable rect to hold the bounds of the view

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    rect = new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                    imageView.setColorFilter(FILTERED_GREY, PorterDuff.Mode.SRC_ATOP);
                    view.invalidate();
                    break;
                }
                case MotionEvent.ACTION_MOVE:
                    // if move inside button do nothing, otherwise clear filter
                    if(rect.contains(view.getLeft() + (int) event.getX(), view.getTop() + (int) event.getY()))
                        break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL: // Action call when button is inside scrollable view
                    imageView.clearColorFilter();
                    view.invalidate();
            }
        }
        return false;
    }
}
