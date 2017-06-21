package com.example.huzefagadi.verticalseekbar;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        final Dialog dialog = new Dialog(this);
// dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_button_percentage);
        dialog.setTitle("Title...");

// set the custom dialog components - text, image and button
        GridLayout gridLayout = (GridLayout) dialog.findViewById(R.id.gridLayout);
        for(int i =0;i<100;i++) {
            CustomRoundedCornerButton button = new CustomRoundedCornerButton.Builder(this)
                .setHeader("Depth")
                .setValue(i+1+"")
                .build();
            button.setTag(i);
            gridLayout.addView(button);
        }
        gridLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GridViewActivity.this, "Button clicked"+v.getTag(), Toast.LENGTH_SHORT).show();
            }
        });

        ImageView closeButton = (ImageView) dialog.findViewById(R.id.close_button);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
