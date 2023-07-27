import java.util.*;
import java.io.*;
public class lemonade {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("lemonade.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] cows = new int[N];
        st = new StringTokenizer(f.readLine());
        for(int i=0; i<N; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }
        //400 7 2 2 1
        Arrays.sort(cows);
        boolean hasprint = false;
        for(int i=0; i<N; i++) {
            if(i>cows[N-i-1]) {
                out.println(i);
                hasprint = true;
                break;
            }
        }
        if(hasprint == false) {
            out.println(N);
        }
        out.close();
    }
}
