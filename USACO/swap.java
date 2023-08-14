import java.util.*;
import java.io.*;
public class swap {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("swap.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Reverse[] reverses = new Reverse[M];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(f.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Reverse reverse = new Reverse(start, end);
            reverses[i] = reverse;
        }
        int[] original = new int[N];
        int[] originalcopy = new int[N];
        for(int i=0; i<N; i++) {
            original[i] = i+1;
            originalcopy[i] = i+1;
        }
        ArrayList<int[]> arr = new ArrayList<int[]>();
        boolean istrue = false;
        int count = 0;
        while(istrue==false) {
            count++;
            for(Reverse r : reverses) {
                flip(r, original);
            }
            int[] copy = new int[N];
            for(int i=0; i<N; i++) {
                copy[i] = original[i];
            }
            arr.add(copy);
            boolean a = false;
            for(int i=0; i<N; i++) {
                if(originalcopy[i]!=original[i]) {
                    a = true;
                    break;
                }
            }
            if(a==false) {
                istrue = true;
            }
        }
        int num = (K-1)%count;
        for(int i : arr.get(num)) {
            out.println(i);
        }
        out.close();
    }
    public static void flip(Reverse reverse, int[] a) {
        double mid = (reverse.start+reverse.end)/2.0-1;
        for(int i=reverse.start-1; i<=mid; i++) {
            int x = a[(int)(mid+(mid-i))];
            a[(int)(mid+(mid-i))] = a[i];
            a[i] = x;
        }
    }
    static class Reverse {
        public int start;
        public int end;
        Reverse(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
