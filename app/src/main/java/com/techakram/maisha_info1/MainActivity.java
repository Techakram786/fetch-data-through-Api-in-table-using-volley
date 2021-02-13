package com.techakram.maisha_info1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Showdetail details=new Showdetail();
        // FragmentManager fm= getSupportFragmentManager();
        // FragmentTransaction ft= fm.beginTransaction();
        FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main,details);
        ft.commit();
    }
}