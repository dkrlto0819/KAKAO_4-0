package com.example.ddang.newtrip;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment_Home fragment_home;
    Fragment_List fragment_list;
    Fragment_See fragment_see;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFrag(0);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_home) {
            setFrag(0);
            return true;
        } else if (id == R.id.menu_writing) {
            setFrag(1);
            return true;
        } else if (id == R.id.menu_list) {
            setFrag(2);
            return true;
        } else if (id == R.id.menu_logout) {
            setFrag(3);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setFrag(int n) {    //프래그먼트를 교체하는 작업을 하는 메소드를 만들었습니다
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (n) {
            case 0:
                fragment_home = new Fragment_Home();
                fragmentTransaction.replace(R.id.main_frame, fragment_home);
                fragmentTransaction.commit();
                break;
            case 1:
                fragment_see = new Fragment_See();
                fragmentTransaction.replace(R.id.main_frame, fragment_see);
                fragmentTransaction.commit();
                break;
            case 2:
                fragment_list = new Fragment_List();
                fragmentTransaction.replace(R.id.main_frame, fragment_list);

                fragmentTransaction.commit();
                break;
            case 3:
                fragment_home = new Fragment_Home();
                fragmentTransaction.replace(R.id.main_frame, fragment_home);
                fragmentTransaction.commit();
                break;
        }
    }
}
