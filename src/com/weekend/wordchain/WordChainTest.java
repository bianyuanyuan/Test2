package com.weekend.wordchain;

import java.io.*;
import java.util.*;

public class WordChainTest {
    static String string = new String();//save the joined words

    public static void wordChain(List<String> list) {
        string = list.get(0);//the first word of the joined words
        int count = 0;
        for (int i = 1; i < list.size(); i++) {
            if (string.charAt(string.length() - 1) == list.get(i).charAt(0)) {
                string = string + "." + list.get(i);
                count++;
            }
        }
        if (count == list.size() - 1) {
            try {
                System.out.println(string);
                BufferedWriter out = new BufferedWriter(new FileWriter("result.txt"));
                out.write(string);//save the results
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("These words can not be joined.");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("D:\\LearnJava\\src\\com\\weekend\\wordchain\\WordList.txt"));// read the file
        List<String> list = new LinkedList<String>();//save the words
        String s;
        while ((s = in.readLine()) != null) {
            list.add(s);
        }
        Collections.sort(list);//sort
        System.out.println("WordList.txt:");
        for (String str : list) {//test
            System.out.println(str);
        }
        in.close();
        System.out.println("Judge if the words can be joined:");
        wordChain(list);//call the method
    }
}

