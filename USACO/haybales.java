import java.util.*;
import java.io.*;
public class haybales {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("haybales.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        StringTokenizer c = new StringTokenizer(f.readLine());
        int[] haybales = new int[N];
        for(int i=0; i<N; i++) {
            haybales[i] = Integer.parseInt(c.nextToken());
        }
        Arrays.sort(haybales);
        Guess[] guesses = new Guess[Q];
        for(int i=0; i<Q; i++) {
            StringTokenizer d = new StringTokenizer(f.readLine());
            int start = Integer.parseInt(d.nextToken());
            int end = Integer.parseInt(d.nextToken());
            Guess guess = new Guess(start, end);
            guesses[i] = guess;
        }
        for(int i=0; i<Q; i++) {
            if(isIn(0, N-1 ,haybales, guesses[i].start)) {
                out.println(numberOfHaybales(0, N-1, guesses[i].end, haybales)-numberOfHaybales(0, N-1, guesses[i].start, haybales)+1);
            }
            else out.println(numberOfHaybales(0, N-1, guesses[i].end, haybales)-numberOfHaybales(0, N-1, guesses[i].start, haybales));
        }
        System.out.println(numberOfHaybales(0, N-1, 4, haybales));
        out.close();
    }
    public static int numberOfHaybales(int start, int end, int x, int[] y) {
        //2 3 5 7
        int middle = (start+end)/2;
        if(y[0]>x) return 0;
        else if(y[middle]==x) {
            return middle+1;
        }
        else if(y[y.length-1]<x) return y.length;
        else if(y[middle+1]==x) {
            return middle+2;
        }
        else if(start+1==end) {
            return end;
        }
        else if(y[middle]>x) {
            return numberOfHaybales(start, middle, x, y);
        }
        else if(y[middle]<x) {
            return numberOfHaybales(middle, end, x, y);
        }
        return 0;
    }
    public static class Guess {
        public int start;
        public int end;
        public Guess(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static boolean isIn(int start, int end, int[] array, int n) {
        int middle = (start+end)/2;
        if(array[middle]==n) {
            return true;
        }
        else if(start==end) {
            return false;
        }
        else if(start+1==end&&array[start]!=n&&array[end]!=n) return false;
        else if(array[middle]>n) {
            return isIn(start, middle, array, n);
        }
        else if(array[middle]<n)  {
            return isIn(middle, end, array, n);
        }
        else{
            return false;
        }
    }
}
