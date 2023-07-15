/*
ID: bryanya1
LANG: JAVA
TASK: nocows
*/
import java.io.*;
import java.util.*;

public class nocows {
    public static long[][] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("nocows.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("nocows.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        trees = new long[N+1][K+1];
        for(int i = 0; i <= N; i++) {
            Arrays.fill(trees[i], -1);
        }
        out.println(dp(N, K));
        out.close();
    }

    public static long dp(int n, int k) {
        if (n == 1) {
            if (k == 1) {
                trees[n][k]=1;
                return 1;
            }
            trees[n][k]=0;
            return 0;
        }
        else if (trees[n][k] != -1) {
            return trees[n][k];
        }
        else if ((n<1)||(k<1)||(n%2==0)||(2*k-1>n)) {
            trees[n][k]=0;
            return 0;
        }
        else {
            trees[n][k] = 0;
            for (int i = 1; i < n - 1; i += 2) {
                for (int j = 0; j < k - 1; j++) {
                    trees[n][k] += dp(i, j) * dp(n - i - 1, k - 1);
                    trees[n][k] += dp(i, k - 1) * dp(n - i - 1, j);
                }
                trees[n][k] += dp(i, k - 1) * dp(n - i - 1, k - 1);
            }
            return trees[n][k] %= 9901;
        }
    }
}
