import java.util.*;
import java.io.*;
public class herding2 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("herding.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] cows = new int[N];
        Arrays.sort(cows);
        for(int i=0; i<N; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            cows[i] = Integer.parseInt(c.nextToken());
        }
        Arrays.sort(cows);
        int j = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0; i<N; i++) {
            while(j<N-1&&cows[j+1]-cows[i]<N) {
                j++;
            }
            arr.add(j-i+1);
        }
        int min = N - Collections.max(arr);
        int max = Math.max(cows[N-1]-cows[1], cows[N-2]-cows[0])-N+2;
        out.println(min);
        out.println(max);
        out.close();
    }
}
