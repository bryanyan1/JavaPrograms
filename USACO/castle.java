/*
ID: bryanya1
LANG: JAVA
TASK: castle
*/
import java.util.*;
import java.io.*;

public class castle {

    public static boolean[][] visitedBool;
    public static int[][] castle;
    public static int row;
    public static int cols;
    public static int[][] visited;
    public static int count;
    public static int roomNumber;
    public static ArrayList<Integer> sizes;
    public static int maxOut;
    public static Wall wall;

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("castle.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));

        String[] str = f.readLine().split(" ");

        row = Integer.parseInt(str[1]);
        cols = Integer.parseInt(str[0]);

        castle = new int[row][cols];

        for(int i = 0; i < row; i++){
            str = f.readLine().split(" ");
            for(int j = 0; j < cols; j++){
                castle[i][j] = Integer.parseInt(str[j]);

            }

        }

        visited = new int[row][cols];
        roomNumber = 0;
        sizes = new ArrayList<Integer>();

        int max = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < cols; j++){
                if (visited[i][j] == 0) {
                    roomNumber++;
                    count = 0;

                    dfs(i, j);
                    sizes.add(count);
                    max = Math.max(max, count);

                }
            }

        }
        out.println(roomNumber);
        out.println(max);

        visitedBool = new boolean[row][cols];

        maxOut = 0;

        wall = new Wall("0",0,0);

        for(int i = 0; i < row; i++){
            for(int j = 0; j < cols; j++){
                if(!visitedBool[i][j]){
                    dfs2(i, j, visited[i][j]);

                }

            }

        }

        out.println(maxOut);
        out.print((wall.row + 1) + " ");
        out.print((wall.column + 1) + " ");
        out.print(wall.direction);
        out.println();
        out.close();



    }

    public static void dfs2(int i, int j, int count){

        if(visitedBool[i][j]){
            return;

        }
        visitedBool[i][j] = true;

        if(i + 1 < row) {
            if (visited[i + 1][j] == count) {
                dfs2(i + 1, j, count);

            } else {
                if (sizes.get(visited[i + 1][j] - 1) + sizes.get(count - 1) > maxOut) {
                    maxOut = sizes.get(visited[i + 1][j] - 1) + sizes.get(count - 1);
                    wall = new Wall("N", i + 1, j);

                } else if (sizes.get(visited[i + 1][j] - 1) + sizes.get(count - 1) == maxOut) {
                    if (j < wall.column || (j == wall.column && i + 1 > wall.row))
                        wall = new Wall("N", i + 1, j);

                }

            }
        }
        if(i - 1 > -1) {
            if (visited[i - 1][j] == count) {
                dfs2(i - 1, j, count);

            } else {
                if (sizes.get(visited[i - 1][j] - 1) + sizes.get(count - 1) > maxOut) {
                    wall = new Wall("N", i, j);
                    maxOut = sizes.get(visited[i - 1][j] - 1) + sizes.get(count - 1);

                } else if (sizes.get(visited[i - 1][j] - 1) + sizes.get(count - 1) == maxOut) {
                    if (j < wall.column || (j == wall.column && i > wall.row))
                        wall = new Wall("N", i, j);

                }

            }
        }
        if(j + 1 < cols) {
            if (visited[i][j + 1] == count) {
                dfs2(i, j + 1, count);

            } else {
                if (sizes.get(visited[i][j + 1] - 1) + sizes.get(count - 1) > maxOut) {
                    wall = new Wall("E", i, j);
                    maxOut = sizes.get(visited[i][j + 1] - 1) + sizes.get(count - 1);

                }
                if (sizes.get(visited[i][j + 1] - 1) + sizes.get(count - 1) == maxOut) {
                    if (j < wall.column || (j == wall.column && i > wall.row))
                        wall = new Wall("E", i, j);

                }

            }
        }
        if(j - 1 > -1) {
            if (visited[i][j - 1] == count) {
                dfs2(i, j - 1, count);

            } else {
                if (sizes.get(visited[i][j - 1] - 1) + sizes.get(count - 1) > maxOut) {
                    wall = new Wall("E", i, j - 1);
                    maxOut = sizes.get(visited[i][j - 1] - 1) + sizes.get(count - 1);

                }
                if (sizes.get(visited[i][j - 1] - 1) + sizes.get(count - 1) == maxOut) {
                    if (j - 1 < wall.column || (j - 1 == wall.column && i > wall.row))
                        wall = new Wall("E", i, j - 1);


                }

            }
        }

    }

    public static void dfs(int i, int j){
        if(visited[i][j] != 0){
            return;

        }
        visited[i][j] = roomNumber;
        count++;

        if((castle[i][j] & 8) == 0){
            dfs(i + 1, j);

        }
        if((castle[i][j] & 4) == 0){
            dfs(i, j + 1);

        }
        if((castle[i][j] & 2) == 0){
            dfs(i - 1, j);

        }
        if((castle[i][j] & 1) == 0){
            dfs(i, j - 1);

        }

    }

    public static class Wall{
        public String direction;
        public int row;
        public int column;

        Wall(String a, int b, int c){
            direction = a;
            row = b;
            column = c;
        }

    }

}




























/*import java.util.*;
import java.io.*;
public class castle {
    public static boolean[][] visited;
    public static int count = 0, x, y;
    public static boolean[][] connect;
    public static int[][] roomNumbers;

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("castle.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        visited = new boolean[x][y];
        roomNumbers = new int[x][y];
        for(int i=0; i<y; i++) {
            st = new StringTokenizer(f.readLine());
            for(int j=0; j<x; j++) {
                int a = Integer.parseInt(st.nextToken());
                roomNumbers[j][i] = a;
            }
        }
        dfs_visit(0, 0);

        for(int i=0; i<y; i++) {
            for (int j = 0; j < x; j++) {
                if (visited[j][i]) continue;

                count++;
                dfs_visit(j, i);
            }
        }

    }

    private static void dfs_visit(int j, int i) {

        if(visited[j][i] == true) return;
        visited[j][i] = true;
        //0001 west     1
        //0010 north    2
        //0100 east     4
        //1000 south    8
        //00?1   11
        //& 0010

        if(isValid(i-1, j) &&  (roomNumbers[i][j] & 2) == 0 ) dfs_visit(i-1, j);
        if(isValid(i+1, j) && (roomNumbers[i][j] & 8 ) == 0 )dfs_visit(i+1, j);
        if(isValid(i, j-1))dfs_visit(i, j-1);
        if(isValid(i, j+1))dfs_visit(i, j+1);


    }

    private static boolean isValid(int i1, int j1) {

        if(i1< 0 || i1 >= y || j1<0 || j1 >= x) return false;

        return true;

    }
    /*

    public static void recur(int x, int y, int a, int b) {
        if(connect[x][y]==false) return;
        if(x>=a||x<0||y<0||y>=b) return;
        count++;
        visited[x][y] = true;
        recur(x+1, y, a, b);
        recur(x, y+1, a, b);
        recur(x-1, y, a, b);
        recur(x, y-1, a, b);
    }
    static class Square {
        public int x;
        public int y;
        Square(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    */

