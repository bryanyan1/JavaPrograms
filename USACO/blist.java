import java.util.*;
import java.io.*;
public class blist {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("blist.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] buckets = new int[1000];
        Arrays.fill(buckets, 0);
        for(int i=0; i<N; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            int start = Integer.parseInt(c.nextToken());
            int end = Integer.parseInt(c.nextToken());
            int number = Integer.parseInt(c.nextToken());
            for(int j=start-1; j<=end-1; j++) {
                buckets[j]+=number;
            }
        }
        int max = buckets[0];
        for(int i=0; i<1000; i++) {
            if(buckets[i]>max)
                max = buckets[i];
        }
        out.println(max);
        out.close();
    }
}
