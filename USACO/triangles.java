import java.util.*;
import java.io.*;
public class triangles {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("triangles.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        Point[] points = new Point[N];
        HashMap<Long, Boolean> hashmap = new HashMap<Long, Boolean>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Point point = new Point(x, y);
            points[i] = point;
            hashmap.put((long) (1000000*x+y), true);
        }
        long count = 0;
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                Point p = new Point(points[i].x, points[j].y);
                Point p1 = new Point(points[j].x, points[i].y);
                boolean a = false;
                boolean b = false;
                if(hashmap.containsKey((long)(1000000*p.x+p.y))) a = true;
                if(hashmap.containsKey((long)(1000000*p1.x+p1.y))) b = true;
                if(a==true&&b==true) {
                    count+=2*(Math.abs(p.x-p1.x))*(Math.abs(p.y-p1.y));
                }
                else if(a==true||b==true) {
                    count+=(Math.abs(points[i].x-points[j].x))*(Math.abs(points[i].y-points[j].y));
                }
            }
        }
        out.println(count%1000000007);
        out.close();
    }
    static class Point {
        public int x;
        public int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
