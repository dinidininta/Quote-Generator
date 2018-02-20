package com.example.win8.quotegenerator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Love extends Activity {

    ExpandableList listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    public Inspirational insp;
    public Motivational mot;
    public Friendship friend;
    public static String group, child;
    public static boolean chosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love);

        chosen = false;
        insp.chosen = false;
        mot.chosen = false;
        friend.chosen = false;

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.listviewlove);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableList(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                chosen = true;
                group = listDataHeader.get(groupPosition);
                child = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
//
                Intent intent = new Intent(getApplicationContext(), PilihBackground.class);
                startActivity(intent);
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
        listDataHeader.add("Jess C Scott");
        listDataHeader.add("William Shakespeare");
        listDataHeader.add("Bob Marley");
        listDataHeader.add("Robert Fulghum");
        listDataHeader.add("Pablo Neruda");
        listDataHeader.add("Paulo Coelho");
        listDataHeader.add("Dave Matthews Band");
        listDataHeader.add("Joan Crawford");
        listDataHeader.add("Haruki Murakami");

        // Adding child data
        List<String> JessCScott = new ArrayList<String>();
        JessCScott.add("“When someone loves you, the way\nthey talk about you is different.\nYou feel safe and comfortable.”");

        List<String> WilliamShakespeare = new ArrayList<String>();
        WilliamShakespeare.add("“Love all, trust a few,\ndo wrong to none.”");

        List<String> BobMarley = new ArrayList<String>();
        BobMarley.add("“You may not be her first,\nher last, or her only.\nShe loved before she may love again.\nBut if she loves you now,\nwhat else matters?\nShe's not perfect—you aren't either.”");

        List<String> RobertFulghum = new ArrayList<String>();
        RobertFulghum.add("“We’re all a little weird.\nAnd life is a little weird.\nAnd when we find someone\nwhose weirdness is\ncompatible with ours,\nwe join up with them\nand fall into mutually satisfying\nweirdness—and call it love—true love.”");

        List<String> PabloNeruda = new ArrayList<String>();
        PabloNeruda.add("“I love you as certain dark things\nare to be loved, in secret,\nbetween the shadow and the soul.” ");

        List<String> PauloCoelho = new ArrayList<String>();
        PauloCoelho.add("“One is loved because one is loved.\nNo reason is needed for loving.”");

        List<String> DaveMatthewsBand = new ArrayList<String>();
        DaveMatthewsBand.add("“A guy and a girl can be just friends,\nbut at one point or another,\nthey will fall for each other...\nMaybe temporarily,\nmaybe at the wrong time,\nmaybe too late,\nor maybe forever” ");

        List<String> JoanCrawford = new ArrayList<String>();
        JoanCrawford.add("“Love is a fire. But whether it is going to\nwarm your hearth or burn down\nyour house, you can never tell.” ");

        List<String> HarukiMurakami = new ArrayList<String>();
        HarukiMurakami.add("“If you remember me, then I don't\ncare if everyone else forgets.”");

        listDataChild.put(listDataHeader.get(0), JessCScott); // Header, Child data
        listDataChild.put(listDataHeader.get(1), WilliamShakespeare);
        listDataChild.put(listDataHeader.get(2), BobMarley);
        listDataChild.put(listDataHeader.get(3), RobertFulghum);
        listDataChild.put(listDataHeader.get(4), PabloNeruda);
        listDataChild.put(listDataHeader.get(5), PauloCoelho);
        listDataChild.put(listDataHeader.get(6), DaveMatthewsBand);
        listDataChild.put(listDataHeader.get(7), JoanCrawford);
        listDataChild.put(listDataHeader.get(8), HarukiMurakami);
    }
}
