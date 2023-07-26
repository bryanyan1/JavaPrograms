/*
ID: bryanya1
LANG: JAVA
TASK: holstein
*/
import java.util.*;
import java.io.*;
public class holstein {
    public static int[] needs;
    public static int V;
    public static PrintWriter out;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("holstein.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        V = Integer.parseInt(st.nextToken());
        needs = new int[V];
        st = new StringTokenizer(f.readLine());
        for(int i=0; i<V; i++) {
            needs[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(f.readLine());
        int G = Integer.parseInt(st.nextToken());
        int[][] scoops = new int[G][V];
        for(int i=0; i<G; i++) {
            st = new StringTokenizer(f.readLine());
            for(int j=0; j<V; j++) {
                scoops[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(scoops);
        out.close();
    }
    static void solve(int[][] a) {
        ArrayList<ArrayList<Integer>> sols = new ArrayList<ArrayList<Integer>>();
        int n = a.length;
        for (int i = 0; i < (1<<n); i++) {
            boolean istrue = false;
            ArrayList<int[]> arr = new ArrayList<int[]>();
            ArrayList<Integer> arr2 = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    arr.add(a[j]);
                    arr2.add(j+1);
                }
            }
            for(int k=0; k<V; k++) {
                int sum = 0;
                for(int j=0; j<arr.size(); j++) {
                    sum+=arr.get(j)[k];
                }
                if(sum<needs[k]) {
                    istrue = true;
                    break;
                }
            }
            if(istrue == false) {
                sols.add(arr2);
            }
        }
        int min = 1000000;
        for(int i=0; i<sols.size(); i++) {
            if(sols.get(i).size()<min) min=sols.get(i).size();
        }
        out.print(min+" ");
        for(int i=0; i<sols.size(); i++) {
            if(sols.get(i).size()==min) {
                for(int j=0; j<min; j++) {
                    out.print(sols.get(i).get(j));
                    if(j!=min-1) out.print(" ");
                }
                out.println();
                break;
            }
        }
    }
    /*public boolean groupSum(int[] a, int index, int target) {
        if(target == 0) {
            return true;
        }
        if(index>=a.length) {
            return false;
        }
        return groupSum(a, index+1, target) || groupSum(a, index+1, target-a[index]);

    }
    /*public static void sum(int[] a, int index, int count, int target){
        if(target==0) {
            max = count;
            return;
        }
        if(count+1<max&&index+1<a.length) {
            sum(a, index+1, count+1, target-a[index]);
            sum(a, index+1, count, target);
        }
    }
    */
}
/*
1 2 3 4
2 1 1 4
2 2 2 4
1 2 3 4

0001
0010
0011
