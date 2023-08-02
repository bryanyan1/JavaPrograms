import java.util.*;
import java.io.*;
public class milkvisits {
    public static int N;
    public static boolean[][] connections;
    public static boolean[] isVisited;
    public static boolean foundit = false;
    public static ArrayList<Integer> arraylist = new ArrayList<Integer>();
    public static ArrayList<Integer> arraylist2 = new ArrayList<Integer>();
    public static HashMap<Integer, Integer>  hashmap = new HashMap<Integer, Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringTokenizer c = new StringTokenizer(f.readLine());
        String string = c.nextToken();
        connections = new boolean[N][N];
        isVisited = new boolean[N];
        for(int i=0; i<N-1; i++) {
            StringTokenizer d = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(d.nextToken());
            int y = Integer.parseInt(d.nextToken());
            connections[x-1][y-1] = true;
            connections[y-1][x-1] = true;
        }
        Farmer[] farmers = new Farmer[M];
        for(int i=0; i<M; i++) {
            StringTokenizer e = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(e.nextToken());
            int b = Integer.parseInt(e.nextToken());
            String cowType = e.nextToken();
            Farmer farmer = new Farmer(a, b, cowType);
            farmers[i] = farmer;
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0; i<M; i++) {
            recur(farmers[i].a, farmers[i].b);
            boolean isHappy = false;
            for(int j: arraylist2) {
                if((Character.toString(string.charAt(j-1))).equals(farmers[i].cowType)) {
                    isHappy = true;
                }
            }
            arraylist.clear();
            arraylist2.clear();
            foundit = false;
            if(isHappy==true) arr.add(1);
            else arr.add(0);
            Arrays.fill(isVisited, false);
        }
        for(int i=0; i<arr.size(); i++) {
            if(i!=arr.size()-1) {
                out.print(arr.get(i));
            }
            else out.println(arr.get(i));
        }
        out.close();
    }
    public static void recur(int start, int end) {
        isVisited[start-1] = true;
        arraylist.add(start);
        if(start==end) {
            if(foundit==false) {
                for (int i = 0; i < arraylist.size(); i++) {
                    arraylist2.add(arraylist.get(i));
                }
            }
            foundit = true;
            return;
        }
        ArrayList<Integer> copy = new ArrayList<Integer>();
        for(int i=0; i<arraylist.size(); i++) {
            copy.add(arraylist.get(i));
        }
        for(int j=0; j<N; j++) {
            if(connections[start-1][j]==true&&isVisited[j]==false) {
                recur(j+1, end);
            }
            arraylist.clear();
            for(int i=0; i<copy.size(); i++) {
                arraylist.add(copy.get(i));
            }
        }
    }
    static class Farmer {
        public int a;
        public int b;
        public String cowType;
        Farmer(int a, int b, String cowType) {
            this.a = a;
            this.b = b;
            this.cowType = cowType;
        }
    }
}
