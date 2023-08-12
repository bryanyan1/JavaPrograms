/*
ID: bryanya1
LANG: JAVA
TASK: skidesign
*/
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class skidesign {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] hills = new int[N];
        for(int i=0; i<N; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            hills[i] = Integer.parseInt(c.nextToken());
        }
        ArrayList<Integer> costs = new ArrayList<Integer>();
        for(int i=0; i<983; i++) {
            int cost = 0;
            for(int j=0; j<N; j++) {
                if(hills[j]>i+17) {
                    cost+=Math.pow(hills[j]-(i+17), 2);
                }
                else if(hills[j]<i) {
                    cost+=Math.pow(i-hills[j], 2);
                }
            }
            costs.add(cost);
        }
        out.println(Collections.min(costs));
        out.close();
    }
}
