import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class guess {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("guess.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("guess.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        String[][] cha = new String[N][100];
        for(int i=0; i<N; i++) {
            for(int j=0; j<100; j++) {
                cha[i][j]="false";
            }
        }
        for(int i=0; i<N; i++) {
            int count = 0;
            StringTokenizer c = new StringTokenizer(f.readLine());
            String a = c.nextToken();
            int K = Integer.parseInt(c.nextToken());
            for(int j=0; j<K; j++) {
                cha[i][count] = c.nextToken();
                count++;
            }
        }
        ArrayList<Integer> arraylist = new ArrayList<Integer>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(j!=i) {
                    int count=0;
                    for(int k=0; k<100; k++) {
                        if(cha[i][k].equals("false")) break;
                        for(int l=0; l<100; l++) {
                            if(cha[i][k].equals(cha[j][l])) {
                                count++;
                            }
                        }
                    }
                    arraylist.add(count);
                }
            }
        }
        out.println(Collections.max(arraylist)+1);
        out.close();
    }
}
