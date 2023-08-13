/*
ID: bryanya1
LANG: JAVA
PROG: subset
*/
import java.util.*;
import java.io.*;

public class subset {
    //public static long[][] arr;
    public static long[] rslt;
    public static void main(String[] args) throws IOException {
       BufferedReader f = new BufferedReader(new FileReader("subset.in"));
       PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
       StringTokenizer st = new StringTokenizer(f.readLine());
       int N = Integer.parseInt(st.nextToken());
       //arr = new long[N*(N+1)/4+1][N+1];
       rslt = new long[N*(N+1)/2+1];
       // out.println(dp(N * (N + 1) / 4) / 2);
        dp(N);
        long finalRslt = N*(N+1)/2 % 2 == 0 ? rslt[N*(N+1)/4]/2 : 0;
        out.println(finalRslt);
        out.close();
    }
    /*
    public static long dp(int a,int b) {
        if(a<0||b<0) return 0;
        else if(arr[(int)a][(int)b]!=-1) return arr[(int)a][(int)b];
        else if(a==0&&b==0) return 1;
        else return dp(a, b-1) + dp(a-b, b-1);
    }
    */

    public static void dp(int N){
        rslt[0] = 1;
        for(int i=1; i<=N; i++){
            int prevMax = i*(i-1)/2;
            for(int j=prevMax; j>=0; j--)
                rslt[j+i] += rslt[j];
        }

    }
}