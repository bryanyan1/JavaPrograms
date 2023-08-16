import java.util.*;
import java.io.*;
public class shuffle {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("shuffle.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] finalOrder = new int[N];
        int[] cowIDs = new int[N];
        StringTokenizer c = new StringTokenizer(f.readLine());
        for(int i=0; i<N; i++) {
            finalOrder[i] = Integer.parseInt(c.nextToken());
        }
        StringTokenizer d = new StringTokenizer(f.readLine());
        for(int i=0; i<N; i++) {
            cowIDs[i] = Integer.parseInt(d.nextToken());
        }
        for(int i=0; i<3; i++) {
            int[] copyArray = new int[N];
            for(int j=0; j<N; j++) {
                copyArray[j] = cowIDs[finalOrder[j]-1];
            }
            for(int k=0; k<N; k++) {
               cowIDs[k] = copyArray[k];
            }
        }
        for(int i=0; i<N; i++) {
            out.println(cowIDs[i]);
        }
        out.close();
    }
}
