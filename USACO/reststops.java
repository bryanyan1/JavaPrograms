import java.util.*;
import java.io.*;
public class reststops {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("reststops.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int L = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long rf = Integer.parseInt(st.nextToken());
        long rb = Integer.parseInt(st.nextToken());
        RestStop[] reststops = new RestStop[N];
        for(int i=0; i<N; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            long position = Integer.parseInt(c.nextToken());
            long tastiness = Integer.parseInt(c.nextToken());
            RestStop reststop = new RestStop(position, tastiness);
            reststops[i] = reststop;
        }
        Arrays.sort(reststops, (m1, m2) -> m1.position<m2.position ? -1:1);
        long max = reststops[N-1].tastiness;
        for(int i=N-1; i>=0; i--) {
            if(reststops[i].tastiness>=max) {
                max = reststops[i].tastiness;
                reststops[i].willEat = true;
            }
        }
        long currentLocation = 0;
        long maxTasty = 0;
        for(int i=0; i<N; i++) {
            if(reststops[i].willEat) {
                maxTasty+=reststops[i].tastiness*(reststops[i].position-currentLocation)*(rf-rb);
                currentLocation = reststops[i].position;
            }
        }
        out.println(maxTasty);
        out.close();
    }
    static class RestStop {
        public long position;
        public long tastiness;
        public boolean willEat = false;
        RestStop(long position, long tastiness) {
            this.position = position;
            this.tastiness = tastiness;
        }
    }
}
