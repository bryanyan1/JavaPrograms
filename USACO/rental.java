import java.util.*;
import java.io.*;
public class rental {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("rental.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        long[] cows = new long[N];
        for(int i=0; i<N; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            cows[i] = Long.parseLong(c.nextToken());
        }
        Arrays.sort(cows);
        Store[] stores = new Store[M];
        for(int i=0; i<M; i++) {
            StringTokenizer d = new StringTokenizer(f.readLine());
            long gallons = Long.parseLong(d.nextToken());
            long price = Long.parseLong(d.nextToken());
            Store store = new Store(gallons, price);
            stores[i] = store;
        }
        Arrays.sort(stores, (x1, x2) -> x1.price<x2.price ? -1: x1.price > x2.price ? 1 : 0);
        long[] rents = new long[R];
        for(int i=0; i<R; i++) {
            StringTokenizer e = new StringTokenizer(f.readLine());
            rents[i] = Long.parseLong(e.nextToken());
        }
        Arrays.sort(rents);
        long[] as = new long[R];
        for(int i=0; i<R; i++) {
            as[i] = rents[R-i-1];
        }
        for(int i=0; i<R; i++) {
            rents[i] = as[i];
        }
        long[] psums = new long[N+1];
        int S = M-1;
        for(int i=1; i<=N; i++) {
            psums[i] = psums[i-1];
            long sum = 0;
            long gallons=cows[N-i];
            while(gallons>0&&S>=0) {
                //if(x<=0) break;
                if(gallons>=stores[S].gallons) {
                    gallons-=stores[S].gallons;
                    sum+=stores[S].gallons*stores[S].price;
                    S--;
                }
                else {
                    sum+=gallons*stores[S].price;
                    stores[S].gallons-=gallons;
                    break;
                }
            }
            psums[i] += sum;
        }
        long[] psum2 = new long[N];
        psum2[0] = psum2[0];
        for(int i=1; i<N; i++) {
            psum2[i] = psums[i]-psums[i-1];
        }
        long[] asdf = new long[N];
        asdf[0] = rents[0];
        for(int i=1; i<N; i++) {
            if(i<R) {
                asdf[i] = rents[i] + asdf[i - 1];
            }
            else {
                asdf[i] = asdf[i-1];
            }
        }
        long[] aaa = new long[N+1];
        long[] bbb = new long[N+1];
        aaa[0] = 0;
        aaa[0] = 0;
        for(int i=0; i<N; i++) {
            aaa[i+1] = asdf[i];
            bbb[i+1] = psums[i];
        }
        ArrayList<Long> a = new ArrayList<Long>();
        for(int i=0; i<N+1; i++) {
            a.add(aaa[i]+psums[N-i]);
        }
        out.println(Collections.max(a));
        out.close();
    }
    static class Store {
        public long gallons;
        public long price;
        Store(long gallons, long price) {
            this.gallons = gallons;
            this.price = price;
        }
        public void subtract(int x) {
            this.gallons -= x;
        }
    }
}
