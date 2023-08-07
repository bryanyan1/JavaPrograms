import java.util.*;
import java.io.*;
public class multimoo {
    public static int count = 0;
    public static int count2 = 0;
    public static int count3 = 0;
    public static int[][] asdf;
    public static int N;
    public static int[][] grid;
    public static boolean[][] visited;
    public static boolean[] visited2;
    public static ArrayList<Node> nodes;
    public static ArrayList<Integer>[] arrayList;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("multimoo.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("multimoo.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        asdf = new int[N][N];
        visited = new boolean[N][N];
        nodes = new ArrayList<Node>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(f.readLine());
            for(int j=0; j<N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ArrayList<Integer> maxes = new ArrayList<Integer>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(visited[i][j]==false) {
                    recur(i, j, grid[i][j]);
                    maxes.add(count);
                    Node node = new Node(grid[i][j], count, count2);
                    nodes.add(node);
                    count = 0;
                    count2++;
                }
            }
        }
        arrayList = new ArrayList[count2];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(arrayList[asdf[i][j]]==null) {
                    arrayList[asdf[i][j]] = new ArrayList<Integer>();
                }
                if(i==0&&j==0) {
                    arrayList[asdf[i][j]].add(asdf[i+1][j]);
                    arrayList[asdf[i][j]].add(asdf[i][j+1]);
                }
                else if(i==N-1&&j==N-1) {
                    arrayList[asdf[i][j]].add(asdf[i-1][j]);
                    arrayList[asdf[i][j]].add(asdf[i][j-1]);
                }
                else if(i==0&&j==N-1) {
                    arrayList[asdf[i][j]].add(asdf[i+1][j]);
                    arrayList[asdf[i][j]].add(asdf[i][j-1]);
                }
                else if(i==N-1&&j==0) {
                    arrayList[asdf[i][j]].add(asdf[i-1][j]);
                    arrayList[asdf[i][j]].add(asdf[i][j+1]);
                }
                else if(j==0) {
                    arrayList[asdf[i][j]].add(asdf[i+1][j]);
                    arrayList[asdf[i][j]].add(asdf[i][j+1]);
                    arrayList[asdf[i][j]].add(asdf[i-1][j]);
                }
                else if(i==0) {
                    arrayList[asdf[i][j]].add(asdf[i][j+1]);
                    arrayList[asdf[i][j]].add(asdf[i+1][j]);
                    arrayList[asdf[i][j]].add(asdf[i][j-1]);
                }
                else if(j==N-1) {
                    arrayList[asdf[i][j]].add(asdf[i][j-1]);
                    arrayList[asdf[i][j]].add(asdf[i+1][j]);
                    arrayList[asdf[i][j]].add(asdf[i-1][j]);
                }
                else if(i==N-1) {
                    arrayList[asdf[i][j]].add(asdf[i][j+1]);
                    arrayList[asdf[i][j]].add(asdf[i-1][j]);
                    arrayList[asdf[i][j]].add(asdf[i][j-1]);
                }
                else {
                    arrayList[asdf[i][j]].add(asdf[i][j+1]);
                    arrayList[asdf[i][j]].add(asdf[i+1][j]);
                    arrayList[asdf[i][j]].add(asdf[i-1][j]);
                    arrayList[asdf[i][j]].add(asdf[i][j-1]);
                }
            }
        }
        visited2 = new boolean[count2];
        ArrayList<Integer> maxx = new ArrayList<Integer>();
        for(Node node : nodes) {
            for(Node n : nodes) {
                if(arrayList[node.label].contains(n.label)) {
                    recur2(node, node.number, n.number);
                    maxx.add(count3);
                    visited2 = new boolean[count2];
                    count3 = 0;
                }
            }
        }
        out.println(Collections.max(maxes));
        out.println(Collections.max(maxx));
        out.close();
    }
    public static void recur2(Node node, int a, int b) {
        if(visited2[node.label] == true) return;
        visited2[node.label] = true;
        count3+=node.size;
        for(Node n : nodes) {
            if(arrayList[node.label].contains(n.label)&&((n.number==a)||(n.number==b))) {
                recur2(n, a, b);
            }
        }
    }
    public static void recur(int i, int j, int number) {
        if(i>=N||i<0||j>=N||j<0) return;
        if(visited[i][j]==true||grid[i][j]!=number) return;
        visited[i][j] = true;
        if(grid[i][j]==number) {
            count++;
            asdf[i][j] = count2;
        }
        recur(i+1, j, number);
        recur(i-1, j, number);
        recur(i, j+1, number);
        recur(i, j-1, number);
    }
    static class Node {
        public int number;
        public int size;
        public int label;
        Node(int number, int size, int label) {
            this.number = number;
            this.size = size;
            this.label = label;
        }
    }
}
