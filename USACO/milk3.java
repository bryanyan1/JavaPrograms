/*
ID: bryanya1
LANG: JAVA
TASK: milk3
*/
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class milk3 {
    public static int[] capacity;
    public static ArrayList<Integer> possibles = new ArrayList<Integer>();
    public static ArrayList<State> states = new ArrayList<State>();
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        capacity = new int[3];
        capacity[0] = Integer.parseInt(st.nextToken());
        capacity[1] = Integer.parseInt(st.nextToken());
        capacity[2] = Integer.parseInt(st.nextToken());
        int[] buckets = new int[3];
        buckets[0] = 0;
        buckets[1] = 0;
        buckets[2] = capacity[2];
        pour(2, 1, buckets);
        pour(2, 0, buckets);
        ArrayList<Integer> asdfg = new ArrayList<Integer>();
        for(int i=0; i<=capacity[2]; i++) {
            if(possibles.contains(i)) asdfg.add(i);
        }
        for(int i=0; i<asdfg.size(); i++) {
            if(i==asdfg.size()-1) out.print(asdfg.get(i));
            else out.print(asdfg.get(i)+" ");
        }
        out.println();
        out.close();
    }
    public static void pour(int start, int end, int[] buckets) {
        if(buckets[0]==0) {
            possibles.add(buckets[2]);
        }
        if(capacity[end]-buckets[end]>=buckets[start]) {
            buckets[end]+=buckets[start];
            buckets[start] = 0;
        }
        else {
            buckets[start]-=(capacity[end]-buckets[end]);
            buckets[end] = capacity[end];
        }
        State state = new State(buckets[0], buckets[1], buckets[2]);
        if(isIn(state)) {
            if(buckets[0]==0) {
                possibles.add(buckets[2]);
            }
            return;
        }
        State s = new State(buckets[0], buckets[1], buckets[2]);
        states.add(s);
        int[] copy = new int[3];
        for(int i=0; i<3; i++) {
            copy[i]=buckets[i];
        }
        pour(0, 1, buckets);
        for(int i=0; i<3; i++) {
            buckets[i]=copy[i];
        }
        pour(0, 2, buckets);
        for(int i=0; i<3; i++) {
            buckets[i]=copy[i];
        }
        pour(1, 0, buckets);
        for(int i=0; i<3; i++) {
            buckets[i]=copy[i];
        }
        pour(1, 2, buckets);
        for(int i=0; i<3; i++) {
            buckets[i]=copy[i];
        }
        pour(2, 0, buckets);
        for(int i=0; i<3; i++) {
            buckets[i]=copy[i];
        }
        pour(2, 1, buckets);
        for(int i=0; i<3; i++) {
            buckets[i]=copy[i];
        }
    }
    public static boolean isIn(State s) {
        for(State i : states) {
            if(s.a==i.a&&s.b==i.b&&s.c==i.c) return true;
        }
        return false;
    }
    public static class State {
        public int a;
        public int b;
        public int c;
        public State(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}