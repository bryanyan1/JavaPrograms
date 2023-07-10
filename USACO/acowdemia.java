import java.util.*;
import java.io.*;
public class acowdemia {
    public static void main(String[] args) throws IOException  {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int array[] = new int[N];
        st = new StringTokenizer(f.readLine());
        for(int i=0; i<N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        boolean isprinted = false;
        Arrays.sort(array);
        for(int j=0; j<N; j++) {
            if(j+1>array[N-j-1]) {
                System.out.println(j+2);
                isprinted = true;
                break;
            }
        }
        if(isprinted==false) {
            System.out.println(0);
        }
    }
}
