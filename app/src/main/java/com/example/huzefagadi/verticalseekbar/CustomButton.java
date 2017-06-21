package com.example.huzefagadi.verticalseekbar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * Created by Huzefa Gadi on 6/20/2017.
 */

public class CustomButton extends FrameLayout {
    public CustomButton(Context context) {
        super(context);
        initButton(context);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initButton(context);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initButton(context);
    }


    private void initButton(Context context) {
        inflate(context, R.layout.custom_button,this);
    }

    public void setText(String text) {
        ((Button) findViewById(R.id.button)).setText(text);
    }
}
