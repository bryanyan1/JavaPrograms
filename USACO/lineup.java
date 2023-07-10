import java.util.*;
import java.io.*;
public class lineup {
    public static ArrayList<int[]> states = new ArrayList<int[]>();
    public static ArrayList<Pair> pairs = new ArrayList<Pair>();
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("lineup.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        String[] cows = {"Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"};
        for(int i=0; i<N; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            String cow1 = c.nextToken();
            String a = c.nextToken();
            String b = c.nextToken();
            String d = c.nextToken();
            String g = c.nextToken();
            String cow2 = c.nextToken();
            int Cow1;
            int Cow2;

            if(cow1.equals("Beatrice")) Cow1 = 1;
            else if(cow1.equals("Belinda")) Cow1 = 2;
            else if(cow1.equals("Bella")) Cow1 = 3;
            else if(cow1.equals("Bessie")) Cow1 = 4;
            else if(cow1.equals("Betsy")) Cow1 = 5;
            else if(cow1.equals("Blue")) Cow1 = 6;
            else if(cow1.equals("Buttercup")) Cow1 = 7;
            else Cow1 = 8;

            if(cow2.equals("Beatrice")) Cow2 = 1;
            else if(cow2.equals("Belinda")) Cow2 = 2;
            else if(cow2.equals("Bella")) Cow2 = 3;
            else if(cow2.equals("Bessie")) Cow2 = 4;
            else if(cow2.equals("Betsy")) Cow2 = 5;
            else if(cow2.equals("Blue")) Cow2 = 6;
            else if(cow2.equals("Buttercup")) Cow2 = 7;
            else Cow2 = 8;

            Pair pair = new Pair(Cow1, Cow2);
            pairs.add(pair);
        }
        for(int i=12345678; i<=87654321; i++) {
            int[] x = new int[8];
            int j=i;
            while(j>0) {
                if(j%10>0&&j%10<=8) {
                    x[(j % 10)-1]++;
                }
                j/=10;
            }
            boolean shouldstop = false;
            for(int p=0; p<8; p++) {
                if(x[p]!=1) shouldstop=true;
            }
            if(shouldstop==true) continue;
            if(isTrue(i)) {
                ArrayList<Integer> arraylist = new ArrayList<Integer>();
                int c = i;
                while(c>0) {
                    arraylist.add(c%10);
                    c/=10;
                }
                for(int o = 7; o>=0; o--) {
                    if(arraylist.get(o)==1) out.println("Beatrice");
                    else if(arraylist.get(o)==2) out.println("Belinda");
                    else if(arraylist.get(o)==3) out.println("Bella");
                    else if(arraylist.get(o)==4) out.println("Bessie");
                    else if(arraylist.get(o)==5) out.println("Betsy");
                    else if(arraylist.get(o)==6) out.println("Blue");
                    else if(arraylist.get(o)==7) out.println("Buttercup");
                    else if(arraylist.get(o)==8) out.println("Sue");
                }
                break;
            }
        }
        out.close();
    }
    public static boolean isTrue(int x) {
        ArrayList<Integer> arraylist = new ArrayList<Integer>();
        int c = x;
        while(c>0) {
            arraylist.add(c%10);
            c/=10;
        }
        for(int i=0; i<8; i++) {
            for(Pair p : pairs) {
                if(p.x==arraylist.get(i)) {
                    if (i == 0 && arraylist.get(1)!=p.y) {
                        return false;
                    }
                    else if(i == 7 && arraylist.get(6)!=p.y) {
                        return false;
                    }
                    else if(i!=7&&i!=0&&arraylist.get(i-1)!=p.y&&arraylist.get(i+1)!=p.y) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    static class Pair {
        public int x;
        public int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
