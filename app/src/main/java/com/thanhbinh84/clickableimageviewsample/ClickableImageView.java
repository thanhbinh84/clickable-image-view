package com.thanhbinh84.clickableimageviewsample;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by ntbinh on 5/30/17.
 */

/**
 * An extension to {@link ImageView} which has a touch effect and prevent multiple click issue.
 */
public class ClickableImageView extends AppCompatImageView {

    public ClickableImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(new EffectTouchListener());
    }
}