import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class backforth {
    public static boolean[] isPossible = new boolean[2000];
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("backforth.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));
        ArrayList<Integer> barn1 = new ArrayList<Integer>();
        ArrayList<Integer> barn2 = new ArrayList<Integer>();
        StringTokenizer st = new StringTokenizer(f.readLine());
        for (int i = 0; i < 10; i++) {
            barn1.add(Integer.parseInt(st.nextToken()));
        }
        StringTokenizer c = new StringTokenizer(f.readLine());
        for (int i = 0; i < 10; i++) {
            barn2.add(Integer.parseInt(c.nextToken()));
        }
        //boolean[] isPossible = new boolean[2000];
        pour(barn1, barn2, 1, 1000, 1000);
        int count = 0;
        for(boolean a : isPossible) {
            if(a==true) {
                count++;
            }
        }
        out.println(count);
        out.close();
    }
    public static void pour(ArrayList<Integer> barn1, ArrayList<Integer> barn2, int day, int barn1amount, int barn2amount) {
        //day 1 = tuesday
        if(day>4) {
            isPossible[barn1amount]=true;
            return;
        }
        if(day%2==1) {
            for(int i=0; i<barn1.size(); i++) {
                int x = barn1.get(i);
                barn2.add(barn1.get(i));
                barn1.remove(i);
                pour(barn1, barn2, day+1, barn1amount-x, barn2amount+x);
                barn1.add(i, x);
                barn2.remove(barn2.size()-1);
            }
        }
        else {
            for(int i=0; i<barn2.size(); i++) {
                int x = barn2.get(i);
                barn1.add(x);
                barn2.remove(i);
                pour(barn1, barn2, day+1, barn1amount+x, barn2amount-x);
                barn2.add(i, x);
                barn1.remove(barn1.size()-1);
            }
        }
    }
}