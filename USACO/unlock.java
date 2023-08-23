import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class unlock {
    public boolean isValid;
    public static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("unlock.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("unlock.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());
        int N3 = Integer.parseInt(st.nextToken());
        int[][] array = new int[10][10];
        for(int i=0; i<N1; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(c.nextToken());
            int y = Integer.parseInt(c.nextToken());
            array[x][y] = 1;
        }
        for(int i=0; i<N2; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(c.nextToken());
            int y = Integer.parseInt(c.nextToken());
            array[x][y] = 2;
        }
        for(int i=0; i<N3; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(c.nextToken());
            int y = Integer.parseInt(c.nextToken());
            array[x][y] = 3;
        }


        SolidSquare s = new SolidSquare();
        s.x = 1;
        s.y = 1;

        SolidSquare s2 = new SolidSquare();



        out.print(min);
        out.close();
    }
    public static class Puzzle {
        public int Steps;
        public ArrayList<SolidObject> SolidObjects;
    }
    public static class SolidObject {
        public ArrayList<SolidSquare> SolidSquare;
        public void move(int direction) {
            //direction: 0: right 1: up, 2: left, 3: down
            if(direction ==0) {
                for(SolidSquare sq : SolidSquare)
                    sq.x +=1;
            }
        }
    }
    public static class SolidSquare {
        public int x;
        public int y;
    }
}