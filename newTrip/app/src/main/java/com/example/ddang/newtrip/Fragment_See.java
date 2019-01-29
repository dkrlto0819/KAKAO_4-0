package com.example.ddang.newtrip;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Fragment_See extends Fragment {
    View view;
    ArrayList<String> data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Get_Route get_route = new Get_Route();
        data = new ArrayList<>();
        try {
            data = get_route.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("sadfsdaf"+data);
        view = inflater.inflate(R.layout.fragment_see, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.Title);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MyRecyclerAdaprter(data));
        return view;
    }
}
