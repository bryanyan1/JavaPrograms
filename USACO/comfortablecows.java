import java.util.*;
import java.io.*;
public class comfortablecows {
    public static HashMap<Integer, Integer> hashmap;
    public static int extra = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(f.readLine());
        hashmap = new HashMap<Integer, Integer>();
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int unique = 1000*x+y;
            int count = 0;
            if(hashmap.containsKey(1000*(x-1)+y)) {
                hashmap.replace(1000*(x-1)+y, hashmap.get(1000*(x-1)+y)+1);
                recur(x-1, y);
                count++;
            }
            if(hashmap.containsKey(1000*(x)+y+1)) {
                count++;
            }
            if(hashmap.containsKey(1000*(x+1)+y)) {
                count++;
            }
            if(hashmap.containsKey(1000*(x)+y-1)) {
                count++;
            }
        }
    }
    public static void recur(int x, int y) {
        int a = 1000*x+y;
        if(hashmap.get(a)!=3) {
            return;
        }
        else {
            hashmap.replace(a, 4);
            if(!hashmap.containsKey(1000*(x-1)+y)) {
                int count = 1;
                if(hashmap.containsKey(1000*(x-2)+y)) {
                    count++;
                }
                if(hashmap.containsKey(1000*(x-1)+y+1)) {
                    count++;
                }
                if(hashmap.containsKey(1000*(x-1)+y-1)) {
                    count++;
                }
                hashmap.put(1000*(x-1)+y, count);
                extra++;
                recur(x-1, y);
            }
            else if(!hashmap.containsKey(1000*(x)+y+1)) {
                int count = 1;
                if(hashmap.containsKey(1000*(x)+y+2)) {
                    count++;
                }
                if(hashmap.containsKey(1000*(x-1)+y+1)) {
                    count++;
                }
                if(hashmap.containsKey(1000*(x+1)+y+1)) {
                    count++;
                }
                hashmap.put(1000*(x)+y+1, count);
                extra++;
                recur(x, y+1);
            }
            else if(!hashmap.containsKey(1000*(x+1)+y)) {
                int count = 1;
                if(hashmap.containsKey(1000*(x+2)+y)) {
                    count++;
                }
                if(hashmap.containsKey(1000*(x+1)+y-1)) {
                    count++;
                }
                if(hashmap.containsKey(1000*(x+1)+y+1)) {
                    count++;
                }
                hashmap.put(1000*(x+1)+y, count);
                extra++;
                recur(x+1, y);
            }
            else if(!hashmap.containsKey(1000*(x)+y-1)) {
                int count = 1;
                if(hashmap.containsKey(1000*(x)+y-2)) {
                    count++;
                }
                if(hashmap.containsKey(1000*(x-1)+y-1)) {
                    count++;
                }
                if(hashmap.containsKey(1000*(x+1)+y-1)) {
                    count++;
                }
                hashmap.put(1000*(x)+y-1, count);
                extra++;
                recur(x, y-1);
            }
        }
    }
}
