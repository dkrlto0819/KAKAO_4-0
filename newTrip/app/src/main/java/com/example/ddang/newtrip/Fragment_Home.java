package com.example.ddang.newtrip;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class Fragment_Home extends Fragment {
    int[] imgset = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5};
    View view;
    ArrayList<String> data;
    CarouselView carouselView;
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

        carouselView = view.findViewById((R.id.carouselView));
        carouselView.setPageCount(imgset.length);
        carouselView.setImageListener(imageListener);
        RecyclerView recyclerView = view.findViewById(R.id.list_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MyRecyclerAdaprter(data));
        return view;
    }
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(imgset[position]);
        }
    };


}
