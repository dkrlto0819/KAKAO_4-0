package com.example.ddang.newtrip;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class Fragment_Home extends Fragment {
    View view;
    ArrayList<String> data;
//    CarouselView carouselView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Get_plan_list get_plan_list = new Get_plan_list();
        data = new ArrayList<>();
        try {
            data = get_plan_list.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        view = inflater.inflate(R.layout.fragment_home, container, false);

//        carouselView = view.findViewById((R.id.carouselView));
//        carouselView.setPageCount(imgset.length);
//        carouselView.setImageListener(imageListener);
        RecyclerView imgView = view.findViewById(R.id.img_View);
        imgView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
        RecyclerView recyclerView = view.findViewById(R.id.list_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.setAdapter(new MyRecyclerAdaprter(data));
        imgView.setAdapter(new img_View(data));
        return view;
    }
//    ImageListener imageListener = new ImageListener() {
//        @Override
//        public void setImageForPosition(int position, ImageView imageView) {
//            imageView.setImageResource(imgset[position]);
//        }
//    };


}
