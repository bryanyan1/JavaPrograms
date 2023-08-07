/*
ID: bryanya1
LANG: JAVA
TASK: frac1
*/
import java.util.*;
import java.io.*;
public class frac1 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("frac1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        Frac[] arr = new Frac[N*(N-1)/2];
        int index = 0;
        for(int i=2; i<=N; i++) {
            for(int j=1; j<i; j++) {
                Frac frac = new Frac(j, i);
                arr[index] = frac;
                index++;
            }
        }
        Arrays.sort(arr, (m1, m2) -> m1.value<m2.value ? -1:1);
        out.println(0+"/"+1);
        for(int i=0; i<arr.length; i++) {
            if(relativelyPrime(arr[i].num,  arr[i].denom)) {
                out.println(arr[i].num+"/"+arr[i].denom);
            }
        }
        out.println(1+"/"+1);
        out.close();
    }
    public static boolean relativelyPrime(int a, int b) {
        boolean istrue = true;
        for(int i=2; i<=Math.min(a, b); i++) {
            if(a%i==0&&b%i==0) {
                istrue = false;
                break;
            }
        }
        return istrue;
    }
    static class Frac {
        public int num;
        public int denom;
        public double value;
        Frac(int num, int denom) {
            this.num = num;
            this.denom = denom;
            this.value = (double)num/(double)denom;
        }
    }
}
