package com.example.win8.quotegenerator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class PilihBackground extends Activity {

    public static int imgchoosen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_background);

        GridView gridView = (GridView) findViewById(R.id.grid_view);

        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                if(position==0){
                    // Sending image id to FullScreenActivity
                    Intent i = new Intent(getApplicationContext(), GenerateQuoteAtWood.class);
                    // passing array index
                    i.putExtra("id", position);
                    startActivity(i);
                }else if(position==1){
                    // Sending image id to FullScreenActivity
                    Intent i = new Intent(getApplicationContext(), GenerateQuoteAtSmoke.class);
                    // passing array index
                    i.putExtra("id", position);
                    startActivity(i);
                }else if(position==2){
                    // Sending image id to FullScreenActivity
                    Intent i = new Intent(getApplicationContext(), GenerateQuoteAtBeach.class);
                    // passing array index
                    i.putExtra("id", position);
                    startActivity(i);
                }else if(position==3){
                    // Sending image id to FullScreenActivity
                    Intent i = new Intent(getApplicationContext(), GenerateQuoteAtFlower.class);
                    // passing array index
                    i.putExtra("id", position);
                    startActivity(i);
                }
            }
        });

    }

}
