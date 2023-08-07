/*
ID: bryanya1
LANG: JAVA
TASK: numtri
*/
import java.util.*;
import java.io.*;
public class numtri {
    public static int[][] tree;
    public static int[][] values;
    public static ArrayList<Integer> sums = new ArrayList<Integer>();
    public static int R;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("numtri.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        R = Integer.parseInt(st.nextToken());
        tree = new int[R][R];
        values = new int[R][R];
        for(int i=0; i<R; i++) {
            for(int j=0; j<R; j++) {
                tree[i][j]=-1;
            }
        }
        for(int i=0; i<R; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            for(int j=0; j<=i; j++) {
                tree[i][j]=Integer.parseInt(c.nextToken());;
            }
        }
        for(int j=0; j<R; j++) {
            values[R-1][j] = tree[R-1][j];
        }
        for(int i=R-2; i>=0; i--) {
            for(int j=0; j<=i; j++) {
                values[i][j] = tree[i][j]+Math.max(values[i+1][j], values[i+1][j+1]);
            }
        }
        out.println(values[0][0]);
        out.close();
    }
}
