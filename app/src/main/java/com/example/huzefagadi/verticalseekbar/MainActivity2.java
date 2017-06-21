package com.example.huzefagadi.verticalseekbar;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    private int startPoint = 10;
    private int maxDelta = 0;
    private int buffSize = 3;
    private int throttle = 0;
    SeekBar mSeekbar;
    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mSeekbar = (SeekBar) findViewById(R.id.seekBar1);
        mSeekbar.setProgress(mSeekbar.getMax()/2);
        mSeekbar.setOnSeekBarChangeListener(this);
        mTextView = (TextView)findViewById(R.id.textView);
    }

    private void updateThrottle(int newThrottle) {
        if (startPoint == 10) {
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

        mTextView.setText("Throttle: " + Integer.toString(throttle));
    }

    @Override
    public void onStopTrackingTouch(final SeekBar seekBar) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                seekBar.setProgress(1);
                mTextView.setText("Throttle: " + Integer.toString(0));
            }
        });
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
     //   updateThrottle(progress);
        seekBar.setProgress(1);
    }
}

