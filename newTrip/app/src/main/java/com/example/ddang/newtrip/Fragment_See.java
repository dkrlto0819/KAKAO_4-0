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
<<<<<<< Updated upstream
<<<<<<< HEAD
=======

>>>>>>> 2921993a5f8cfe29e7c1133dbbfaa9760bdd5ecb
=======
>>>>>>> Stashed changes
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Text;
<<<<<<< Updated upstream
<<<<<<< HEAD
import android.widget.Button;
=======

=======
>>>>>>> Stashed changes
import android.widget.Button;


>>>>>>> 2921993a5f8cfe29e7c1133dbbfaa9760bdd5ecb
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Fragment_See extends Fragment {
    View view;
    ArrayList<String> data;
<<<<<<< Updated upstream
<<<<<<< HEAD
=======

>>>>>>> 2921993a5f8cfe29e7c1133dbbfaa9760bdd5ecb
=======
>>>>>>> Stashed changes
    TextView shared;
    JSONParser jsonParser;
    JSONObject jsonObject;
    JSONArray jsonPop;
    TextView title;
    TextView category;
    TextView period;

<<<<<<< Updated upstream
<<<<<<< HEAD
    Button button1;
=======

    Button button1;

>>>>>>> 2921993a5f8cfe29e7c1133dbbfaa9760bdd5ecb
=======
    Button button1;

>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
<<<<<<< HEAD
=======

>>>>>>> 2921993a5f8cfe29e7c1133dbbfaa9760bdd5ecb
=======

>>>>>>> Stashed changes
        System.out.println("this is fragment_See");

        String jsonStr = get_route.string;
        System.out.println(jsonStr);

        System.out.println("sadfsdaf"+data);

        try {
            title = (TextView)view.findViewById(R.id.Title);
            shared = (TextView) view.findViewById(R.id.SharedOrNot);
            category = (TextView) view.findViewById(R.id.Category);
            period = (TextView) view.findViewById(R.id.Period);

            JSONObject jsonObj = new JSONObject(jsonStr);
            String jsonPop1 = jsonObj.get("title").toString();
            JSONArray categoryArray = (JSONArray) jsonObj.get("categories");
            for(int i = 0 ; i<categoryArray.length(); i++){
                JSONObject categoryObj = categoryArray.getJSONObject(i);
                String title = categoryObj.getString("title");
                category.setText("#"+title);
            }

//            JSONObject categoryObj = new JSONObject(categoryStr);



//            String categoryTitle = categoryObj.get("title").toString();

            //category.setText(categoryTitle);

            if(jsonObj.get("shared").toString() == "true")
                shared.setText("이 글은 choi에 의해 작성되었습니다.");
            title.setText(jsonPop1);
            period.setText("기간 : "+jsonObj.get("period")+"일");
        } catch (JSONException e) {
            jsonPop = new JSONArray();
            e.printStackTrace();
        }

        shared = (TextView)view.findViewById(R.id.SharedOrNot);
//        if(data.get(0) == "true") shared.setText("이 글은 choi 님에 의해 작성되었습니다."); ????? 나아닌데
        return view;
    }

}
