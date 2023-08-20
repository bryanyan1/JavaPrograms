import java.util.*;
import java.io.*;
public class moop {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("moop.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moop.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        Particle[] particles = new Particle[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Particle particle = new Particle(x, y);
            particles[i] = particle;
        }
        Arrays.sort(particles, (m1, m2) -> m1.x>=m2.x&&m1.y<=m2.y ? -1: m1.x>=m2.x ? -1:1);
        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                if((particles[i].x>=particles[j].x&&particles[i].y>=particles[j].y)||(particles[i].x==particles[j].x&&particles[i].y<particles[j].y)) {
                    particles[i].isRemoved = true;
                    break;
                }
            }
        }
        int count = 0;
        for(int i=0; i<N; i++) {
            if(particles[i].isRemoved==false) {
                count++;
            }
        }
        out.println(count);
        out.close();
    }
    static class Particle {
        public int x;
        public int y;
        public boolean isRemoved = false;
        Particle(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
