import java.util.*;
import java.io.*;
public class revegetate {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("revegetate.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Cow> cows = new ArrayList<Cow>();
        for(int i=0; i<M; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(c.nextToken());
            int y = Integer.parseInt(c.nextToken());
            Cow cow;
            if(x>y) {
                cow = new Cow(y, x);
            }
            else cow = new Cow(x, y);
            cows.add(cow);
        }
        int[] number = new int[N];
        Arrays.fill(number, 1);
        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                Cow co = new Cow(i+1, j+1);
                if(isIn(co, cows)&&(!dontneedAdd(i+1, j+1 ,cows))) {
                    number[j]++;
                }
            }
        }
        for(int i : number) out.print(i);
        out.println();
        out.close();
    }
    public static boolean dontneedAdd(int i, int j, ArrayList<Cow> cows) {
        for(int x=i-1; x>=0; x--) {
            Cow cow = new Cow(x, i);
            Cow cow1 = new Cow(x, j);
            if(isIn(cow, cows)&&isIn(cow1, cows)) return true;
        }
        return false;
    }
    public static boolean isIn(Cow cow, ArrayList<Cow> cows) {
        for(Cow cowss : cows) {
            if(cowss.pasture1==cow.pasture1&&cowss.pasture2==cow.pasture2) {
                return true;
            }
        }
        return false;
    }
    public static class Cow {
        public int pasture1;
        public int pasture2;
        public Cow(int x, int y) {
            pasture1 = x;
            pasture2 = y;
        }
    }
}
