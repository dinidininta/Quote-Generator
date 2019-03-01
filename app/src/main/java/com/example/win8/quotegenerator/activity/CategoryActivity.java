package com.example.win8.quotegenerator.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class CategoryActivity extends ListActivity{

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String[] values = new String[] { "Inspirational", "Friendship","Love","Motivational"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        String category_name = (String) getListAdapter().getItem(position);
        Intent intent = new Intent(this, QuotesActivity.class);
        intent.putExtra(QuotesActivity.EXTRA_CATEGORY_ID, position);
        intent.putExtra(QuotesActivity.EXTRA_CATEGORY_NAME, category_name);
        startActivity(intent);
    }
}
