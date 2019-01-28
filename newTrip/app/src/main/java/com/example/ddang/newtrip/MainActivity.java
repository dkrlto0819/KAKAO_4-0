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

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment_Home fragment_home;
    Fragment_Write fragment_write;
    PlanListFragment planListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setFrag(0);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_home) {
            setFrag(0);
            return true;
        }else if (id == R.id.menu_writing) {
            setFrag(1);
            return true;
        }else if (id == R.id.menu_list) {
            setFrag(2);
            return true;
        }else if (id == R.id.menu_logout) {
            setFrag(3);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setFrag(int n){    //프래그먼트를 교체하는 작업을 하는 메소드를 만들었습니다
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (n){
            case 0:
                fragment_home=new Fragment_Home();
                fragmentTransaction.replace(R.id.main_frame, fragment_home);
                fragmentTransaction.commit();
                break;
            case 1:
                fragment_write=new Fragment_Write();
                fragmentTransaction.replace(R.id.main_frame, fragment_write);
                fragmentTransaction.commit();
                break;
            case 2:
                planListFragment=new PlanListFragment();
                fragmentTransaction.replace(R.id.main_frame, planListFragment);
                fragmentTransaction.commit();
                break;
            case 3:
                fragment_home=new Fragment_Home();
                fragmentTransaction.replace(R.id.main_frame, fragment_home);
                fragmentTransaction.commit();
                break;
        }
    }

}
