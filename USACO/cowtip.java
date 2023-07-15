import java.util.*;
import java.io.*;
public class cowtip {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cowtip.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowtip.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] cows = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            String s = c.nextToken();
            for(int j=0; j<N; j++) {
                cows[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        int count = 0;
        boolean iscorrect = false;
        for(int i=N-1; i>=0; i--) {
            if(iscorrect==true) break;
            for(int j=N-1; j>=0; j--) {
                if(cows[i][j]==1) {
                    count++;
                    int[][] temp = flip(i, j, cows);
                    for(int x = 0; x<N; x++) {
                        for(int y = 0; y<N; y++) {
                            cows[x][y]=temp[x][y];
                        }
                    }
                }
                if(isRight(cows)) iscorrect=true;
            }
        }
        out.println(count);
        out.close();
    }
    public static int[][] flip(int x, int y, int[][] array) {
        for(int i=0; i<=x; i++) {
            for(int j=0; j<=y; j++) {
                if(array[i][j]==1) array[i][j]=0;
                else array[i][j]=1;
            }
        }
        return array;
    }
    public static boolean isRight(int[][] array) {
        for(int i=0; i<array.length; i++) {
            for(int j=0; j<array.length; j++) {
                if(array[i][j]==1) return false;
            }
        }
        return true;
    }
}
