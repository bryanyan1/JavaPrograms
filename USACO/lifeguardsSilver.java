import java.io.*;
import java.util.*;
public class lifeguardsSilver {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("lifeguards.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        Lifeguard[] lifeguards = new Lifeguard[N];
        for(int i=0; i<N; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(c.nextToken());
            int y = Integer.parseInt(c.nextToken());
            Lifeguard l = new Lifeguard(x, y);
            lifeguards[i] = l;
        }
        int timeEmpty = 0;
        ArrayList<Integer> a = new ArrayList<Integer>();
        Arrays.sort(lifeguards, (x1, y1) -> x1.start<y1.start ? -1:1);
        ArrayList<Integer> asdf = new ArrayList<Integer>();
        for(Lifeguard i : lifeguards) {
            asdf.add(i.start);
            asdf.add(i.end);
        }
        int maxEnd = lifeguards[0].start;
        int total = Collections.max(asdf)-Collections.min(asdf);
        for(int i=0; i<N-1; i++) {
            int time = 0;
            //1 4     3 7     5 9
            if(lifeguards[i].start>maxEnd) {
                timeEmpty += lifeguards[i].start-maxEnd;
                time += Math.min(lifeguards[i+1].start-lifeguards[i].start, lifeguards[i].end-lifeguards[i].start);
            }
            else if(lifeguards[i].end>maxEnd) {
                time += Math.min(lifeguards[i+1].start-maxEnd, lifeguards[i].end-maxEnd);
            }
            maxEnd = Math.max(lifeguards[i].end, maxEnd);
            a.add(time);
        }
        if(lifeguards[N-1].start>maxEnd) {
            timeEmpty += lifeguards[N-1].start-maxEnd;
            a.add(lifeguards[N-1].end-lifeguards[N-1].start);
        }
        else if(lifeguards[N-1].end>maxEnd) {
            a.add(lifeguards[N-1].end-maxEnd);
        }
        else {
            a.add(0);
        }
        out.println(total-Collections.min(a)-timeEmpty);
        out.close();
    }
    static class Lifeguard {
        public int start;
        public int end;
        Lifeguard(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
