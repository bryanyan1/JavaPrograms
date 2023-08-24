import java.util.*;
import java.io.*;
public class maxcross {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("maxcross.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] broken = new int[B];
        for(int i=0; i<B; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            broken[i] = Integer.parseInt(c.nextToken());
        }
        Arrays.sort(broken);
        int[] x = new int[N];
        for(int i=0; i<B; i++) {
            x[broken[i]-1] = 1;
        }
        int[] psum = new int[N];
        psum[0] = x[0];
        for(int i=1; i<N; i++) {
            psum[i] = psum[i-1]+x[i-1];
        }
        ArrayList<Integer> maxes = new ArrayList<Integer>();
        for(int i=K-1; i<N; i++) {
            maxes.add(psum[i]-psum[i-K+1]);
        }
        out.println(Collections.min(maxes));
        out.close();
    }
}
