import java.util.*;
import java.io.*;
public class convention {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("convention.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arrivalTimes = new int[N];
        StringTokenizer c = new StringTokenizer(f.readLine());
        for(int i=0; i<N; i++) {
            arrivalTimes[i] = Integer.parseInt(c.nextToken());
        }
        Arrays.sort(arrivalTimes);
        int x = binarySearch(0, 1000000000, arrivalTimes, M, C);
        out.println(x);
        out.close();
    }
    public static boolean isPossible(int time, int[] arrivalTimes, int M, int C) {
        int begin = 0;
        int carts = 1;
        for(int i=1; i<arrivalTimes.length; i++) {
            if(arrivalTimes[i]-arrivalTimes[begin]>time||i-begin>C-1) {
                begin = i;
                carts++;
            }
        }
        if(carts<=M) return true;
        return false;
    }
    public static int binarySearch(int start, int end, int[] arrivalTimes, int M, int C) {
        int middle = (start+end)/2;
        if(start==end) return start;
        else if(isPossible(middle, arrivalTimes, M, C)) {
            return binarySearch(start, middle, arrivalTimes, M, C);
        }
        else {
            return binarySearch(middle+1, end, arrivalTimes, M, C);
        }
    }
}
