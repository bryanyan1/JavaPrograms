import java.util.*;
import java.io.*;
public class shell {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("shell.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        Swaps[] swaps = new Swaps[N];
        for(int i=0; i<N; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(c.nextToken());
            int y = Integer.parseInt(c.nextToken());
            int z = Integer.parseInt(c.nextToken());
            Swaps a = new Swaps(x, y, z);
            swaps[i]=a;
        }
        int x1 = play(1, swaps);
        int x2 = play(2, swaps);
        int x3 = play(3, swaps);
        int max = x1;
        if(x2>max) max=x2;
        if(x3>max) max = x3;
        out.println(max);
        out.close();
    }
    public static int play(int start, Swaps[] swaps) {
        int count = 0;
        for(int i=0; i<swaps.length; i++) {
            if((swaps[i]).x==start) {
                start=((swaps[i].y));
                if(swaps[i].z==start) {
                    count++;
                }
            }
            else if((swaps[i]).y==start) {
                start=(swaps[i].x);
                if(swaps[i].z ==start) {
                    count++;
                }
            }
            else {
                if((swaps[i].z==start)) {
                    count++;
                }
            }
        }
        return count;
    }
    public static class Swaps extends shell{
        public int x;
        public int y;
        public int z;
        public Swaps(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}