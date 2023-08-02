package com.company;
import java.util.*;
import java.io.*;

public class Moo {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("moo.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moo.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        System.out.println(mooRecursion(3));
        out.println((mooRecursion(N)).charAt(N-1));
        out.close();
    }
    public static String mooRecursion(int a) {
        if(a==0)
            return "moo";
        else
            return mooRecursion(a-1) + mooo(a+2)+mooRecursion(a-1);
    }
    public static String mooo(int a) {
        String[] string = new String[a+1];
        string[0] = "m";
        for(int i=1; i<a+1; i++) {
            string[i] = "o";
        }
        return String.join("", string);
    }
}