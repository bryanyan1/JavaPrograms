import java.util.*;
import java.io.*;
public class clocktree {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("clocktree.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("clocktree.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] times = new int[N];
        st = new StringTokenizer(f.readLine());
        for(int i=0; i<N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }
        int[] nums = new int[N];
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nums[b-1]++;
        }
        int count = 0;
        for(int i=0; i<N; i++) {
            if ((nums[i] + times[i]) % 2 == 1) count++;
        }
        out.println(count);
        out.close();
    }
}
