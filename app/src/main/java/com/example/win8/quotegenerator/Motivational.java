package com.example.win8.quotegenerator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Motivational extends Activity {

    ExpandableList listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    public Inspirational insp;
    public Friendship friend;
    public Love love;
    public static String group, child;
    public static boolean chosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivational);

        chosen = false;
        insp.chosen = false;
        friend.chosen = false;
        love.chosen = false;

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.listviewmotivational);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableList(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                chosen = true;
                group = listDataHeader.get(groupPosition);
                child = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);

                Intent intent = new Intent(getApplicationContext(), PilihBackground.class);
                startActivity(intent);
//
                return false;
            }
        });
    }

    /*
    * Preparing the list data
    */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding header data
        listDataHeader.add("Oprah Winfrey");
        listDataHeader.add("C.S. Lewis");
        listDataHeader.add("Walt Disney");
        listDataHeader.add("Bill Cosby");
        listDataHeader.add("C.S. Lewis");
        listDataHeader.add("John D. Rockefeller");
        listDataHeader.add("Rapunzel, Tangled");
        listDataHeader.add("Seth Godin");
        listDataHeader.add("Stephanie Bennet Henry");
        listDataHeader.add("Steve Martin");

        // Adding child data
        List<String> OprahWinfrey = new ArrayList<String>();
        OprahWinfrey.add("“Do what you have to do\nuntil you can do what you want to do.”");

        List<String> CSLewis = new ArrayList<String>();
        CSLewis.add("“You are never too old to see\n another goal or to dream a new dream.” ");

        List<String> WaltDisney = new ArrayList<String>();
        WaltDisney.add("“All our dreams can come true\nif we have the courage to pursue them.”");

        List<String> BillCosby = new ArrayList<String>();
        BillCosby.add("“Decide that you want it\nmore than are afraid of it.”");

        List<String> CSLewis2 = new ArrayList<String>();
        CSLewis2.add("“Hardships often prepare ordinary\npeople for an extraordinary destiny.” ");

        List<String> JohnDRockefeller = new ArrayList<String>();
        JohnDRockefeller.add("“Don't be afraid to give up\nthe good to go for the great.”");

        List<String> RapunzelTangled = new ArrayList<String>();
        RapunzelTangled.add("“Venture outside your comfort zone.\nThe rewards are worth it.”");

        List<String> SethGodin = new ArrayList<String>();
        SethGodin.add("“If it scares you,\nit might be a good thing to try”");

        List<String> StephanieBennetHenry = new ArrayList<String>();
        StephanieBennetHenry.add("“Life is tough my darling,\nbut so are you.”");

        List<String> SteveMartin = new ArrayList<String>();
        SteveMartin.add("“Be so good,\nthey can't ignore you.”");

        listDataChild.put(listDataHeader.get(0), OprahWinfrey); // Header, Child data
        listDataChild.put(listDataHeader.get(1), CSLewis);
        listDataChild.put(listDataHeader.get(2), WaltDisney);
        listDataChild.put(listDataHeader.get(3), BillCosby);
        listDataChild.put(listDataHeader.get(4), CSLewis2);
        listDataChild.put(listDataHeader.get(5), JohnDRockefeller);
        listDataChild.put(listDataHeader.get(6), RapunzelTangled);
        listDataChild.put(listDataHeader.get(7), SethGodin);
        listDataChild.put(listDataHeader.get(8), StephanieBennetHenry);
        listDataChild.put(listDataHeader.get(9), SteveMartin);
    }

}
