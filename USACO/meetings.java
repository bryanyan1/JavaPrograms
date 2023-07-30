import java.util.*;
import java.io.*;
public class meetings {
    public static int L;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("meetings.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("meetings.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        Cow[] cows = new Cow[N];
        int outside = 0;
        for(int i=0; i<N; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            int w = Integer.parseInt(c.nextToken());
            double x = Integer.parseInt(c.nextToken());
            int d = Integer.parseInt(c.nextToken());
            Cow cow = new Cow(w, x, d);
            cows[i] = cow;
            outside+=w;
        }
        Arrays.sort(cows, (m1, m2)->m1.x<m2.x||(m1.x==m2.x&&m1.d<m2.d)? -1:1);
        int barn = 0;
        int count = 0;
        while(barn<outside) {
            double minTravel = L;
            boolean isCollision = false;
            for(int i=0; i<cows.length-1; i++) {
                if(cows[i].d==1&&cows[i+1].d==-1&&cows[i].isInBarn==false&&cows[i+1].isInBarn==false) {
                    isCollision = true;
                    if(cows[i+1].x>cows[i].x) {
                        double travel = cows[i + 1].x - cows[i].x;

                        if (minTravel > travel) {
                            minTravel = travel;
                        }
                    }
                }
                if(cows[i].isInBarn==true&&cows[i+1].d==-1&&cows[i+1].isInBarn==false) {
                    if(cows[i+1].d<minTravel) minTravel = cows[i+1].d;
                }
                if(cows[i+1].isInBarn==true&&cows[i].isInBarn==false&&cows[i].d==1) {
                    if(L-cows[i].d<minTravel) minTravel = L-cows[i].d;
                }
            }
            if(isCollision==false) break;
            for(Cow cow : cows) {
                if(cow.d==-1) {
                    cow.subtract(minTravel/2);
                }
                else cow.add(minTravel/2);
                if(cow.x<=0||cow.x>=L) {
                    cow.setInBarn();
                    barn+=cow.w;
                    outside-=cow.w;
                }
            }
            for(int i=0; i<cows.length-1; i++) {
                if(cows[i].x==cows[i+1].x&&cows[i].isInBarn==false&&cows[i+1].isInBarn==false) {
                    count++;
                    cows[i].flip();
                    cows[i+1].flip();
                }
            }
            Arrays.sort(cows, (m1, m2)->m1.x<m2.x||(m1.x==m2.x&&m1.d<m2.d)? -1:1);
        }
        out.println(count);
        out.close();
    }
    static class Cow {
        public int w;
        public double x;
        public int d;
        public boolean isInBarn = false;
        Cow(int w, double x, int d) {
            this.w = w;
            this.x = x;
            this.d = d;
        }
        public void flip() {
            if(this.d==-1) this.d = 1;
            else this.d = -1;
        }
        public void add(double X) {
            this.x+=X;
        }
        public void subtract(double X) {
            this.x-=X;
        }
        public void setInBarn() {
            this.isInBarn = true;
        }
    }
}
