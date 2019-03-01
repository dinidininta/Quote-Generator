package com.example.win8.quotegenerator.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import com.example.win8.quotegenerator.adapter.ExpandableListAdapter;
import com.example.win8.quotegenerator.model.Quote;
import com.example.win8.quotegenerator.data.QuotesData;
import com.example.win8.quotegenerator.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuotesActivity extends Activity {

    private ArrayList<Quote> quoteList;
    private List<String> listHeader;
    private HashMap<String, List<String>> listChild;
    public static final String EXTRA_CATEGORY_NAME = "extra_category_name";
    public static final String EXTRA_CATEGORY_ID = "extra_category_id";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);

        ExpandableListView listView = (ExpandableListView) findViewById(R.id.expandablelistview);

        int category_id = getIntent().getIntExtra(EXTRA_CATEGORY_ID, 0);
        String category_name = getIntent().getStringExtra(EXTRA_CATEGORY_NAME);

        switch (category_id){
            case 0:
                quoteList = QuotesData.getInspirationalData();
                setActionBarTitle(category_name);
                break;
            case 1:
                quoteList = QuotesData.getFriendshipData();
                setActionBarTitle(category_name);
                break;
            case 2:
                quoteList = QuotesData.getLoveData();
                setActionBarTitle(category_name);
                break;
            case 3:
                quoteList = QuotesData.getMotivationalData();
                setActionBarTitle(category_name);
                break;
        }

        prepareListData();

        ExpandableListAdapter listAdapter = new ExpandableListAdapter(this, listHeader, listChild);

        listView.setAdapter(listAdapter);

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(QuotesActivity.this, ChooseBackgroundActivity.class);
                intent.putExtra(ChooseBackgroundActivity.EXTRA_PERSON, listHeader.get(groupPosition));
                intent.putExtra(ChooseBackgroundActivity.EXTRA_QUOTE, listChild.get(listHeader.get(groupPosition)).get(childPosition));
                startActivity(intent);
                return false;
            }
        });
    }

    private void prepareListData(){
        listHeader = new ArrayList<>();
        listChild = new HashMap<>();

        for(int i=0; i<quoteList.size(); i++){
            String person = quoteList.get(i).getPerson();
            String quote = quoteList.get(i).getQuote();
            if(!listChild.containsKey(person)) {
                listHeader.add(person);
                List<String> child = new ArrayList<>();
                child.add(quote);
                listChild.put(person, child);
            }else{
                List<String> child = listChild.get(person);
                child.add(quote);
                listChild.put(person, child);
            }
        }

    }

    private void setActionBarTitle(String title){
        getActionBar().setTitle(title);
    }
}
