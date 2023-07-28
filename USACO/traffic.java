import sun.management.Sensor;

import java.util.*;
import java.io.*;
public class traffic {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("traffic.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("traffic.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        Sensor[] sensors =new Sensor[N];
        for(int i=0; i<N; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            String type = c.nextToken();
            int min = Integer.parseInt(c.nextToken());
            int max = Integer.parseInt(c.nextToken());
            Sensor sensor = new Sensor(type, min, max);
            sensors[i] = sensor;
        }
        int onMinimum = -100000;
        int onMaximum = 100000;
        for(int i=N-1; i>=0; i--) {
            if(sensors[i].type.equals("off")) {
                onMinimum+=sensors[i].min;
                onMaximum+=sensors[i].max;
            }
            else if(sensors[i].type.equals("none")) {
                onMinimum = Math.max(onMinimum, sensors[i].min);
                onMaximum = Math.min(onMaximum, sensors[i].max);
            }
            else {
                onMinimum -=sensors[i].max;
                onMaximum -=sensors[i].min;
            }
        }
        int offMinimum = -100000;
        int offMaximum = 100000;
        for(int i=0; i<N; i++) {
            if(sensors[i].type.equals("off")) {
                offMinimum-=sensors[i].max;
                offMaximum-=sensors[i].min;
            }
            else if(sensors[i].type.equals("none")) {
                offMinimum = Math.max(offMinimum, sensors[i].min);
                offMaximum = Math.min(offMaximum, sensors[i].max);
            }
            else {
                offMinimum +=sensors[i].min;
                offMaximum +=sensors[i].max;
            }
        }
        if(onMaximum<0) onMaximum=0;
        if(onMinimum<0) onMinimum=0;
        if(offMaximum<0) offMaximum=0;
        if(offMinimum<0) offMinimum=0;
        out.println(onMinimum+" "+onMaximum);
        out.println(offMinimum+" "+offMaximum);
        out.close();
    }
    public static class Sensor {
        public String type;
        public int min;
        public int max;
        public Sensor(String type, int min, int max) {
            this.type = type;
            this.min = min;
            this.max = max;
        }
    }
}
