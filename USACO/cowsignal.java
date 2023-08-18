import java.util.*;
import java.io.*;
public class cowsignal {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cowsignal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[][] initial = new char[M][N];
        for(int i=0; i<M; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            String string = c.nextToken();
            for(int j=0; j<N; j++) {
                initial[i][j] = string.charAt(j);
            }
        }
        char[][] changed = new char[K*M][K*N];
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                for(int k=K*i; k<K*i+K; k++) {
                    for(int l=K*j; l<K*j+K; l++) {
                        changed[k][l] = initial[i][j];
                    }
                }
            }
        }
        for(int i=0; i<K*M; i++) {
            for(int j=0; j<K*N; j++) {
                out.print(changed[i][j]);
            }
            out.println();
        }
        out.close();
    }
}
