import java.util.*;
import java.io.*;
public class mooyomooyo {
    public static int[][] board;
    public static int[][] numbers;
    public static int number = 1;
    public static int N;
    public static int K;
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("mooyomooyo.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[10][N];
        visited = new boolean[10][N];
        numbers = new int[10][N];
        for(int i=0; i<N; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            String string = c.nextToken();
            for(int j=0; j<10; j++) {
                board[j][i] = Integer.parseInt(String.valueOf(string.charAt(j)));
            }
        }
        while(!isFinished(numbers)) {
            for(int i=0; i<10; i++) {
                for(int j=0; j<N; j++) {
                    if(visited[i][j]==false && board[i][j]!=0) {
                        floodfill(i, j);
                        number++;
                    }
                }
            }
            int[] list = new int[10*N];
            for(int i=0; i<10; i++) {
                for(int j=0; j<N; j++) {
                    if(numbers[i][j]!=0) {
                        list[numbers[i][j]]++;
                    }
                }
            }
            ArrayList<Integer> arraylist = new ArrayList<Integer>();
            for(int i=0; i<list.length; i++) {
                if(list[i]>=K) {
                    arraylist.add(list[i]);
                }
            }
            for(int i=1; i<10; i++) {
                for (int j = 0; j < N; j++) {
                    if (isIn(arraylist, board[i][j])) {
                        board[i][j] = board[i - 1][j];
                        board[i - 1][j] = 0;
                    }
                }
            }
            number = 1;
            for(int i=0; i<10; i++) {
                for(int j=0; j<N; j++) {
                    visited[i][j]=false;
                }
            }
        }
        for(int i=0; i<10; i++) {
            for(int j=0; j<N; j++) {
                out.print(board[i][j]);
            }
            out.println();
        }
        out.close();
    }
    public static void floodfill(int x, int y) {
        int value = board[x][y];
        if(visited[x][y])return;
        visited[x][y] = true;
        numbers[x][y] = number;
        visit(x, y+1, value);
        visit(x, y-1, value);
        visit(x-1, y, value);
        visit(x+1, y, value);
    }
    public static void visit(int x, int y, int value) {
        if(x<0||x>=10||y<0||y>=N||board[x][y]!=value) return;
        floodfill(x, y);
    }
    public static boolean isIn(ArrayList<Integer> a, int b) {
        for(int i=0; i<a.size(); i++) {
            if(a.get(i)==b) return true;
        }
        return false;
    }
    public static boolean isFinished(int[][] x) {
        int length = x[0].length;
        int size = x.length;
        boolean istrue = true;
        for(int i=0; i<size; i++) {
            for(int j=0; j<length; j++) {
                if(x[i][j]!=0) {
                    istrue = false;
                }
            }
        }
        if(istrue) return false;
        int[] array = new int[length*size];
        for(int i=0; i<size; i++) {
            for(int j=0; j<length; j++) {
                if(x[i][j]!=0) {
                    array[x[i][j]]++;
                }
            }
        }
        for(int i : array) {
            if(i>=K) return false;
        }
        return true;
    }
}