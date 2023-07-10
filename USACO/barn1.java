/*
ID: bryanya1
LANG: JAVA
TASK: barn1
*/
import java.io.*;
import java.util.*;
public class barn1 {
    public static void main(String[] args) throws IOException {
       /*
       1: no cow, not covered
       2: cow, not covered
       3: no cow, covered
       4: cow, covered
       */
        BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] hasCow = new int[S];
        Arrays.fill(hasCow, 1);
        for(int i=0; i<C; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            hasCow[Integer.parseInt(c.nextToken())-1] = 2;
        }
        int last2 = last2(hasCow);
        for(int i=first2(hasCow); i<=last2; i++) {
            if(hasCow[i]==2)
                hasCow[i]=4;
            else
                hasCow[i]=3;
        }
        for(int i=1; i<M; i++) {
                removeSection(hasCow);
        }
        int count1 = 0;
        for(int i=0; i<hasCow.length; i++) {
            if(hasCow[i]==3||hasCow[i]==4)
                count1++;
        }
        out.println(count1);
        out.close();
    }
    public static void removeSection(int[] a) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> endIndex = new ArrayList<Integer>();
        int count = 0;
        for(int i=first2(a); i<=last2(a); i++) {
            if(a[i]==3) {
                count++;
            }
            else if(i>0&&a[i-1]==3){
                endIndex.add(i-1);
                list.add(count);
                count = 0;
            }
        }
        int max;
        if(list.size()==0) {
            return;
        }
        else {
            max = Collections.max(list);

        int b = list.indexOf(Collections.max(list));
        int endindex = endIndex.get(b);
        for(int i=endindex; i>endindex-max; i--) {
            a[i] = 1;
        }
        }
    }
    public static int first2(int[] a) {
        int firsttwo = 0;
        for(int i=0; i<a.length; i++) {
            if(a[i]==2) {
                firsttwo = i;
                break;
            }
        }
        return firsttwo;
    }
    public static int last2(int[] a) {
        int lasttwo=a.length-1;
        for(int i=a.length-1; i>=0; i--) {
            if(a[i]==2) {
                lasttwo = i;
                break;
            }
        }
        return lasttwo;
    }
}