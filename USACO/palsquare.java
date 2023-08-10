/*
ID: bryanya1
LANG: JAVA
TASK: palsquare
*/
import java.util.*;
import java.io.*;
public class palsquare {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        int base = Integer.parseInt(f.readLine());
        for(int i=1; i<=300; i++)  {
            if(isPalindrome(newBaseSquare(base, i))){
                out.println(newBase(base, i)+" "+newBaseSquare(base, i));
            }
        }
    }
    public static boolean isPalindrome(String st) {
        char[] b = st.toCharArray();
        for(int i=0; i<(b.length/2); i++) {
            if(b[i]!=b[b.length-i-1])
                return false;
        }
        return true;
    }
    public static String newBase(int base, int a) {
        return Integer.toString(Integer.parseInt(Integer.toString(a), 10), base);
    }
    public static String newBaseSquare(int base, int a) {
        return Integer.toString(Integer.parseInt(Integer.toString((int)Math.pow(a, 2)), 10), base);
    }
}

