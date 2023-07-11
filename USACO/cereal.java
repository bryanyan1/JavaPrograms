import java.util.*;
import java.io.*;
public class cereal {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cereal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cereal.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        HashMap<Integer, Boolean> istaken = new HashMap<Integer, Boolean>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Cow[] cows = new Cow[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(f.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            Cow cow = new Cow(first, second);
            cows[i] = cow;
        }
        for(int i=0; i<N; i++) {
            int count = 0;
            for(int j=i; j<N; j++) {
                if(!istaken.containsKey(cows[j].first)) {
                    istaken.put(cows[j].first, true);
                    count++;
                }
                else if(!istaken.containsKey(cows[j].second)) {
                    istaken.put(cows[j].second, true);
                    count++;
                }
            }
            istaken.clear();
            out.println(count);
        }
        out.close();
    }
    static class Cow {
        public int first;
        public int second;
        Cow(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
