import java.util.*;
import java.io.*;
public class moocast {
    public static Cow[] cows;
    public static HashMap<Cow, ArrayList<Cow>> hashmap;
    public static HashMap<Cow, Boolean> visited;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("moocast.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        cows = new Cow[N];
        hashmap = new HashMap<Cow, ArrayList<Cow>>();
        visited = new HashMap<Cow, Boolean>();
        for(int i=0; i<N; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(c.nextToken());
            int y = Integer.parseInt(c.nextToken());
            int range = Integer.parseInt(c.nextToken());
            Cow cow = new Cow(x, y, range);
            cows[i] = cow;
        }
        for(int i=0; i<N; i++) {
            ArrayList<Cow> arraylist = new ArrayList<Cow>();
            for(int j=0; j<N; j++) {
                if(i!=j) {
                    if (canReach(cows[i], cows[j])) {
                        arraylist.add(cows[j]);
                    }
                }
            }
            hashmap.put(cows[i], arraylist);
        }
        ArrayList<Integer> totals = new ArrayList<Integer>();
        for(int i=0; i<N; i++) {
            dfs(cows[i]);
            if(visited.get(cows[i])==null) {
                totals.add(visited.size()+1);
            }
            else totals.add(visited.size());
            visited.clear();
        }
        out.println(Collections.max(totals));
        out.close();
    }
    public static void dfs(Cow cow) {
        for(Cow c : hashmap.get(cow)) {
            if(visited.get(c)==null) {
                visit(c);
            }
        }
        return;
    }
    public static void visit(Cow cow) {
        visited.put(cow, true);
       dfs(cow);
    }
    public static boolean canReach(Cow cow1, Cow cow2) {
        if(Math.sqrt(Math.pow(cow2.y-cow1.y, 2)+Math.pow(cow2.x-cow1.x, 2))<=cow1.range) return true;
        else return false;
    }
    public static class Cow {
        public int x;
        public int y;
        public int range;
        public Cow(int x, int y, int range) {
            this.x = x;
            this.y = y;
            this.range = range;
        }
    }
}
