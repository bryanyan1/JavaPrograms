import java.util.*;
import java.io.*;
public class mooves {
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Swap[] swaps = new Swap[K];
        int[] original = new int[N];
        int[] nums = new int[N];
        visited = new boolean[N];
        for(int i=0; i<N; i++) {
            nums[i] = i+1;
            original[i] = i+1;
        }
        int[] answer = new int[N];
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Swap swap = new Swap(a, b);
            swaps[i] = swap;
        }
        for(int i=1; i<=N; i++) {
            int temp = i;
            int count1 = 1;
            for(int j=0; j<K; j++) {
                if(swaps[j].x==temp) {
                    temp = swaps[j].y;
                    if(temp!=i) count1++;
                }
                else if(swaps[j].y==temp) {
                    temp = swaps[j].x;
                    if(temp!=i) count1++;
                }
            }
            answer[i-1]=count1;
        }
        for(int i=0; i<K; i++) {
            int t = nums[swaps[i].x-1];
            int tt = nums[swaps[i].y-1];
            nums[swaps[i].x-1] = tt;
            nums[swaps[i].y-1] = t;
        }
        int[] switches = new int[N];
        for(int i=0; i<N; i++) {
            switches[nums[i]-1] = i+1;
        }
        boolean[] istrue = new boolean[N];
        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                dfs(i+1, switches, original, istrue);
            }
            Arrays.fill(istrue, false);
        }
    }
    public static void dfs(int n, int[] switches, int[] original, boolean[] istrue) {
        if(switches[n-1]==1) return;
        istrue[n-1] = true;
        visited[n-1] = true;
        dfs(switches[n-1], switches, original, istrue);
    }
    static class Swap {
        public int x;
        public int y;
        Swap(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
