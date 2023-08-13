import java.util.*;
import java.io.*;
public class square {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("square.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        StringTokenizer c = new StringTokenizer(f.readLine());
        int X1 = Integer.parseInt(c.nextToken());
        int Y1 = Integer.parseInt(c.nextToken());
        int X2 = Integer.parseInt(c.nextToken());
        int Y2 = Integer.parseInt(c.nextToken());
        ArrayList<Integer> x = new ArrayList<Integer>();
        x.add(x1); x.add(x2); x.add(X1); x.add(X2);
        ArrayList<Integer> y = new ArrayList<Integer>();
        y.add(y1); y.add(y2); y.add(Y1); y.add(Y2);
        int horizontal = Collections.max(x)-Collections.min(x);
        int vertical = Collections.max(y)-Collections.min(y);
        int max = horizontal;
        if(vertical>max) max = vertical;
        out.println((int)Math.pow(max, 2));
        out.close();
    }
}
