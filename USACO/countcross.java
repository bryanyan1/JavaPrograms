import java.util.*;
import java.io.*;
public class countcross {
    public static boolean[][] grid;
    public static boolean[][] visited;
    public static Road[] roads;
    public static int N;
    public static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("countcross.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        roads = new Road[R];
        grid = new boolean[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<R; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            int r1 = Integer.parseInt(c.nextToken());
            int c1 = Integer.parseInt(c.nextToken());
            int r2 = Integer.parseInt(c.nextToken());
            int c2 = Integer.parseInt(c.nextToken());
            Road road = new Road(r1, c1, r2, c2);
            roads[i] = road;
        }
        Cow[] cows = new Cow[K];
        for(int i=0; i<K; i++) {
            StringTokenizer d = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(d.nextToken());
            int y = Integer.parseInt(d.nextToken());
            Cow cow = new Cow(x-1, y-1);
            cows[i] = cow;
            grid[x-1][y-1] = true;
        }
        count = 0;
        int bigcount = 0;
        for(Cow coww : cows) {
            recur(coww.x, coww.y, coww.x, coww.y);
            bigcount+=K-count;
            count = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    visited[i][j] = false;
                }
            }
        }
        out.println(bigcount/2);
        out.close();
    }
    public static void recur(int x, int y, int x2, int y2) {
        if(x2>=N||y2>=N||x2<0||y2<0) return;
        if(visited[x2][y2]) return;
        boolean istrue = false;
        for(Road r : roads) {
            if((r.r1-1==x&&r.c1-1==y&&r.r2-1==x2&&r.c2-1==y2)||(r.r1-1==x2&&r.c1-1==y2&&r.r2-1==x&&r.c2-1==y)) {
                istrue = true;
                break;
            }
        }
        if(istrue) return;
        if(grid[x2][y2]==true) count++;
        visited[x2][y2]=true;
        recur(x2, y2, x2+1, y2);
        recur(x2, y2, x2, y2+1);
        recur(x2, y2, x2-1, y2);
        recur(x2, y2, x2, y2-1);
    }
    static class Cow {
        public int x;
        public int y;
        Cow(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Road {
        public int r1;
        public int c1;
        public int r2;
        public int c2;
        Road(int r1, int c1, int r2, int c2) {
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
        }
    }
}
