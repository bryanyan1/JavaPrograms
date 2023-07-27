import java.util.*;
import java.io.*;
public class perimeter {
    public static int N;
    public static int number = 1;
    public static String[][] blobs;
    public static int[][] numbers;
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("perimeter.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Integer.parseInt(st.nextToken());
        blobs = new String[N][N];
        numbers = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            String string = c.nextToken();
            for(int j=0; j<N; j++) {
                blobs[i][j] = String.valueOf((string.charAt(j)));
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(visited[i][j]==false&&blobs[i][j].equals("#")) {
                    dfs_search(i, j);
                    number++;
                }
            }
        }
        int[] values = new int[(int) Math.pow(N, 2)];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(numbers[i][j]!=0) {
                    values[numbers[i][j]]++;
                }
            }
        }
        int max = values[0];
        ArrayList<Integer> maxIndex = new ArrayList<Integer>();
        for(int i=0; i<Math.pow(N, 2); i++) {
            if(values[i]>max) {
                max = values[i];
            }
        }
        for(int i=0; i<Math.pow(N, 2); i++) {
            if(values[i]==max) {
                maxIndex.add(i);
            }
        }
        ArrayList<Integer> perimeters = new ArrayList<Integer>();
        for(int k=0; k<maxIndex.size(); k++) {
            int perimeter = 0;
        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                if (numbers[i][j] == maxIndex.get(k)) {
                    int count = 0;
                    if (j < N - 1) {
                        if (blobs[i][j + 1].equals("#")) count++;
                    }
                    if (j > 0) {
                        if (blobs[i][j - 1].equals("#")) count++;
                    }
                    if (i < N - 1) {
                        if (blobs[i + 1][j].equals("#")) count++;
                    }
                    if (i > 0) {
                        if (blobs[i - 1][j].equals("#")) count++;
                    }
                    perimeter += (4 - count);
                }
            }
        }
        perimeters.add(perimeter);
        }
        out.print(max+" ");
        out.println(Collections.min(perimeters));
        out.close();
    }
    public static void dfs_search(int i, int j) {
        if(visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        numbers[i][j] = number;
        visit(i-1,j);
        visit(i+1,j);
        visit(i,j-1);
        visit(i,j+1);
    }
    public static void visit(int i, int j) {
        if(i<0||i>=N||j<0||j>=N||blobs[i][j].equals(".")) {
            return;
        }
        dfs_search(i,j);
    }
}