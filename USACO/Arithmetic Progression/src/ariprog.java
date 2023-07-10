/*
ID: bryanya1
LANG: JAVA
TASK: ariprog
*/
import java.io.*;
import java.util.*;

public class ariprog {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        StringTokenizer c = new StringTokenizer(f.readLine());
        int M = Integer.parseInt(c.nextToken());
        HashSet<Integer> bisquares = new HashSet<Integer>();
        for(int i=0; i<=M; i++) {
            for(int j=0; j<=M; j++) {
                bisquares.add((int)(Math.pow(i, 2)+Math.pow(j, 2)));
            }
        }
        Integer[] bArray = bisquares.toArray(new Integer[bisquares.size()]);
        Arrays.sort(bArray);

        boolean hasPrinted = false;
        int max0 = (int)(2*Math.pow(M, 2)+1);
        ArrayList<Pair> arraylist = new ArrayList<Pair>();
        for(int i1 = 0; i1<bArray.length; i1++) {
            for (int l=i1+1; l<bArray.length; l++) {
                int i = bArray[i1];
                int k = bArray[l]-i;
                if(i+k*(N-1)>max0) {
                    break;
                }
                // 1 2 4 5 6 8 9 10 12 14 \
                //2 4 6 8 10
                int count=0;
                for(int j=0; j<=k*(N-1); j+=k) {
                    if(bisquares.contains(i+j)) {
                        count++;
                    }
                    else
                        break;
                }
                if(count==N) {
                    hasPrinted=true;
                    Pair x = new Pair(i, k);
                    insert(x, arraylist);
                }
            }
        }
        if(hasPrinted==false)
            out.println("NONE");
        else {
            for(Pair x : arraylist) {
                out.println(x.x+" " + x.y);
            }
        }
        out.close();
    }
    public static class Pair {
        public int x;
        public int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getX(Pair a) {
            return a.x;
        }
        public int getY(Pair a) {
            return a.y;
        }
    }
    public static void insert(Pair a, ArrayList<Pair> rslt) {
        int pos = 0;
        for(pos = 0; pos<rslt.size(); pos++) {
            if(a.y < rslt.get(pos).y || a.y == rslt.get(pos).y && a.x<rslt.get(pos).x) {
                break;
            }
        }
        rslt.add(pos, a);
    }
}