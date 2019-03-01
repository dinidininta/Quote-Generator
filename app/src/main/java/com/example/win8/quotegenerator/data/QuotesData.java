package com.example.win8.quotegenerator.data;

import com.example.win8.quotegenerator.model.Quote;

import java.util.ArrayList;

public class QuotesData {

    public static String[][] inspirational = new String[][]{
            {"Mahatma Gandi", "“Live as if you were to die tomorrow.\nLearn as if you were to live forever.”"},
            {"Santosh Kalwar", "“I was smiling yesterday,\nI am smiling today\nand I will smile tomorrow.\nSimply because life is too short\nto cry for anything.” "},
            {"Dr. Seuss", "“You have brains in your head.\nYou have feet in your shoes.\nYou can steer yourself\nany direction you choose.\nYou're on your own.\nAnd you know what you know.\nAnd YOU are the one\nwho'll decide where to go...”"},
            {"Helen Keller", "“When one door of happiness closes,\nanother opens; but often\nwe look so long at the closed door\nthat we do not see the one\nwhich has been opened for us.”"},
            {"George Bernard Shaw", "“Life isn't about finding yourself.\nLife is about creating yourself.”"},
            {"Winston S. Churchill", "“Success is not final,\nfailure is not fatal;\nit is the courage to continue that counts.”"},
            {"Maya Angelou", "“What you're supposed to do when you\ndon't like a thing is change it.\nIf you can't change it, change the way\nyou think about it. Don't complain.”"},
            {"Audrey Hepburn", "“Nothing is impossible,\nthe word itself says 'I'm possible'!”"},
            {"Martin Luther King Jr", "“In the end,\nwe will remember not\nthe words of our enemies,\nbut the silence of our friends.”"},
            {"Paulo Coelho", "“Waiting is painful.\nForgetting is painful.\nBut not knowing which to do is the\nworst kind of suffering.”"}
    };

    public static String[][] motivational = new String[][]{
            {"Oprah Winfrey", "“Do what you have to do\nuntil you can do what you want to do.”"},
            {"C.S. Lewis", "“You are never too old to see\n another goal or to dream a new dream.”"},
            {"Walt Disney", "“All our dreams can come true\nif we have the courage to pursue them.”"},
            {"Bill Cosby", "“Decide that you want it\nmore than are afraid of it.”"},
            {"C.S. Lewis", "“Hardships often prepare ordinary\npeople for an extraordinary destiny.”"},
            {"John D. Rockefeller", "“Don't be afraid to give up\nthe good to go for the great.”"},
            {"Rapunzel, Tangled", "“Venture outside your comfort zone.\nThe rewards are worth it.”"},
            {"Seth Godin", "“If it scares you,\nit might be a good thing to try”"},
            {"Stephanie Bennet Henry", "“Life is tough my darling,\nbut so are you.”"},
            {"Steve Martin", "“Be so good,\nthey can't ignore you.”"}
    };

    public static String[][] love = new String[][]{
            {"Jess C Scott", "“When someone loves you, the way\nthey talk about you is different.\nYou feel safe and comfortable.”"},
            {"William Shakespeare", "“Love all, trust a few,\ndo wrong to none.”"},
            {"Bob Marley", "“You may not be her first,\nher last, or her only.\nShe loved before she may love again.\nBut if she loves you now,\nwhat else matters?\nShe's not perfect—you aren't either.”"},
            {"Robert Fulghum", "“We’re all a little weird.\nAnd life is a little weird.\nAnd when we find someone\nwhose weirdness is\ncompatible with ours,\nwe join up with them\nand fall into mutually satisfying\nweirdness—and call it love—true love.”"},
            {"Pablo Neruda", "“I love you as certain dark things\nare to be loved, in secret,\nbetween the shadow and the soul.”"},
            {"Paulo Coelho", "“One is loved because one is loved.\nNo reason is needed for loving.”"},
            {"Dave Matthews Band", "“A guy and a girl can be just friends,\nbut at one point or another,\nthey will fall for each other...\nMaybe temporarily,\nmaybe at the wrong time,\nmaybe too late,\nor maybe forever”"},
            {"Joan Crawford", "“Love is a fire. But whether it is going to\nwarm your hearth or burn down\nyour house, you can never tell.”"},
            {"Haruki Murakami", "“If you remember me, then I don't\ncare if everyone else forgets.”"}
    };

    public static String[][] friendship = new String[][]{
            {"Elbert Hubbard", "A friend is someone who knows\nall about you and still loves you."},
            {"Bob Marley", "The truth is, everyone is going to\nhurt you. You just got to find the ones\nworth suffering for."},
            {"Jane Austen", "There is nothing I would not do for\nthose who are really my friends.\nI have no notion of loving people \nby halves, it is not my nature."},
            {"Helen Keller", "I would rather walk with a friend\nin the dark, than alone in the light."},
            {"Sarah Dessen", "Life is an awful, ugly place\nto not have a best friend."},
            {"Aristotle", "What is a friend?\nA single soul dwelling in two bodies."},
            {"Richelle Mead", "Only a true best friend can protect you\nfrom your immortal enemies."},
            {"Abraham Lincoln", "Do I not destroy my enemies\nwhen I make them my friends?"},
            {"William Shakespeare", "Words are easy, like the wind;\nFaithful friends are hard to find."},
            {"J.D. Salinger", "I am always saying\n\"Glad to've met you\"\nto somebody I'm not at all glad I met.\nIf you want to stay alive,\nyou have to say that stuff, though."}
    };

    private static ArrayList<Quote> quoteList;

    private static void setListData(String[][] category){
        Quote quote = null;
        quoteList = new ArrayList<>();

        for(String[] q : category){
            quote = new Quote();
            quote.setPerson(q[0]);
            quote.setQuote(q[1]);

            quoteList.add(quote);
        }
    }

    public static ArrayList<Quote> getInspirationalData(){
        setListData(inspirational);

        return quoteList;
    }

    public static ArrayList<Quote> getMotivationalData(){
        setListData(motivational);

        return quoteList;
    }

    public static ArrayList<Quote> getLoveData(){
        setListData(love);

        return quoteList;
    }

    public static ArrayList<Quote> getFriendshipData(){
        setListData(friendship);

        return quoteList;
    }


}
