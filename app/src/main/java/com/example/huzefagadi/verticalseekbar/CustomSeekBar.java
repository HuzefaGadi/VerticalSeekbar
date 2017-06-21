package com.example.huzefagadi.verticalseekbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;

/**
 * Created by Huzefa Gadi on 6/19/2017.
 */

public class CustomSeekBar extends android.support.v7.widget.AppCompatSeekBar {

    public CustomSeekBar(Context context) {
        super(context);
    }

    public CustomSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private boolean isDragging;

    private boolean isWithinThumb(MotionEvent event) {
        return getThumb().getBounds().contains((int)event.getX(), (int)event.getY());
    }

    private void increment(int direction) {
        if (direction != 0) {
            final KeyEvent key = new KeyEvent(KeyEvent.ACTION_DOWN,
                direction < 0 ? KeyEvent.KEYCODE_DPAD_LEFT : KeyEvent.KEYCODE_DPAD_RIGHT);
            onKeyDown(key.getKeyCode(), key);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!isEnabled() || getThumb() == null) return super.onTouchEvent(event);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (isWithinThumb(event)) {
                    isDragging = true;
                    return super.onTouchEvent(event);
                } else {
                    return true;
                }

            case MotionEvent.ACTION_UP:
                isDragging = false;
                if (isWithinThumb(event)) {
                    return super.onTouchEvent(event);
                } else {
                    final Rect r = getThumb().getBounds();
                    increment((int)event.getX() - (r.left + r.right) / 2);
                    return true;
                }

            case MotionEvent.ACTION_MOVE:
                if (!isDragging) return true;
                break;

            case MotionEvent.ACTION_CANCEL:
                isDragging = false;
                break;
        }

        return super.onTouchEvent(event);
    }
}