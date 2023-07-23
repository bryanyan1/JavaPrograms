import java.util.*;
import java.io.*;
public class diamond {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("diamond.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] diamonds = new int[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(f.readLine());
            diamonds[i] = Integer.parseInt(st.nextToken());
        }
        int windowStart = 0;
        int windowEnd = windowStart+K;
        Arrays.sort(diamonds);
        int count = 0;
        // 1 5 5 9 10 12 14
        int[] col1=new int[N];
        for(int i=0; i<N; i++){
            int temp = 0;
            for(int j=i; j<N&&diamonds[j]<=diamonds[i]+K; j++)
                temp++;

            col1[i]=temp;
        }
        int[] col2 = new int[N];
        col2[N-1]=1;
        for(int i=N-2; i>=0;i--){
            col2[i] = Math.max(col1[i],col2[i+1]);

        }

        int rslt = 0;
        for(int i=0; i<N; i++) {

            count=col1[i] + col2[i+col1[i]];
            rslt = Math.max(rslt, count);

        }
        out.println(count);
        out.close();
    }
}
