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

public class Get_Route extends AsyncTask<Void, Void, ArrayList> {

    public JSONArray json_title;
    public String string;
    @Override
    protected ArrayList<String> doInBackground(Void... voids) {
        ArrayList<String> message = null;
        try{
            message = get_route();
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
    public JSONArray call_popular() throws IOException {
        JSONArray jsonPop = null;
        URL url = new URL("http://myks790.iptime.org:8888/api/plan/1");

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


            System.out.println("planiD : 1");
            System.out.println(stringBuffer);
            string = stringBuffer.toString();
            inputStream.close();
            conn.disconnect();
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(string);
            jsonPop = (JSONArray) jsonObject.get("routes");
<<<<<<< HEAD
//            for(int i=0; i<jsonPop.size(); i++){
//                JSONObject objectInArray = (JSONObject) jsonPop.get(i);
////                json_title=(JSONArray) objectInArray.get("title");
//            }
=======
>>>>>>> f6c9f2494a8174290ce486a8bc777d9e01576ce5

            //json_title = (JSONArray) jsonObject.get("title");

        } catch (Exception e) {
            jsonPop = new JSONArray();
            e.printStackTrace();
        }

        return jsonPop;
    }

    public ArrayList<String> get_route() throws IOException {
        ArrayList<String> route = new ArrayList<>();

        JSONArray jsonArray = call_popular();

        for(Object item : jsonArray) {
            route.add(((JSONObject) item).toString());
<<<<<<< HEAD

=======
>>>>>>> f6c9f2494a8174290ce486a8bc777d9e01576ce5
        }
        System.out.println("-=========");
        System.out.println(jsonArray.toString());
        return route;
    }

}
