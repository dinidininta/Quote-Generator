package com.example.win8.quotegenerator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Friendship extends Activity {

    ExpandableList listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    public Inspirational insp;
    public Motivational mot;
    public Love love;
    public static String group, child;
    public static boolean chosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendship);

        chosen = false;
        insp.chosen = false;
        mot.chosen = false;
        love.chosen = false;

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.listviewfriendship);

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
        listDataHeader.add("Elbert Hubbard");
        listDataHeader.add("Bob Marley");
        listDataHeader.add("Jane Austen");
        listDataHeader.add("Helen Keller");
        listDataHeader.add("Sarah Dessen");
        listDataHeader.add("Aristotle");
        listDataHeader.add("Richelle Mead");
        listDataHeader.add("Abraham Lincoln");
        listDataHeader.add("William Shakespeare");
        listDataHeader.add("J.D. Salinger");

        // Adding child data
        List<String> ElbertHubbard = new ArrayList<String>();
        ElbertHubbard.add("A friend is someone who knows\nall about you and still loves you.");

        List<String> BobMarley = new ArrayList<String>();
        BobMarley.add("The truth is, everyone is going to\nhurt you. You just got to find the ones\nworth suffering for.");

        List<String> JaneAusten = new ArrayList<String>();
        JaneAusten.add("There is nothing I would not do for\nthose who are really my friends.\nI have no notion of loving people \nby halves, it is not my nature.");

        List<String> HelenKeller = new ArrayList<String>();
        HelenKeller.add("I would rather walk with a friend\nin the dark, than alone in the light.");

        List<String> SarahDessen = new ArrayList<String>();
        SarahDessen.add("Life is an awful, ugly place\nto not have a best friend.");

        List<String> Aristotle = new ArrayList<String>();
        Aristotle.add("What is a friend?\nA single soul dwelling in two bodies.");

        List<String> RichelleMead = new ArrayList<String>();
        RichelleMead.add("Only a true best friend can protect you\nfrom your immortal enemies.");

        List<String> AbrahamLincoln = new ArrayList<String>();
        AbrahamLincoln.add("Do I not destroy my enemies\nwhen I make them my friends?");

        List<String> WilliamShakespeare = new ArrayList<String>();
        WilliamShakespeare.add("Words are easy, like the wind;\nFaithful friends are hard to find.");

        List<String> JDSalinger = new ArrayList<String>();
        JDSalinger.add("I am always saying\n\"Glad to've met you\"\nto somebody I'm not at all glad I met.\nIf you want to stay alive,\nyou have to say that stuff, though.");

        listDataChild.put(listDataHeader.get(0), ElbertHubbard); // Header, Child data
        listDataChild.put(listDataHeader.get(1), BobMarley);
        listDataChild.put(listDataHeader.get(2), JaneAusten);
        listDataChild.put(listDataHeader.get(3), HelenKeller);
        listDataChild.put(listDataHeader.get(4), SarahDessen);
        listDataChild.put(listDataHeader.get(5), Aristotle);
        listDataChild.put(listDataHeader.get(6), RichelleMead);
        listDataChild.put(listDataHeader.get(7), AbrahamLincoln);
        listDataChild.put(listDataHeader.get(8), WilliamShakespeare);
        listDataChild.put(listDataHeader.get(9), JDSalinger);
    }
}
