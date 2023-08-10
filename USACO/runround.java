/*
ID: bryanya1
LANG: JAVA
PROG: runround
*/
import java.io.*;
public class runround {
    public static void main(String[] args) throws Exception {
        BufferedReader f = new BufferedReader(new FileReader("runround.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
        int M = Integer.parseInt(f.readLine());
        boolean doeswork = false;
        while (!doeswork) {
            M++;
            char[] num = String.valueOf(M).toCharArray();
            for (int j = 0; j < num.length; j++) {
                if (num[j]=='0') {
                    num[j]++;
                }
                for (int k = 0; k < j; k++) {
                    if (num[k]==num[j]) {
                        if (num[j] != '9') {
                            M = Integer.parseInt(String.valueOf(num));
                            M += Math.pow(10, num.length - 1 - j);
                            num = String.valueOf(M).toCharArray();
                        } else {
                            M = Integer.parseInt(String.valueOf(num));
                            M += Math.pow(10, num.length - 1 - j);
                            num = String.valueOf(M).toCharArray();
                        }
                        j=0;
                        k=0;
                        break;
                    }
                }
            }
            String visited = work(num);
            char[] check = visited.toCharArray();
            doeswork = check[check.length - 1] == num[0];
            for (int i = 0; i < num.length; i++) {
                if (doeswork == false) {
                    break;
                }
                if (check.length - num.length - 1 + i < 0 || check[check.length - num.length - 1 + i] != num[i]) {
                    doeswork = false;
                }
            }
        }
        out.println(M);
        out.close();
    }
    public static String work(char[] num) {
        boolean[] looped = new boolean[num.length];
        String visited = "";
        for (int i = -1; i != 0;) {
            if (i == -1) {
                i = 0;
            }
            if (looped[i] == false) {
                looped[i] = true;
                int j;
                for (j = i + 1; j <= (i + num[i] - '0'); j++) {
                    visited += num[j % (num.length)];
                }
                i = j - 1;
                i %= num.length;
            } else {
                return visited;
            }
        }
        for (int i = 0; i < num.length; i++) {
            if(looped[i] == false) {
                visited = visited + " ";
            }
        }
        return visited;
    }
}
/*
public class runaround {
    /*
    public static int x;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("runaround.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("runaround.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        String string = st.nextToken();
        int N = Integer.parseInt(string);
        String[] nums = string.split("");
        x=nums.length;
    }
    public static boolean checkRoundNumber(int input) {
        boolean[] digits = new boolean[x];
        int[] temp = new int[input];
        int index=temp.length-1;
        while(input!=0) {
            int d = input%10;
            if(d==0) {
                return false;
            }
            if(digits[d-1])
        }
    }
}
*/