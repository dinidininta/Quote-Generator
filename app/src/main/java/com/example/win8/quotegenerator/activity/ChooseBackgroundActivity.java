package com.example.win8.quotegenerator.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.win8.quotegenerator.adapter.ImageAdapter;
import com.example.win8.quotegenerator.R;

public class ChooseBackgroundActivity extends Activity {

    public static final String EXTRA_QUOTE = "extra_quote";
    public static final String EXTRA_PERSON = "extra_person";
    private ImageAdapter imageAdapter;
    private String person, quote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_background);

        GridView gridView = (GridView) findViewById(R.id.grid_view);

        // Instance of ImageAdapter Class
        imageAdapter = new ImageAdapter(this);
        gridView.setAdapter(imageAdapter);

        person = getIntent().getStringExtra(EXTRA_PERSON);
        quote = getIntent().getStringExtra(EXTRA_QUOTE);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = new Intent(ChooseBackgroundActivity.this, GenerateImageActivity.class);
                // passing array index
                intent.putExtra(GenerateImageActivity.EXTRA_IMG_ID, imageAdapter.getItemAsInt(position));
                intent.putExtra(GenerateImageActivity.EXTRA_PERSON, person);
                intent.putExtra(GenerateImageActivity.EXTRA_QUOTE, quote);
                startActivity(intent);
            }
        });

    }

}
