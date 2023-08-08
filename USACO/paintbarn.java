import java.util.*;
import java.io.*;
public class paintbarn {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("paintbarn.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] barn = new int[1001][1001];
        int[][] sums = new int[1001][1001];
        for(int i=0; i<N; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            int x1 = Integer.parseInt(c.nextToken());
            int y1 = Integer.parseInt(c.nextToken());
            int x2 = Integer.parseInt(c.nextToken());
            int y2 = Integer.parseInt(c.nextToken());
            barn[x1][y1]++;
            barn[x1][y2]--;
            barn[x2][y1]--;
            barn[x2][y2]++;
        }
        for(int i=0; i<=1000; i++) {
            for(int j=0; j<=1000; j++) {
                sums[i][j] = barn[i][j];
                if(i==0&&j==0) continue;
                else if(i==0) sums[i][j]+=sums[i][j-1];
                else if(j==0) sums[i][j]+=sums[i-1][j];
                else sums[i][j]+=(sums[i-1][j]+sums[i][j-1]-sums[i-1][j-1]);
            }
        }
        int count = 0;
        for(int i=0; i<=1000; i++) {
            for(int j=0; j<=1000; j++) {
                if(sums[i][j]==K) count++;
            }
        }
        out.println(count);
        out.close();
    }
}
