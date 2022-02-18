package com.company;

import java.util.ArrayList;

public class WordDuoList {
    private ArrayList<WordDuo> allDuos;

    public WordDuoList(String[] words){
        allDuos = new ArrayList<WordDuo>();
        for (int i = 0; i < words.length; i++){
            for (int j = i+1; j < words.length; j++){
                allDuos.add(new WordDuo(words[i], words[j]));
            }
        }


    }
    public String toString(){
        String s = "";
        for (WordDuo wd: allDuos){
            s += "("+wd.getFirst() + ", " + wd.getSecond() + ")\n";
        }
        return s;
    }

    public int numMatches(){
        int counter = 0;
        for (int i = 0; i < allDuos.size(); i++){
            WordDuo x = allDuos.get(i);
            if (x.getFirst().equals(x.getSecond())){
                counter++;
            }
        }
        return counter;
    }

    public void moveMatchesToTop(){
        for (int i = 0; i < allDuos.size(); i++){
            WordDuo x = allDuos.get(i);
            if (x.getFirst().equals(x.getSecond())){
                allDuos.remove(i);
                allDuos.add(0, x);
            }
        }
    }

    public static void main(String[] args){
        String [] stuff = {"to","be","or","not","to","be"};
        WordDuoList wdl = new WordDuoList(stuff);
        System.out.println(wdl);
        System.out.println(wdl.numMatches());
        wdl.moveMatchesToTop();
        System.out.println(wdl);

        String [] stuff2 = {"one","fish","two","fish","red","fish","blue","fish"};
        WordDuoList wdl2 = new WordDuoList(stuff2);
        System.out.println(wdl2);
        System.out.println(wdl2.numMatches());
        wdl2.moveMatchesToTop();
        System.out.println(wdl2);

        String [] stuff3 = {"call","me","ishmael"};
        WordDuoList wdl3 = new WordDuoList(stuff3);
        System.out.println(wdl3);
        System.out.println(wdl3.numMatches());
        wdl3.moveMatchesToTop();
        System.out.println(wdl3);
    }
}