/*
ID: bryanya1
LANG: JAVA
TASK: sprime
*/
import java.util.*;
import java.io.*;
public class sprime {
    public static int N;
    public static PrintWriter out;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Integer.parseInt(st.nextToken());
        recur(2);
        recur(3);
        recur(5);
        recur(7);
        out.close();
    }
    public static void recur(int a) {
        if(a/(int)Math.pow(10, N-1)>0) {
            out.println(a);
            return;
        }
        if(isPrime(a*10+1)) {
            recur(a*10+1);
        }
        if(isPrime(a*10+3)) {
            recur(a*10+3);
        }
        if(isPrime(a*10+7)) {
            recur(a*10+7);
        }
        if(isPrime(a*10+9)) {
            recur(a*10+9);
        }
    }
    public static boolean isPrime(int a) {
        boolean isprime = true;
        for(int i=2; i<=Math.sqrt(a); i++) {
            if(a%i==0) {
                isprime = false;
                break;
            }
        }
        return isprime;
    }
}
