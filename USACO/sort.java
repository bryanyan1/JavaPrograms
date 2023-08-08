import java.util.*;
import java.io.*;
public class sort {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("sort.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        //15382
        //13528
        //13258
        //12358

        //7777766666
        //7777666667
        //7776666677
        //7766666777
        //7666667777
        //6666677777
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        int[] array = new int[N];
        int[] sortedArray = new int[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(f.readLine());
            array[i] = Integer.parseInt(st.nextToken());
            sortedArray[i] = array[i];
        }

        ArrayList<Integer> maxes = new ArrayList<Integer>();
        Arrays.sort(sortedArray);
        for(int i=0; i<N; i++) {
            hashmap.put(sortedArray[i], i);
        }
        for(int i=0; i<N; i++) {
            maxes.add(i-hashmap.get(array[i])+1);
        }
        out.println(Collections.max(maxes));
        out.close();
    }
}
