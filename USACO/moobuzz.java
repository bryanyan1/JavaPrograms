import java.util.*;
import java.io.*;
public class moobuzz {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("moobuzz.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        double x  = N-0.1;
        int number = (int)(x/8);
        int mod = N%8;
        if(mod==1) out.println(number*15+1);
        else if(mod==2) out.println(number*15+2);
        else if(mod==3) out.println(number*15+4);
        else if(mod==4) out.println(number*15+7);
        else if(mod==5) out.println(number*15+8);
        else if(mod==6) out.println(number*15+11);
        else if(mod==7) out.println(number*15+13);
        else if(mod==0) out.println(number*15+14);
        out.close();
    }
}
