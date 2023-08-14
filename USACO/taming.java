import java.util.*;
import java.io.*;
public class taming {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("taming.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] array = new int[N];
        StringTokenizer c = new StringTokenizer(f.readLine());
        for(int i=0; i<N; i++) {
            array[i] = Integer.parseInt(c.nextToken());
        }
        int breakouts = 0;
        for(int i=0; i<N; i++) {
            if(array[i]==0) breakouts++;
        }
        boolean isallzero = true;
        for(int i=0; i<N; i++) {
            if(array[i]!=-1) isallzero = false;
        }
        int bigcount = 0;
        int smallcount = 0;
        boolean ispossible = true;
        for(int i=N-1; i>0; i--) {
            if(array[i]!=-1&&array[i-1]==-1) {
                int count = 0;
                for(int j=i-1; j>=0; j--) {
                    if(array[j]==-1) {
                        count++;
                    }
                    else break;
                }
                if(count-array[i]>=0) {
                    if(array[i]!=0)bigcount+=(count-array[i]+1);
                    else bigcount+=(count-array[i]);
                    if(array[i]!=0)smallcount++;
                }
                else if(array[i-count-1]!=array[i]-count-1) {
                    out.println(-1);
                    ispossible = false;
                    break;
                }
            }
        }
        if(isallzero) {
            out.println(1+" "+array.length);
        }
        if(ispossible==true&&isallzero==false) {
            if (array[0] == -1) {
                out.print(breakouts + smallcount + 1 + " ");
                out.println(breakouts + bigcount);
            } else {
                out.print(breakouts + smallcount + " ");
                out.println(breakouts + bigcount);
            }
        }
        out.close();
    }
}
