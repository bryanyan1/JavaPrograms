import java.util.*;
import java.io.*;
public class homework {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("homework.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        double[] scores = new double[N];
        StringTokenizer c = new StringTokenizer(f.readLine());
        double sum = 0;
        ArrayList<Double> min = new ArrayList<Double>();
        for(int i=0; i<N; i++) {
            scores[i] = Integer.parseInt(c.nextToken());
            sum+=scores[i];
            min.add(scores[i]);
        }
        Collections.sort(min);
       double leftSum = 0;
        double rightSum = sum;
        ArrayList<Double> averages = new ArrayList<Double>();
        for(int i=0; i<N-2; i++) {
            leftSum+=scores[i];
            if(scores[i]==min.get(0)) min.remove(0);
            averages.add((sum-leftSum-min.get(0))/(N-i-2));
        }
        double max = Collections.max(averages);
        for(int i=0; i<N-2; i++) {
            if(averages.get(i)==max) {
                out.println(i+1);
            }
        }
        out.close();
    }
}
