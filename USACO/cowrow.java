import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class cowrow {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cowrow.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowrow.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] cowID = new int[N];
        for(int i=0; i<N; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            cowID[i] = Integer.parseInt(c.nextToken());
        }
        //534545446
        ArrayList<Integer> sums = new ArrayList<Integer>();
        for(int i=0; i<N; i++) {
            int count = 1;
            int a = cowID[i];
            int b = nextDiff(i, cowID);
            for(int j=1; j<N-i; j++) {
                if(cowID[i+j]==a)
                    count++;
                else if((cowID[i+j]!=b)&&(cowID[i+j]!=a)) {
                    sums.add(count);
                    break;
                }
                if(i+j==N-1)
                    sums.add(count);
            }
        }
        out.println(Collections.max(sums));
        out.close();
    }
    public static int nextDiff(int x, int[] c) {
        for(int i=1; i<c.length-x; i++) {
            if(c[x+i]!=c[x])
                return c[x+i];
        }
        return c[x];
    }
