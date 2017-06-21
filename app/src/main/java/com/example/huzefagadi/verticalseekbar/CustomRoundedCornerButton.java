package com.example.huzefagadi.verticalseekbar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * Created by Huzefa Gadi on 6/20/2017.
 */

public class CustomRoundedCornerButton extends FrameLayout {
    public CustomRoundedCornerButton(Context context) {
        super(context);
        initButton(context);
    }

    public CustomRoundedCornerButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initButton(context);
    }

    public CustomRoundedCornerButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initButton(context);
    }


    private void initButton(Context context) {
        inflate(context, R.layout.custom_button, this);
    }

    private void setText(String text) {
        ((Button) findViewById(R.id.button)).setText(text);
    }

    //Builder Class
    public static class Builder {

        // required parameters
        private String mHeaderText = "", mValueText = "", mSymbolText = "%";
        private Context mContext;
        public Builder(Context context) {
            mContext = context;
        }

        public Builder setHeader(String header) {
            mHeaderText = header;
            return this;
        }

        public Builder setValue(String value) {
            mValueText = value;
            return this;
        }

        public Builder setSymbol(String symbol) {
            mSymbolText = symbol;
            return this;
        }

        public CustomRoundedCornerButton build() {
            CustomRoundedCornerButton customRoundedCornerButton = new CustomRoundedCornerButton(mContext);
            customRoundedCornerButton.setText(mHeaderText+"\n"+mValueText+"\n"+mSymbolText);
            return customRoundedCornerButton;
        }

    }

}
