package com.example.ddang.newtrip;

import android.os.AsyncTask;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Get_plan_list extends AsyncTask<Void, Void, ArrayList> {
    Conn_API_title conn = new Conn_API_title();
    @Override
    protected ArrayList<String> doInBackground(Void... voids) {
        ArrayList<String> message = null;
        try{
            message = conn.get_title();
        } catch (IOException e) {
            message.add("실패");
            e.printStackTrace();
        }
        return message;
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }
    @Override
    protected void onPostExecute(ArrayList list) {
        super.onPostExecute(list);

    }

}
