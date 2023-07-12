import java.io.*;
import java.util.*;

public class convention2 {

    private static int N;
    private static Cow[] cows;
    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new FileReader(new File("convention2.in")));
        N = Integer.parseInt( bf.readLine());

        cows = new Cow[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            cows[i] = new Cow(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) );
        }

        Arrays.sort(cows, (c1, c2)->c1.arriveTime-c2.arriveTime);
        PriorityQueue<Cow> waitQueue = new PriorityQueue<Cow>( (c1, c2)->c1.priority-c2.priority);

        int currentTime = 0, maxWaitTime = 0, nextCow = 0;

        while(!waitQueue.isEmpty()||nextCow<N){

            Cow temp = waitQueue.isEmpty() ? cows[nextCow++] : waitQueue.poll();
            currentTime =Math.max(currentTime, temp.arriveTime);

            maxWaitTime =Math.max(currentTime - temp.arriveTime, maxWaitTime);

            currentTime+=temp.eatTime;
            while(nextCow < N && cows[nextCow].arriveTime<=currentTime)
                waitQueue.add(cows[nextCow++]);

        }

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("convention2.out"))));
        pw.println(maxWaitTime);
        pw.close();


    }
    static class Cow{
        public int priority;
        public int arriveTime;
        public int eatTime;

        public Cow(int p, int a,int e){
            priority = p;
            arriveTime = a;
            eatTime = e;
        }

    }
}
