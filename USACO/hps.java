import java.io.*;
import java.util.*;
public class hps {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("hps.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        String[] gestures = new String[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(f.readLine());
            String str = st.nextToken();
            gestures[i] = str;
        }
        Class[] classes = new Class[N];
        for(int i=0; i<N; i++) {
            classes[i] = new Class(0, 0, 0);
        }
        for(int i=0; i<N; i++) {
            if(i!=0) {
                classes[i].hooves = classes[i-1].hooves;
                classes[i].papers = classes[i-1].papers;
                classes[i].scissors = classes[i-1].scissors;
            }
            if(gestures[i].equals("H")) {
                classes[i].hooves++;
            }
            if(gestures[i].equals("P")) {
                classes[i].papers++;
            }
            if(gestures[i].equals("S")) {
                classes[i].scissors++;
            }
        }

        Class[] classes2 = new Class[N];
        for(int i=0; i<N; i++) {
            classes2[i] = new Class(0, 0, 0);
        }
        for(int i=N-1; i>=0; i--) {
            if(i!=N-1) {
                classes2[i].hooves = classes2[i+1].hooves;
                classes2[i].papers = classes2[i+1].papers;
                classes2[i].scissors = classes2[i+1].scissors;
            }
            if(gestures[i].equals("H")) {
                classes2[i].hooves++;
            }
            if(gestures[i].equals("P")) {
                classes2[i].papers++;
            }
            if(gestures[i].equals("S")) {
                classes2[i].scissors++;
            }
        }
        int max = 0;
        for(int i=0; i<N-1; i++) {
            int a = 0;
            if(classes[i].hooves>a) a = classes[i].hooves;
            if(classes[i].papers>a) a = classes[i].papers;
            if(classes[i].scissors>a) a = classes[i].scissors;

            int b = 0;
            if(classes2[i+1].hooves>b) b = classes2[i+1].hooves;
            if(classes2[i+1].papers>b) b = classes2[i+1].papers;
            if(classes2[i+1].scissors>b) b = classes2[i+1].scissors;

            if(max<a+b) max = a+b;
        }
        out.println(max);
        out.close();
    }
    static class Class {
        public int hooves;
        public int papers;
        public int scissors;
        Class(int Hooves, int Papers, int Scissors) {
            this.hooves = Hooves;
            this.papers = Papers;
            this.scissors = Scissors;
        }
    }
}
