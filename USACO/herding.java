import java.util.*;
import java.io.*;
public class herding {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("herding.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        // _ _ _ * _ _ * _ *
        int B = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] array = new int[3];
        array[0]=B;
        array[1]=E;
        array[2] = M;
        Arrays.sort(array);

        int x = array[2]-array[1];
        int y = array[1]-array[0];
        if(x==1&&y==1) {
            out.println(0);
            out.println(0);
        }
        else {
            int min;
            int max;
            if (x > y) {
                min = y;
                max = x;
            } else {
                min = x;
                max = y;
            }
            if (min == 2) out.println(1);
            else out.println(2);
            //out.println(min-1);
            out.println(max - 1);
        }
        out.close();
    }
}
