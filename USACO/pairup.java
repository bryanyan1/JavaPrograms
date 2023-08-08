import java.util.*;
import java.io.*;
public class pairup {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("pairup.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for(int j=0; j<a; j++) {
                arr.add(b);
            }
        }
        int max = 0;
        Collections.sort(arr);
        for(int i=0; i<arr.size(); i++) {
            int sum = arr.get(i)+arr.get(arr.size()-i-1);
            if(sum>max) max = sum;
        }
        out.println(max);
        out.close();
        //2 5 6 9
    }
}
