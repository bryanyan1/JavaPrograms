import java.util.*;
import java.io.*;
public class helpcross {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("helpcross.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new PrintWriter("helpcross.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] chickens = new int[C];
        for(int i=0; i<C; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(c.nextToken());
            chickens[i] = x;
        }
        Arrays.sort(chickens);
        Cow[] cows = new Cow[N];
        for(int i=0; i<N; i++) {
            StringTokenizer d = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(d.nextToken());
            int y = Integer.parseInt(d.nextToken());
            Cow cow = new Cow(x, y);
            cows[i] = cow;
        }
        Arrays.sort(cows, (x, y) -> x.y<y.y ? -1:1);
        int count = 0;
        for(int i=0; i<C; i++) {
            for(int j=0; j<N; j++) {
                if(chickens[i]<=cows[j].y&&chickens[i]>=cows[j].x&&cows[j].x!=-1) {
                    count++;
                    cows[j].x = -1;
                    break;
                }
            }
        }
        out.println(count);
        out.close();
    }
    static class Cow {
        public int x;
        public int y;
        Cow(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
