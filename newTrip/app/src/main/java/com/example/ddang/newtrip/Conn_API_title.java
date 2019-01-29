package com.example.ddang.newtrip;

import android.graphics.Bitmap;

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

public class Conn_API_title {
    public JSONArray call_popular() throws IOException {
        JSONArray jsonPop = null;
        URL url = new URL("http://myks790.iptime.org:8888/api/plan/list?classification=popularity&size=25&sort=id%2Cdesc");

        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream inputStream = new BufferedInputStream(conn.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuffer stringBuffer = new StringBuffer();

            while((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
                stringBuffer.append(System.lineSeparator());
            }


            System.out.println(stringBuffer);
            String string = stringBuffer.toString();
            inputStream.close();
            conn.disconnect();
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(string);
            jsonPop = (JSONArray) jsonObject.get("content");


        } catch (Exception e) {
            jsonPop = new JSONArray();
            e.printStackTrace();
        }

        return jsonPop;
    }
    public ArrayList<String> get_title() throws IOException {
        ArrayList<String> title_list = new ArrayList<>();

        JSONArray jsonArray = call_popular();
        for(Object item : jsonArray) {
            title_list.add(((JSONObject) item).get("title").toString());
        }
        System.out.println(jsonArray.toString());
        return title_list;
    }
}
