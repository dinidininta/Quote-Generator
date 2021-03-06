package com.example.win8.quotegenerator.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.win8.quotegenerator.adapter.CustomAdapter;
import com.example.win8.quotegenerator.R;

public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ViewPager viewPager;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        PagerAdapter adapter = new CustomAdapter(MainActivity.this);
        viewPager.setAdapter(adapter);
    }

    public void startbutton_onClick(View view){
        Intent intent = new Intent(this, CategoryActivity.class);
        startActivity(intent);
    }
}
