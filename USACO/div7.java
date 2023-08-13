import java.io.*;
import java.util.*;
public class div7 {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("div7.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        long[] IDs = new long[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(f.readLine());
            int ID = Integer.parseInt(st.nextToken());
            IDs[i] = ID;
        }
        long[] prefix = new long[N];
        long sum = 0;
        for(int i=0; i<N; i++) {
            sum+=IDs[i];
            prefix[i] = sum%7;
        }
        int answer = 0;
        for(int i=0; i<=6; i++) {
            int left = 0;
            int right = 0;
            for(int j=0; j<N; j++) {
                if(prefix[j]==i) {
                    left = j;
                    break;
                }
            }
            for(int j=N-1; j>=0; j--) {
                if(prefix[j]==i) {
                    right = j;
                    break;
                }
            }
            if(answer<right-left) answer = right-left;
        }
        out.println(answer);
        out.close();
    }
}
