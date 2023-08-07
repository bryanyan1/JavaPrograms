import java.util.*;
import java.io.*;
public class outofplace {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("outofplace.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] heights = new int[N];
        for(int i=0; i<N; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            heights[i]=Integer.parseInt(c.nextToken());
        }
        int BessieIndex=0;
        int Bessie=0;
        /*
        for(int i=0; i<N-1; i++) {
            if(heights[i]>heights[i+1]) {
                Bessie = heights[i+1];
                BessieIndex = i+1;
                break;
            }
        }
        */
        boolean BessieisBehind = true;
        for(int i=0; i<N-2; i++) {
            if(heights[i]>heights[i+1]&&heights[i+1]<heights[i+2]&&heights[i+2]>=heights[i]) {
                BessieisBehind = true;
                BessieIndex = i+1;
                Bessie = heights[i+1];
                break;
            }
            else if(heights[i+1]>heights[i]&&heights[i+2]<heights[i+1]&&heights[i+2]>=heights[i]) {
                BessieisBehind = false;
                BessieIndex = i+1;
                Bessie = heights[i+1];
                break;
            }
        }
        if(heights[N-1]<heights[N-2]) {
            BessieisBehind = true;
            BessieIndex = N-1;
            Bessie = heights[N-1];
        }
        if(heights[0]>heights[1]) {
            BessieisBehind = false;
            BessieIndex = 0;
            Bessie = heights[0];
        }
        int count = 0;
        if(BessieisBehind == true) {
            for (int i = BessieIndex; i > 0; i--) {
                if (heights[i - 1] > Bessie && heights[i - 1] != heights[i]) {
                    count++;
                }
            }
        }
        else {
            for(int i=BessieIndex; i<N-1; i++) {
                if(heights[i+1]<Bessie&&heights[i+1]!=heights[i]) {
                    count++;
                }
            }
        }
        out.println(count);
        out.close();
    }
}
