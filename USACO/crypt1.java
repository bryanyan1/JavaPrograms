/*
ID: bryanya1
LANG: JAVA
TASK: crypt1
*/
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class crypt1 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer> digits = new ArrayList<Integer>();
        StringTokenizer c = new StringTokenizer(f.readLine());
        for(int i=0; i<N; i++) {
            digits.add(Integer.parseInt(c.nextToken()));
        }
        int numberOfSolutions = 0;
        for(int i=100; i<1000; i++) {
            for(int j=10; j<100; j++) {
                if(contains(digits, i)&&contains(digits, j)&&contains(digits, i*(j%10))&&
                        contains(digits, i*(j/10))&&contains(digits, i*j)&&numberOfDigits(i*(j%10))==3
                        &&numberOfDigits(i*(j/10))==3) {
                    numberOfSolutions++;
                }
            }
        }
        out.println(numberOfSolutions);
        out.close();
    }
    public static boolean contains(ArrayList<Integer> digits, int n) {
        while(n>0) {
            if(digits.indexOf(n%10)==-1)
                return false;
            else
                n/=10;
        }
        return true;
    }
    public static int numberOfDigits(int n) {
        int count = 0;
        while(n>0) {
            n/=10;
            count++;
        }
        return count;
    }
}
