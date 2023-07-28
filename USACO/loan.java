import java.util.*;
import java.io.*;
public class loan {
    public static long N;
    public static long K;
    public static long M;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("loan.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        out.println(bsearch(1, (long)(Math.pow(10, 12))));
        out.close();
    }
    public static long bsearch(long start, long end) {
        if(start==end) return start;
        long mid = (start+end)/2;
        long sum = 0;
        sum+=N/mid;
        for(int i=1; i<K; i++) {
            sum+=Math.max((N/mid)*Math.pow(1-1/mid, i), M);
        }
        if(sum>=N) {
            return bsearch(mid+1, end);
        }
        else {
            return bsearch(start, mid-1);
        }
    }
    public static boolean isValid(long N, long K, long M, long X) {
        long G = 0;
        int count = 0;
        while(K>=0&&G<N) {
            long Y = (N-G)/X;
            if(Y < M && (N-G+M-1)/M <= K) {
                return true;
            }
        }
        if(Math.sqrt(2*N)<=count) {
            return true;
        }
    }
}
