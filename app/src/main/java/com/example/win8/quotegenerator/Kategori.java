package com.example.win8.quotegenerator;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Kategori extends ListActivity{

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String[] values = new String[] { "Inspirational", "Friendship","Love","Motivational"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String) getListAdapter().getItem(position);
        if (item == "Inspirational"){
            Intent intent = new Intent (this, Inspirational.class);
            startActivity(intent);
        }
        else if(item == "Friendship"){
            Intent intent = new Intent(this, Friendship.class);
            startActivity(intent);
        }
        else if(item == "Love"){
            Intent intent = new Intent(this, Love.class);
            startActivity(intent);
        }
        else if(item == "Motivational"){
            Intent intent = new Intent(this, Motivational.class);
            startActivity(intent);
        }
    }
}
