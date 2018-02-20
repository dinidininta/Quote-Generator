package com.example.win8.quotegenerator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inspirational extends Activity {

    ExpandableList listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    public Motivational mot;
    public Friendship friend;
    public Love love;
    public static String group, child;
    public static boolean chosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspirational);

        chosen = false;
        mot.chosen = false;
        friend.chosen = false;
        love.chosen = false;

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.listviewinspirational);

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
        listDataHeader.add("Mahatma Gandhi");
        listDataHeader.add("Santosh Kalwar");
        listDataHeader.add("Dr. Seuss");
        listDataHeader.add("Helen Keller");
        listDataHeader.add("George Bernard Shaw");
        listDataHeader.add("Winston S. Churchill");
        listDataHeader.add("Maya Angelou");
        listDataHeader.add("Audrey Hepburn");
        listDataHeader.add("Martin Luther King Jr");
        listDataHeader.add("Paulo Coelho");

        // Adding child data
        List<String> MahatmaGandi = new ArrayList<String>();
        MahatmaGandi.add("“Live as if you were to die tomorrow.\nLearn as if you were to live forever.”");

        List<String> SantoshKalwar = new ArrayList<String>();
        SantoshKalwar.add("“I was smiling yesterday,\nI am smiling today\nand I will smile tomorrow.\nSimply because life is too short\nto cry for anything.” ");

        List<String> DrSeuss = new ArrayList<String>();
        DrSeuss.add("“You have brains in your head.\nYou have feet in your shoes.\nYou can steer yourself\nany direction you choose.\nYou're on your own.\nAnd you know what you know.\nAnd YOU are the one\nwho'll decide where to go...”");

        List<String> HelenKeller = new ArrayList<String>();
        HelenKeller.add("“When one door of happiness closes,\nanother opens; but often\nwe look so long at the closed door\nthat we do not see the one\nwhich has been opened for us.”");

        List<String> GeorgeBernardShaw = new ArrayList<String>();
        GeorgeBernardShaw.add("“Life isn't about finding yourself.\nLife is about creating yourself.” ");

        List<String> WinstonChurchill = new ArrayList<String>();
        WinstonChurchill.add("“Success is not final,\nfailure is not fatal:\nit is the courage to continue that counts.”");

        List<String> MayaAngelou = new ArrayList<String>();
        MayaAngelou.add("“What you're supposed to do when you\ndon't like a thing is change it.\nIf you can't change it, change the way\nyou think about it. Don't complain.”");

        List<String> AudreyHepburn = new ArrayList<String>();
        AudreyHepburn.add("“Nothing is impossible,\nthe word itself says 'I'm possible'!”");

        List<String> MartinLuther = new ArrayList<String>();
        MartinLuther.add("“In the end,\nwe will remember not\nthe words of our enemies,\nbut the silence of our friends.”");

        List<String> PaulCoelho = new ArrayList<String>();
        PaulCoelho.add("“Waiting is painful.\nForgetting is painful.\nBut not knowing which to do is the\nworst kind of suffering.”");

        listDataChild.put(listDataHeader.get(0), MahatmaGandi); // Header, Child data
        listDataChild.put(listDataHeader.get(1), SantoshKalwar);
        listDataChild.put(listDataHeader.get(2), DrSeuss);
        listDataChild.put(listDataHeader.get(3), HelenKeller);
        listDataChild.put(listDataHeader.get(4), GeorgeBernardShaw);
        listDataChild.put(listDataHeader.get(5), WinstonChurchill);
        listDataChild.put(listDataHeader.get(6), MayaAngelou);
        listDataChild.put(listDataHeader.get(7), AudreyHepburn);
        listDataChild.put(listDataHeader.get(8), MartinLuther);
        listDataChild.put(listDataHeader.get(9), PaulCoelho);
    }
}
