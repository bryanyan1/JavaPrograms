package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class planting {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("planting.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] startx = new int[N];
        int[] endy = new int[N];
        int[] endx = new int[N];
        int[] starty = new int[N];
        for(int i=0; i<N; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            startx[i] = Integer.parseInt(c.nextToken());
            endy[i] = Integer.parseInt(c.nextToken());
            endx[i] = Integer.parseInt(c.nextToken());
            starty[i] = Integer.parseInt(c.nextToken());
        }
        int[] y = new int[2*N];
        for(int i=0; i<N; i++) {
            y[i]=starty[i];
        }
        for(int i=N; i<2*N; i++) {
            y[i]=endy[i-N];
        }
        Arrays.sort(y);
    }
    public static boolean isXStart(int[] a, int b) {
        for(int i : a) {
            if(i==b)
                return true;
        }
        return false;
    }
    public static boolean isYStart(int[] a, int b) {
        for(int i : a) {
            if(i==b)
                return true;
        }
        return false;
    }
    public static int max(int[] a) {
        int max = a[0];
        for(int i : a) {
            if(i>max)
                max = i;
        }
        return max;
    }
}
