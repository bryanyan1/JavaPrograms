import java.util.*;
import java.io.*;
public class gymnastics {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("gymnastics.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Pair> arraylist = new ArrayList<Pair>();
        for(int i=0; i<K; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            int[] ranks = new int[N];
            for(int j=0; j<N; j++) {
                ranks[j]=Integer.parseInt(c.nextToken());
            }
            for(int j=0; j<N-1; j++) {
                for(int k=j+1; k<N; k++) {
                    Pair pair = new Pair(ranks[j], ranks[k]);
                    arraylist.add(pair);
                }
            }
        }
        int count = 0;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(i!=j) {
                    Pair pair = new Pair(i, j);
                    if(numberOf(pair, arraylist)==K) count++;
                }
            }
        }
        out.println(count);
        out.close();
    }
    public static int numberOf(Pair p, ArrayList<Pair> pair) {
        int c = 0;
        for(Pair pa : pair) {
            if(pa.x==p.x&&pa.y==p.y) {
                c++;
            }
        }
        return c;
    }
    static class Pair {
        public int x;
        public int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}