import java.io.*;
import java.util.*;
public class cowntagion {
    public static ArrayList<Integer>[] adj;
    public static boolean[] visited;
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(f.readLine());
        adj = new ArrayList[N];
        visited = new boolean[N];
        Arrays.fill(visited, false);
        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(adj[a-1]==null) {
                adj[a-1] = new ArrayList<Integer>();
            }
            if(adj[b-1]==null) {
                adj[b-1] = new ArrayList<Integer>();
            }
            adj[a-1].add(b);
            adj[b-1].add(a);
        }
        recur(1);
        Arrays.fill(visited, false);
        System.out.println(count-1);
    }
    public static void recur(int n) {
        if(visited[n-1]==true) {
            return;
        }
        else {
            int temp = 0;
            visited[n-1] = true;
            for(int i : adj[n-1]) {
                temp++;
                recur(i);
            }
            int c = 0;
            while(Math.pow(2, c)<temp) {
                c++;
            }
            count+=(c+1);
        }
    }
}
