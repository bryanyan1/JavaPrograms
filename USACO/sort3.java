/*
ID: bryanya1
LANG: JAVA
TASK: sort3
*/
import java.util.*;
import java.io.*;
public class sort3 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("sort3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(f.readLine());
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int[] nums2 = new int[N];
        for (int i = 0; i < N; i++) {
            nums2[i] = nums[i];
        }
        Arrays.sort(nums2);
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (nums[i] != nums2[i] && nums[j] != nums2[j] && nums[i] == nums2[j] && nums[j] == nums2[i]) {
                    nums[i] = nums2[i];
                    nums[j] = nums2[j];
                    count++;
                }
            }
        }
        int count2 = 0;
        for(int i=0; i<N; i++) {
            if (nums[i] != nums2[i]) {
                count2++;
            }
        }
        out.println(count+2*count2/3);
        out.close();
    }
}
