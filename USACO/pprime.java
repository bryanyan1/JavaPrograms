/*
ID: bryanya1
LANG: JAVA
TASK: pprime
*/
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class pprime {
    public static int a;
    public static int b;
    public static PrintWriter out;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("pprime.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        palindrome1();
        palindrome2();
        palindrome3();
        palindrome4();
        palindrome5();
        palindrome6();
        palindrome7();
        palindrome8();
        palindrome9();
        out.close();
    }
    public static void palindrome1() {
        for (int d1 = 1; d1 <= 9; d1+=2) {
            int palindrome = d1;
            if(palindrome>=a&&palindrome<=b&&isPrime(palindrome)) out.println(palindrome);
            else if(palindrome>b) break;
        }
    }
    public static void palindrome2() {
        for (int d1 = 1; d1 <= 9; d1+=2) {
            int palindrome = 10*d1+d1;
            if(palindrome>=a&&palindrome<=b&&isPrime(palindrome)) out.println(palindrome);
            else if(palindrome>b) break;
        }
    }
    public static void palindrome3() {
        for (int d1 = 1; d1 <= 9; d1+=2) {
            for (int d2 = 0; d2 <= 9; d2++) {
                int palindrome = 100*d1+10*d2+d1;
                if(palindrome>=a&&palindrome<=b&&isPrime(palindrome)) out.println(palindrome);
                else if(palindrome>b) break;
            }
        }
    }
    public static void palindrome4() {
        for (int d1 = 1; d1 <= 9; d1+=2) {
            for (int d2 = 0; d2 <= 9; d2++) {
                int palindrome = 1000*d1+100*d2+10*d2+d1;
                if(palindrome>=a&&palindrome<=b&&isPrime(palindrome)) out.println(palindrome);
                else if(palindrome>b) break;
            }
        }
    }
    public static void palindrome5() {
        for (int d1 = 1; d1 <= 9; d1+=2) {
            for (int d2 = 0; d2 <= 9; d2++) {
                for (int d3 = 0; d3 <= 9; d3++) {
                    int palindrome = 10000*d1 + 1000*d2 +100*d3 + 10*d2 + d1;
                    if(palindrome>=a&&palindrome<=b&&isPrime(palindrome)) out.println(palindrome);
                    else if(palindrome>b) break;
                }
            }
        }
    }
    public static void palindrome6() {
        for (int d1 = 1; d1 <= 9; d1+=2) {
            for (int d2 = 0; d2 <= 9; d2++) {
                for (int d3 = 0; d3 <= 9; d3++) {
                    int palindrome = 100000*d1 + 10000*d2 +1000*d3 + 100*d3 + 10*d2 + d1;
                    if(palindrome>=a&&palindrome<=b&&isPrime(palindrome)) out.println(palindrome);
                    else if(palindrome>b) break;
                }
            }
        }
    }
    public static void palindrome7() {
        for (int d1 = 1; d1 <= 9; d1+=2) {
            for (int d2 = 0; d2 <= 9; d2++) {
                for (int d3 = 0; d3 <= 9; d3++) {
                    for(int d4 = 0; d4<=9; d4++) {
                        int palindrome = 1000000 * d1 + 100000 * d2 + 10000 * d3 + 1000 * d4 + 100 * d3 + 10 * d2 + d1;
                        if(palindrome>=a&&palindrome<=b&&isPrime(palindrome)) out.println(palindrome);
                        else if(palindrome>b) break;
                    }
                }
            }
        }
    }
    public static void palindrome(int n){

        //2 11
        for(int i=Math.pow())
    }
    public static void palindrome8() {
        for (int d1 = 1; d1 <= 9; d1+=2) {
            for (int d2 = 0; d2 <= 9; d2++) {
                for (int d3 = 0; d3 <= 9; d3++) {
                    for(int d4 = 0; d4<=9; d4++) {
                        int palindrome = 10000000 * d1 + 1000000 * d2 + 100000 * d3 + 10000 * d4 + 1000 * d4 + 100 * d3 + 10 * d2 + d1;
                        if(palindrome>=a&&palindrome<=b&&isPrime(palindrome)) out.println(palindrome);
                        else if(palindrome>b) break;
                    }
                }
            }
        }
    }
    public static void palindrome9() {
        for (int d1 = 1; d1 <= 9; d1+=2) {
            for (int d2 = 0; d2 <= 9; d2++) {
                for (int d3 = 0; d3 <= 9; d3++) {
                    for(int d4 = 0; d4<=9; d4++) {
                        for(int d5 = 0; d5<=9; d5++) {
                            int palindrome = 100000000 * d1 + 10000000 * d2 + 1000000 * d3 + 100000 * d4 + 10000 * d5 + 1000 * d4 + 100 * d3 + 10*d2 + d1;
                            if(palindrome>=a&&palindrome<=b&&isPrime(palindrome)) out.println(palindrome);
                            else if(palindrome>b) break;
                        }
                    }
                }
            }
        }
    }
    /*
    public static int palidrome(int a, int N) {
        if(a%2==1) {
            int[] as = new int[a];
            for(int i=0; i<=a/2; i++) {
                as[i] = as%(Math.pow(10, i));
            }
        }
    }
    */
    public static boolean isPrime(int x) {
        for(int i=2; i<=Math.sqrt(x); i++) {
            if(x%i==0) return false;
        }
        return true;
    }
}
