/*
ID: bryanya1
LANG: JAVA
TASK: prefix
*/
import java.io.*;
import java.util.*;

public class prefix {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("prefix.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));
        ArrayList<String> list1 = new ArrayList<String>();
        String string = "";
        while ((string = f.readLine()) != null) {
            if (string.equals("."))
                break;
            StringTokenizer st = new StringTokenizer(string);
            while (st.hasMoreTokens()) {
                String c = st.nextToken();
                if (dp(c, list1)<c.length()) {
                    list1.add(c);
                }
            }
        }
        System.out.println(list1);
        StringBuilder S = new StringBuilder();
        while ((string = f.readLine()) != null) {
            S.append(string);
        }
        out.println(dp(S.toString(), list1));
        out.close();

    }

    public static int dp(String S, List<String> list1) {
        int a = S.toCharArray().length;
        int max = 0;
        boolean[] b = new boolean[200010];
        b[0]=true;
        for (int i = 0; i < a; i++)
            if (b[i])
                for (String primitive : list1)
                    if (i+primitive.length()<=a && S.substring(i, i+primitive.length()).equals(primitive)) {
                        max = Math.max(max, i+primitive.length());
                        b[i+primitive.length()]=true;
                    }
        return max;
    }
}