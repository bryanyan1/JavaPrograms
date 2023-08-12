import java.util.*;
import java.io.*;
public class sleepy {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("sleepy.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        StringTokenizer c = new StringTokenizer(f.readLine());
        int[] array = new int[N];
        for(int i=0; i<N; i++) {
            array[i]=Integer.parseInt(c.nextToken());
        }
        int count = 1;
        for(int i=N-2; i>=0; i--) {
            if(array[i]<array[i+1]) {
                count++;
            }
            else
                break;
        }
        out.println(N-count);
        out.close();
    }
}