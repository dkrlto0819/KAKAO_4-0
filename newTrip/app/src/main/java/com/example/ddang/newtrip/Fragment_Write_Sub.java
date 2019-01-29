package com.example.ddang.newtrip;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Fragment_Write_Sub extends LinearLayout {
    TextView dayText;
    ImageView destinationPicture;

    public Fragment_Write_Sub(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void changeTextView(int dayValue){
        dayText=(TextView)findViewById(R.id.DayText);
        dayText.setText(String.valueOf(dayValue)+"일차");
        return;
    }


    public Fragment_Write_Sub(Context context) {
        super(context);
        init(context);
    }

    private void init(final Context context){
        LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.fragment_write_sub, this, true);
    }

}
