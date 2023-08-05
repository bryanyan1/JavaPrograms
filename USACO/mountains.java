import java.util.*;
import java.io.*;
public class mountains {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("mountains.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        Mountain[] mountains = new Mountain[N];
        ArrayList<Mountain> mountainArrayList = new ArrayList<Mountain>();
        Bases[] bases = new Bases[N];
        for(int i=0; i<N; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(c.nextToken());
            int y = Integer.parseInt(c.nextToken());
            Mountain m = new Mountain(x, y);
            mountains[i]=m;
            Bases base = new Bases(m);
            bases[i]=base;
            mountainArrayList.add(m);
        }
        Arrays.sort(bases, (m1, m2)->m1.start<m2.start || m1.start==m2.start&&m1.end>m2.end? -1: 1);
        int currentmax = bases[0].end;
        int count = 1;
        for(int i=1; i<N; i++) {
            if(bases[i].end>currentmax) {
                currentmax = bases[i].end;
                count++;
            }
        }
        out.println(count);
        out.close();
    }
    public static class Bases {
        public int start;
        public int end;
        public Bases(Mountain mountain) {
            start = mountain.x-mountain.y;
            end = mountain.x+mountain.y;
        }
    }
    public static class Mountain {
        public int x;
        public int y;
        public Mountain(int x, int y) {
           this.x = x;
           this.y = y;
        }
    }
}
