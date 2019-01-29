package com.example.ddang.newtrip;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Fragment_Write extends Fragment {

    Button plusButton;
    Button minusButton;
    EditText dayBox;
    TextView dayText;
    ImageView destinationPicture;
    LinearLayout con;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_write, container, false);
        plusButton = (Button)view.findViewById(R.id.Plus);
        minusButton = (Button)view.findViewById(R.id.Minus);
        dayBox = (EditText)view.findViewById(R.id.DayNumber);
        con = (LinearLayout)view.findViewById(R.id.PlusDay);
        dayText = (TextView)view.findViewById(R.id.DayText);
        //destinationPicture = (ImageView)getView().findViewById(R.id.imageView2);

        plusButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dayBoxValue = dayBox.getText().toString();
                int dayBoxValueInt = Integer.valueOf(dayBoxValue)+1;
                dayBox.setText(String.valueOf(dayBoxValueInt));

                Fragment_Write_Sub n_layout = new Fragment_Write_Sub(getActivity().getApplicationContext());
                n_layout.changeTextView(dayBoxValueInt);
                con.addView(n_layout);
            }
        });

        minusButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                String dayBoxValue = dayBox.getText().toString();
                int dayBoxValueInt = Integer.valueOf(dayBoxValue);
                if(dayBoxValueInt>0) dayBoxValueInt--;
                dayBox.setText(String.valueOf(dayBoxValueInt));

//                Fragment_Write_Sub n_layout = new Fragment_Write_Sub(getActivity().getApplicationContext());
//                LinearLayout con = (LinearLayout)view.findViewById(R.id.con);
//                con.removeView(n_layout);


            }
        });


//        destinationPicture.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d(this.getClass().getName(), "Click!");
//                Log.w(this.getClass().getName(), "Click!");
//                Log.i(this.getClass().getName(), "Click!");
//                Log.e(this.getClass().getName(), "Click!");
//
//            }
//
////                SubWriteScheduleRoute n_layout = new SubWriteScheduleRoute(getApplicationContext());
////                LinearLayout plusroute = (LinearLayout)findViewById(R.id.PlusRoute);
////                plusroute.addView(n_layout);
//        });
        return view;
    }
}
