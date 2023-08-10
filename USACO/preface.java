/*
ID: bryanya1
LANG: JAVA
PROG: preface
*/
import java.util.*;
import java.io.*;
public class preface {
    public static void main(String[] args) throws IOException {

        String mark10 = "IXCM", mark5 = "VLD";

        BufferedReader bf = new BufferedReader(new FileReader(new File("preface.in")));
        int N = Integer.parseInt(bf.readLine());

        String[] numbers = new String[N];

        for(int i=3; i>=0; i--) {
            int n = (int) Math.pow(10, i);
            for(int j=0;j<N; j+=n*10){
                String baseString =  j> 0 ? numbers[j-1] : "";
                if(j+  n <= N) numbers[ j+n-1 ] = baseString +mark10.charAt(i);
                if(j+2*n <= N) numbers[j+2 * n -1] =numbers[j+n-1] + mark10.charAt(i);
                if(j+3*n <= N) numbers[j+3*n-1] =  numbers[j+2*n-1]+mark10.charAt(i);
                if(j+4*n <= N) numbers[j+4*n - 1] =  numbers[j+n-1]+mark5.charAt(i);
                if(j+5*n <= N) numbers[j+5*n - 1] = baseString+mark5.charAt(i);
                if(j+6*n <= N) numbers[j+6*n - 1] = numbers[j+5*n-1]+mark10.charAt(i);
                if(j+7*n <= N) numbers[j+7*n - 1] = numbers[j+6*n-1]+mark10.charAt(i);
                if(j+8*n <= N) numbers[j+8*n - 1] = numbers[j+7*n-1]+mark10.charAt(i);
                if(j+9*n <=N ) numbers[j+9*n-1] = baseString+mark10.charAt(i)+mark10.charAt(i+1);
            }
        }

        int[] rslt = new int[7];
        String letters = "IVXLCDM";
        for(int i=0; i<N; i++)
            for(int j=0; j<numbers[i].length(); j++)
                for(int k=0; k<7; k++)
                    if(numbers[i].charAt(j)==letters.charAt(k)) {
                        rslt[k]++;
                        break;
                    }


        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("preface.out"))));
        for(int i=0; i<7; i++)
            if(rslt[i]>0)pw.println(letters.charAt(i)+" "+rslt[i]);
        pw.close();
    }
}
