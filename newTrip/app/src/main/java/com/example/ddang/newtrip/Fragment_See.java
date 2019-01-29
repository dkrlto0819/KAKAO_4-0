package com.example.ddang.newtrip;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Text;

import android.widget.Button;


import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Fragment_See extends Fragment {
    View view;
    ArrayList<String> data;

    TextView shared;
    JSONParser jsonParser;
    JSONObject jsonObject;
    JSONArray jsonPop;
    TextView title;


    Button button1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_see, container, false);
        Get_Route get_route = new Get_Route();
        data = new ArrayList<>();

        try {
            data = get_route.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("this is fragment_See");

        String jsonStr = get_route.string;
        System.out.println(jsonStr);

        System.out.println("sadfsdaf"+data);

        try {
            JSONObject jsonObj = new JSONObject(jsonStr);
            String jsonPop1 = jsonObj.get("title").toString();
            System.out.println("TITLE:"+jsonPop1);

            title = (TextView)view.findViewById(R.id.Title);
            title.setText(jsonPop1);
        } catch (JSONException e) {
            jsonPop = new JSONArray();
            e.printStackTrace();
        }



        shared = (TextView)view.findViewById(R.id.SharedOrNot);
//        if(data.get(0) == "true") shared.setText("이 글은 choi 님에 의해 작성되었습니다.");
        return view;
    }

}
