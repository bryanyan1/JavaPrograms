/*
ID: bryanya1
LANG: JAVA
TASK: hamming
*/
import java.util.*;
import java.io.*;
public class hamming {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("hamming.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        ArrayList<Long> nums = new ArrayList<Long>();
        long num = 0;
        while (nums.size() < N) {
            if (num == 0 || ham(nums, num, D)) {
                nums.add(num);
                if (nums.size() % 10 == 0 || nums.size()==N) {
                    out.println(num);
                }
                else {
                    out.print(num + " ");
                }
            }
            num++;
        }
        out.close();
    }
    public static boolean ham(ArrayList<Long> nums, long num, int D) {
        for (long n : nums) {
            if (Long.bitCount(n ^ num) < D) {
                return false;
            }
        }
        return true;
    }
}
