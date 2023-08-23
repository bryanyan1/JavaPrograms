package com.company;

import java.io.*;
import java.util.*;

public class unlock2 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("unlock2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("unlock2.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());
        int N3 = Integer.parseInt(st.nextToken());
        int[][] array = new int[27][27];
        for(int i=0; i<N1; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(c.nextToken())+9;
            int y = Integer.parseInt(c.nextToken())+9;
            array[x][y] = 1;
        }
        for(int i=0; i<N2; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(c.nextToken())+9;
            int y = Integer.parseInt(c.nextToken())+9;
            array[x][y] = 2;
        }
        for(int i=0; i<N3; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(c.nextToken())+9;
            int y = Integer.parseInt(c.nextToken())+9;
            array[x][y] = 3;
        }
        //System.out.println(Arrays.deepToString(array).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));

    }
    public static boolean isValidMove(int[] a,int N1,int N2,int N3) {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for(int x : a) {
            if(x==1)
                count1++;
            else if(x==2)
                count2++;
            else if(x==3)
                count3++;
        }
        if(count1!=N1||count2!=N2||count3!=N3)
            return false;
        else
            return true;
    }
    public static class SolidSquare {
        public int x;
        public int y;
    }
    public static class SolidObject {
        public int SolidObject() {

        }
        public ArrayList<SolidSquare> SolidSquare;
        public void move(int direction) {
            //direction: 0: right 1: up, 2: left, 3: down
            if(direction ==0) {
                for(SolidSquare sq : SolidSquare)
                    sq.x +=1;
            }
            if(direction ==1) {
                for(SolidSquare sq : SolidSquare)
                    sq.y +=1;
            }
            if(direction ==2) {
                for(SolidSquare sq : SolidSquare)
                    sq.x -=1;
            }
            if(direction ==3) {
                for(SolidSquare sq : SolidSquare)
                    sq.y -=1;
            }
        }
    }
    public static class Node {
        public int Data;
        public ArrayList<Node> Children;

        public Node(int data) {
            Children = new ArrayList<Node>();
            Data = data;
        }
        public void AddChild(Node node) {
            Children.add(node);
        }

        public ArrayList<Node> bfsSearch() {
            ArrayList<Node> rslt = new ArrayList<Node>();
            Queue<Node> queue = new LinkedList<Node>();

            queue.add(this);
            while(!queue.isEmpty()) {
                Node node = queue.remove();
                rslt.add(node);
                for(Node child : node.Children) {
                    queue.add(child);
                }
            }

            return rslt;
        }
    }
}