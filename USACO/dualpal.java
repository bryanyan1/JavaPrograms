import java.io.*;
import java.util.*;

/*
ID: bryanya1
LANG: JAVA
TASK: dualpal
*/
public class dualpal {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int cont = 0;
        for(int i=S+1; cont<N; i++) {
            if(twopal(Integer.toString(i))){
                out.println(i);
                cont++;
            }
        }
        out.close();
    }
    public static boolean isPalindrome(String x) {
        char[] ch = x.toCharArray();
        for(int i=0; i<(ch.length/2); i++) {
            if(ch[i]!=ch[ch.length-i-1])
                return false;
        }
        return true;
    }
    public static String newBase(int base, String a) {
        String b = Integer.toString(Integer.parseInt(a, 10), base);
        return b.toUpperCase();
    }
    public static boolean twopal(String y) {
        int count = 0;
        for(int i=2; i<=10; i++) {
            if(isPalindrome(newBase(i, y)))
                count++;
        }
        return(count>=2);
    }
}
