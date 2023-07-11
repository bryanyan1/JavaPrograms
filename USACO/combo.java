/*
ID: bryanya1
LANG: JAVA
TASK: combo
*/
import java.io.*;
import java.util.*;

public class combo {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("combo.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        StringTokenizer c = new StringTokenizer(f.readLine());
        int A1 = Integer.parseInt(c.nextToken());
        int A2 = Integer.parseInt(c.nextToken());
        int A3 = Integer.parseInt(c.nextToken());
        StringTokenizer b = new StringTokenizer(f.readLine());
        int B1 = Integer.parseInt(b.nextToken());
        int B2 = Integer.parseInt(b.nextToken());
        int B3 = Integer.parseInt(b.nextToken());

        int choice1 = 0;
        int choice2 = 0;
        int choice3 = 0;

        int choiceA1 = 0;
        int choiceA2 = 0;
        int choiceA3 = 0;

        int choiceB1 = 0;
        int choiceB2 = 0;
        int choiceB3 = 0;

        for(int i=1; i<=N; i++) {
            if(Math.abs(A1-i)<=2||Math.abs(A1-i)==N-1||Math.abs(A1-i)==N-2) {
                choiceA1++;
            }
            if(Math.abs(A2-i)<=2||Math.abs(A2-i)==N-1||Math.abs(A2-i)==N-2) {
                choiceA2++;
            }
            if(Math.abs(A3-i)<=2||Math.abs(A3-i)==N-1||Math.abs(A3-i)==N-2) {
                choiceA3++;
            }
        }
        for(int i=1; i<=N; i++) {
            if(Math.abs(B1-i)<=2||Math.abs(B1-i)==N-1||Math.abs(B1-i)==N-2) {
                choiceB1++;
            }
            if(Math.abs(B2-i)<=2||Math.abs(B2-i)==N-1||Math.abs(B2-i)==N-2) {
                choiceB2++;
            }
            if(Math.abs(B3-i)<=2||Math.abs(B3-i)==N-1||Math.abs(B3-i)==N-2) {
                choiceB3++;
            }
        }
        for(int i=1; i<=N; i++) {
            if((Math.abs(A1-i)<=2||Math.abs(A1-i)==N-1||Math.abs(A1-i)==N-2)&&(Math.abs(B1-i)<=2||Math.abs(B1-i)==N-1||Math.abs(B1-i)==N-2)) {
                choice1++;
            }
            if((Math.abs(A2-i)<=2||Math.abs(A2-i)==N-1||Math.abs(A2-i)==N-2)&&(Math.abs(B2-i)<=2||Math.abs(B2-i)==N-1||Math.abs(B2-i)==N-2)) {
                choice2++;
            }
            if((Math.abs(A3-i)<=2||Math.abs(A3-i)==N-1||Math.abs(A3-i)==N-2)&&(Math.abs(B3-i)<=2||Math.abs(B3-i)==N-1||Math.abs(B3-i)==N-2)) {
                choice3++;
            }
        }
        int choicesA = choiceA1*choiceA2*choiceA3;
        int choicesB = choiceB1*choiceB2*choiceB3;
        int choices = choice1*choice2*choice3;
        out.println(choicesA+choicesB-choices);
        out.close();
    }
}
