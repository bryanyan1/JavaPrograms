import java.util.*;
import java.io.*;
public class billboard {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("billboard.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        boolean[][] coordinates = new boolean[2000][2000];
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        for(int i=x1; i<x2; i++) {
            for(int j=y1; j<y2; j++) {
                coordinates[i+1000][j+1000]=true;
            }
        }
        StringTokenizer c = new StringTokenizer(f.readLine());
        int xx1 = Integer.parseInt(c.nextToken());
        int yy1 = Integer.parseInt(c.nextToken());
        int xx2 = Integer.parseInt(c.nextToken());
        int yy2 = Integer.parseInt(c.nextToken());
        for(int i=xx1; i<xx2; i++) {
            for(int j=yy1; j<yy2; j++) {
                coordinates[i+1000][j+1000]=true;
            }
        }
        StringTokenizer d = new StringTokenizer(f.readLine());
        int xxx1 = Integer.parseInt(d.nextToken());
        int yyy1 = Integer.parseInt(d.nextToken());
        int xxx2 = Integer.parseInt(d.nextToken());
        int yyy2 = Integer.parseInt(d.nextToken());
        for(int i=xxx1; i<xxx2; i++) {
            for(int j=yyy1; j<yyy2; j++) {
                coordinates[i+1000][j+1000]=false;
            }
        }
        int count = 0;
        for(int i=0; i<2000; i++) {
            for(int j=0; j<2000; j++) {
                if(coordinates[i][j]==true) count++;
            }
        }
        out.println(count);
        out.close();
    }
}
