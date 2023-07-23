import java.util.*;
import java.io.*;
public class reduce {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("field.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("field.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Cow> cows = new ArrayList<Cow>();
        int minx = 40000;
        int maxx = 1;
        int miny = 40000;
        int maxy = 1;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Cow cow = new Cow(x, y);
            cows.add(cow);
            if(x<minx) minx = x;
            if(x>maxx) maxx = x;
            if(y<miny) miny = y;
            if(y>maxy) maxy = y;
        }

    }
    public static int maxX(ArrayList<Cow> cows) {
        int max = 1;
        for(Cow c : cows) {
            if(c.x>max) max = c.x;
        }
        return max;
    }
    public static int maxY(ArrayList<Cow> cows) {
        int max = 1;
        for(Cow c : cows) {
            if(c.y>max) max = c.y;
        }
        return max;
    }
    public static int minX(ArrayList<Cow> cows) {
        int min = 40000;
        for(Cow c : cows) {
            if(c.x<min) min = c.x;
        }
        return min;
    }
    public static int minY(ArrayList<Cow> cows) {
        int min = 40000;
        for(Cow c : cows) {
            if(c.y<min) min = c.y;
        }
        return min;
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
