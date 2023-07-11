import java.util.*;
import java.io.*;
public class cownomics {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] genomes = new String[2*N];
        for(int i=0; i<2*N; i++) {
            st = new StringTokenizer(f.readLine());
            genomes[i] = st.nextToken();
        }
        int count = 0;
        for(int i=0; i<M-2; i++) {
            for(int j=i+1; j<M-1; j++) {
                for(int k=j+1; k<M; k++) {
                    boolean istrue = true;
                    for(int l=0; l<N; l++) {
                        boolean willbreak = false;
                        for(int m=N; m<2*N; m++) {
                            if(genomes[l].charAt(i)==genomes[m].charAt(i)&&genomes[l].charAt(j)==genomes[m].charAt(j)&&genomes[l].charAt(k)==genomes[m].charAt(k)) {
                                istrue = false;
                                willbreak = true;
                                break;
                            }
                        }
                        if(willbreak==true) break;
                    }
                    if(istrue==true) count++;
                }
            }
        }
        out.println(count);
        out.close();
    }
}
