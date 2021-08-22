import java.util.*;
import java.io.*;
public class whereami {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("whereami.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        StringTokenizer c = new StringTokenizer(f.readLine());
        String houses = c.nextToken();
        for(int i=1; i<=N; i++) {
            ArrayList<String> arraylist= new ArrayList<String>();
            for(int j=0; j<=N-i; j++) {
                String s = houses.substring(j, j+i);
                arraylist.add(s);
            }
            if(isOkay(arraylist)) {
                out.println(i);
                break;
            }
        }
        out.close();
    }
    public static boolean isOkay(ArrayList<String> arraylist) {
        boolean isOK = true;
        for(int j=0; j<arraylist.size()-1; j++) {
            for(int k=j+1; k<arraylist.size(); k++) {
                if(arraylist.get(j).equals(arraylist.get(k))) return false;
            }
        }
        return true;
    }
}
