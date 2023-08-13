import java.util.*;
import java.io.*;
public class socdist {
    public static int N;
    public static int M;
    public static long count = 0;
    public static long minus = 0;
    public static boolean istrue = false;
    public static long last = Long.MIN_VALUE;
    public static Interval[] intervals;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("socdist.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        intervals = new Interval[M];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(f.readLine());
            long start = Long.parseLong(st.nextToken());
            long end = Long.parseLong(st.nextToken());
            Interval interval = new Interval(start, end);
            intervals[i] = interval;
        }
        Arrays.sort(intervals, (m1, m2) -> m1.start<m2.start ? -1:1);
        long answer = binsearch(1, Long.MAX_VALUE-1);
        out.println(answer);
        out.close();
    }
    public static long binsearch(long left, long right) {
        long mid = (left+right)/2;
        if(left==right) return mid;
        if(left+1==right&&istrue==false) {
            istrue = true;
        }
        if(left+1==right&&istrue==true) {
            return mid+1;
        }
        for(int i=0; i<M-1; i++) {
            long length = intervals[i].end-intervals[i].start-minus;
            if(length>=0) {
                count += (long) Math.floor((double) length / (double) mid) + 1;
                last = intervals[i].end - length % mid;
                if (last + mid > intervals[i + 1].end) {
                    minus = intervals[i + 1].end - intervals[i + 1].start + 1;
                }
                else if (last + mid > intervals[i + 1].start) {
                    minus = last + mid - intervals[i + 1].start;
                }
                else {
                    minus = 0;
                }
            }
            else {
               if(intervals[i+1].start>=last+mid) {
                   minus = 0;
               }
               else {
                   minus = last+mid-intervals[i+1].start;
               }
            }
        }

        long length = intervals[M-1].end-intervals[M-1].start-minus;
        if(length>=0) {
            count += (long) Math.floor((double) length / (double) mid) + 1;
        }

        if(count>=N) {
            count = 0;
            minus = 0;
            last = Long.MIN_VALUE;
            return binsearch(mid, right);
        }
        else {
            count = 0;
            minus = 0;
            last = Long.MIN_VALUE;
            return binsearch(left, mid-1);
        }
    }
    static class Interval {
        public long start;
        public long end;
        Interval(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }
}
