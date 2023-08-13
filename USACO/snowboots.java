import java.io.*;
import java.util.*;
public class snowboots {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("snowboots.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        StringTokenizer c = new StringTokenizer(f.readLine());
        int[] tiles = new int[N];
        for(int i=0; i<N; i++) {
            tiles[i] = Integer.parseInt(c.nextToken());
        }
        Boots[] boots = new Boots[B];
        for(int i=0; i<B; i++) {
            StringTokenizer as = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(as.nextToken());
            int y = Integer.parseInt(as.nextToken());
            Boots boot = new Boots(x, y);
            boots[i] = boot;
        }
        int current = 0;
        int answer = 0;
        for(int i=0; i<B; i++) {
            current = recur(boots[i], current, tiles);
            if(current>=N-1) {
                answer = i;
                break;
            }
        }
        out.println(answer);
        out.close();
    }
    public static int recur(Boots boot, int b, int[] tiles) {
        for(int i=b+boot.length; i>b; i--) {
            if(i<tiles.length&&tiles[i]<=boot.depth) {
                return recur(boot, i, tiles);
            }
        }
        return b;
    }
    static class Boots {
        public int depth;
        public int length;
        Boots(int depth, int length) {
            this.depth = depth;
            this.length = length;
        }
    }
}
