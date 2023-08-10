/*
ID: bryanya1
LANG: JAVA
PROG: lamps
*/
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class lamps {
    public static void main(String[] args) throws Exception {
        BufferedReader f = new BufferedReader(new FileReader("lamps.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));
        int N = Integer.parseInt(f.readLine());
        int C = Integer.parseInt(f.readLine());
        StringTokenizer line3 = new StringTokenizer(f.readLine());
        StringTokenizer line4 = new StringTokenizer(f.readLine());
        List<Integer> on = new ArrayList<Integer>();
        List<Integer> off = new ArrayList<Integer>();
        while (line3.hasMoreTokens()) {
            int token = Integer.parseInt(line3.nextToken());
            if (token == -1)
                break;
            on.add(token);
        }
        while (line4.hasMoreTokens()) {
            int token = Integer.parseInt(line4.nextToken());
            if (token == -1)
                break;
            off.add(token);
        }
        TreeSet<String> works = new TreeSet<>();
        String[] solutions = new String[] { "111111", "000000", "010101", "101010", "011011", "100100", "110001",
                "001110" };
        if (C % 6 == 0) {
            works.add(solutions[0]);
            if (C > 0) {
                works.add(solutions[1]);
                works.add(solutions[2]);
                works.add(solutions[3]);
                works.add(solutions[4]);
                works.add(solutions[5]);
                works.add(solutions[6]);
                works.add(solutions[7]);
            }
        }
        else if (C % 6 == 1) {
            works.add(solutions[1]);
            works.add(solutions[2]);
            works.add(solutions[3]);
            works.add(solutions[4]);
        }
        else if (C % 6 == 2) {
            works.add(solutions[0]);
            works.add(solutions[1]);
            works.add(solutions[2]);
            works.add(solutions[3]);
            works.add(solutions[5]);
            works.add(solutions[6]);
            works.add(solutions[7]);
        }
        else if (C % 6 == 5) {
            works.add(solutions[0]);
            works.add(solutions[4]);
            works.add(solutions[5]);
            works.add(solutions[6]);
            works.add(solutions[7]);
        }
        else {
            works.add(solutions[0]);
            works.add(solutions[1]);
            works.add(solutions[2]);
            works.add(solutions[3]);
            works.add(solutions[4]);
            works.add(solutions[5]);
            works.add(solutions[6]);
            works.add(solutions[7]);
        }

        ArrayList<String> results = new ArrayList<String>();
        results.addAll(works);
        boolean isResult = false;
        for (int i = 0; i < results.size(); i++) {
            char[] temp = results.get(i).toCharArray();
            boolean good = true;
            System.out.println(temp);
            for (int test : on) {
                if (temp[(test - 1) % 6] != '1') {
                    good = false;
                    break;
                }
            }
            for (int test : off) {
                if (temp[(test - 1) % 6] != '0') {
                    good = false;
                    break;
                }
            }
            if (good) {
                isResult = true;
                for (int j = 0; j < N; j++) {
                    out.print(temp[j % 6]);
                }
                out.println();
            }
        }
        if (!isResult) {
            out.println("IMPOSSIBLE");
        }
        f.close();
        out.close();
    }
}