import java.io.*;
import java.util.StringTokenizer;

public class mixmilk {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("mixmilk.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
        int[] capacity = new int[3];
        int[] amount = new int[3];
        for(int i=0; i<3; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            capacity[i] = Integer.parseInt(st.nextToken());
            amount[i] = Integer.parseInt(st.nextToken());
        }
        int currentbucket = 0;
        for(int i=0; i<100; i++) {
            if(currentbucket==0||currentbucket==1) {
                pour(currentbucket, capacity, amount);
                currentbucket++;
            }
            else {
                pour(currentbucket, capacity, amount);
                currentbucket=0;
            }
        }
        for(int i=0; i<3; i++) {
            out.println(amount[i]);
        }
        out.close();
    }
    public static void pour(int currentbucket, int[] capacity, int[] amount) {
        if(currentbucket==2) {
            if((capacity[0]-amount[0])>=(amount[2])) {
                amount[0]+=amount[2];
                amount[2]=0;
            }
            else {
                amount[2]-=(capacity[0]-amount[0]);
                amount[0]=capacity[0];
            }
        }
        else{
            if(capacity[currentbucket+1]-amount[currentbucket+1]>=amount[currentbucket]) {
                amount[currentbucket+1]+=amount[currentbucket];
                amount[currentbucket]=0;
            }
            else {
                amount[currentbucket]-=(capacity[currentbucket+1]-amount[currentbucket+1]);
                amount[currentbucket+1]=capacity[currentbucket+1];
            }
        }
    }
}
