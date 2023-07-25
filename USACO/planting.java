import java.util.*;
import java.io.*;
public class planting {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("planting.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] array = new int[N];
        Arrays.fill(array, 0);
        for(int i=0; i<N-1; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(c.nextToken());
            int y = Integer.parseInt(c.nextToken());
            array[x-1]++;
            array[y-1]++;
        }
        int max = array[0];
        for(int i=0; i<N; i++) {
            if(array[i]>max) {
                max = array[i];
            }
        }
        out.println(max+1);
        out.close();
    }
}
