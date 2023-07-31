import java.util.*;
import java.io.*;
public class measurement {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        Measurements[] measurements = new Measurements[N];
        /*
        mildred  1
        elsie 2
        bessie 3
         */
        for(int i=0; i<N; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(c.nextToken());
            String names = c.nextToken();
            String changes = c.nextToken();
            int name;
            if(names.equals("Mildred"))name = 1;
            else if(names.equals("Elsie")) name = 2;
            else name = 3;
            String[] asdf = changes.split("");
            int change = Integer.parseInt(asdf[1]);
            if(asdf[0].equals("-")) {
                change *= -1;
            }
            Measurements p = new Measurements(x, name, change);
            measurements[i] = p;
        }
        Arrays.sort(measurements,  (m1,m2)-> m1.day<m2.day ? -1: 1);
        int Mildred = 7;
        int Elsie = 7;
        int Bessie = 7;
        boolean[] isWinning = new boolean[3];
        int count = 0;
        for(int i=0; i<N; i++) {
            boolean[] copy = new boolean[3];
            for(int j=0; j<3; j++) {
                copy[j] = isWinning[j];
            }
            if(measurements[i].name==1) Mildred+=measurements[i].change;
            else if(measurements[i].name==2) Elsie+=measurements[i].change;
            else Bessie+=measurements[i].change;
            int max = Mildred;
            if(Elsie>max) max = Elsie;
            if(Bessie>max) max = Bessie;
            if(Mildred == max) {
                isWinning[0] = true;
            }
            if(Elsie == max) {
                isWinning[1] = true;
            }
            if(Bessie == max) {
                isWinning[2] = true;
            }
            if(Mildred != max) {
                isWinning[0] = false;
            }
            if(Elsie != max) {
                isWinning[1] = false;
            }
            if(Bessie != max) {
                isWinning[2] = false;
            }
            for(int j=0; j<3; j++) {
                if(isWinning[j]!=copy[j]) {
                    count++;
                    break;
                }
            }
        }
        out.println(count);
        out.close();
    }
    public static class Measurements {
        public int day;
        public int name;
        public int change;
        public Measurements(int day, int name, int change) {
            this.day = day;
            this.name = name;
            this.change = change;
        }
    }
}
