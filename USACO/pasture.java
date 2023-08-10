import java.util.*;
import java.io.*;
public class pasture {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(f.readLine());
        Cow[] cows = new Cow[N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Cow cow = new Cow(x, y);
            cows[i] = cow;
        }
        Arrays.sort(cows, (x1, x2) -> x1.x<x2.x ? -1:1);
        int count = 0;
        for(int i=0; i<N-1; i++) {
            for (int j=i+1; j<N; j++) {
                for(int k=i+1; k<j; k++) {
                    if((cows[i].y<cows[k].y&&cows[j].y>cows[k].y)||(cows[i].y>cows[k].y&&cows[j].y<cows[k].y)) {
                        count++;
                    }
                }
            }
        }
        System.out.println((int)Math.pow(2, N) -count-1);
    }
    static class Cow {
        int x;
        int y;
        Cow(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
