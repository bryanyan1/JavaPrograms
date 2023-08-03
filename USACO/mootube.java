import java.util.*;
import java.io.*;
public class mootube {
    public static boolean[] visited;
    public static ArrayList<Pair>[] adjac;
    //public static int[][] adjacency;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("mootube.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Integer.parseInt(st.nextToken());
        //adjacency = new int[N][N];
        adjac = new ArrayList[N];
        int Q = Integer.parseInt(st.nextToken());
        //Pair[] pairs = new Pair[N];
        visited = new boolean[N];
        for(int i=0; i<N-1; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(c.nextToken());
            int b = Integer.parseInt(c.nextToken());
            int relevance = Integer.parseInt(c.nextToken());
           // Pair pair = new Pair(a, b, relevance);
            //pairs[i] = pair;
            //adjacency[a-1][b-1] = relevance;
            //adjacency[b-1][a-1] = relevance;

            if (adjac[a-1] == null) {
                adjac[a-1] = new ArrayList();
            }
            if(adjac[b-1] == null) {
                adjac[b-1] = new ArrayList();
            }
            Pair pair1 = new Pair(a-1, relevance);
            Pair pair2 = new Pair(b-1, relevance);
            adjac[a-1].add(pair2);
            adjac[b-1].add(pair1);
        }
        for(int i=0; i<Q; i++) {
            StringTokenizer d = new StringTokenizer(f.readLine());
            int k = Integer.parseInt(d.nextToken());
            int v = Integer.parseInt(d.nextToken())-1;
            recur(v, k);
            int count = -1;
            for(int j=0; j<N; j++) {
                if(visited[j]==true) count++;
            }
            out.println(count);
            for(int j=0; j<N; j++) {
                visited[j] = false;
            }
        }
        out.close();
    }
    public static void recur(int x, int K) {
        if(visited[x]==true) return;
        visited[x] = true;
            /*if(adjac[x].contains()) {
                recur(i, K);
            }
            */
            for(Pair p : adjac[x]) {
                if((p.second)>=K) {
                    recur(p.first, K);
                }
            }
    }
    static class Pair {
        public int first;
        public int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

    }
    /*
    static class Pair {
        public int a;
        public int b;
        public int relevance;
        Pair(int a, int b, int relevance) {
            this.a = a;
            this.b = b;
            this.relevance = relevance;
        }

    }
    */
}
