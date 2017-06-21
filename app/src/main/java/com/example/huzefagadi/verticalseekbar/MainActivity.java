package com.example.huzefagadi.verticalseekbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private int startPoint = 50;
    private int maxDelta = 0;
    private int buffSize = 3;
    private int throttle = 0;
    SeekBar mSeekbar;
    TextView mTextView;
    int mCurrentValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSeekbar = (SeekBar) findViewById(R.id.seekBar1);
        mSeekbar.setProgress(mSeekbar.getMax() / 2);
        mSeekbar.setOnSeekBarChangeListener(this);
        mTextView = (TextView) findViewById(R.id.textView);
    }

    private void updateThrottle(int newThrottle) {
        if (startPoint == 50) {
            startPoint = newThrottle;
            Log.d("Throttle", "Set startPoint: " + newThrottle + " " + startPoint);
        }

        Log.d("Throttle", "startPoint: " + startPoint);

        if (newThrottle > startPoint) {
            throttle = Math.min(newThrottle - startPoint, 100);
        }

        if (newThrottle < startPoint) {
            throttle = Math.max(newThrottle - startPoint, -100);
        }
        int progress = throttle;
        if (mCurrentValue <= 50 && mCurrentValue >= 0) {
            if (progress > 40) {
                mCurrentValue = mCurrentValue + 4;
            } else if (progress > 30) {
                mCurrentValue = mCurrentValue + 3;
            } else if (progress > 20) {
                mCurrentValue = mCurrentValue + 2;
            } else if (progress > 10) {
                mCurrentValue = mCurrentValue + 1;
            } else if (progress < 10) {
                mCurrentValue = mCurrentValue - 1;
            } else if (progress < 20) {
                mCurrentValue = mCurrentValue - 2;
            } else if (progress < 30) {
                mCurrentValue = mCurrentValue - 3;
            } else if (progress < 40) {
                mCurrentValue = mCurrentValue - 4;
            }
        } else if (mCurrentValue > 50) {
            mCurrentValue = 50;
        } else if (mCurrentValue < 0) {
            mCurrentValue = 0;
        }
        Log.d("Current Value", mCurrentValue+" ");
        mTextView.setText("Throttle: " + Integer.toString(mCurrentValue));
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        seekBar.setProgress(seekBar.getMax() / 2);
        // mTextView.setText("Throttle: " + Integer.toString(0));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        mTextView.setText("Throttle: " + Integer.toString(seekBar.getProgress()));
    }
}

