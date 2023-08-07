/*
ID: bryanya1
LANG: JAVA
TASK: namenum
*/
import java.io.*;
import java.util.*;


public class namenum {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
        BufferedReader c = new BufferedReader(new FileReader("dict.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        String number = f.readLine();
		boolean hasPrinted = false;
        char[] x = number.toCharArray();
        ArrayList<String> names = new ArrayList<String>();
        for (int i = 0; i < 4617; i++) {
            StringTokenizer st = new StringTokenizer(c.readLine());
            while (st.hasMoreTokens()) {
                names.add(st.nextToken());
            }
        }
        for(String nam : names) {
            if(nam.length()==x.length) {
                if(isEqual(getNumber(nam), x)){
					hasPrinted = true;
                    out.println(nam);
            }
		}
        }
		if(hasPrinted==false)
			out.println("NONE");
		out.close();


    }
    public static char[] getNumber(String a) {
        char[] number = new char[a.length()];
        char[] y = a.toCharArray();
        for(int i=0 ; i<a.length(); i++) {
            number[i]=(getValue(y[i]));
        }
        return number;
    }
    public static char getValue(char j) {
        if(j=='A'||j=='B'||j=='C')
            return '2';
        else if(j=='D'||j=='E'||j=='F')
            return '3';
        else if(j=='G'||j=='H'||j=='I')
            return '4';
        else if(j=='J'||j=='K'||j=='L')
            return '5';
        else if(j=='M'||j=='N'||j=='O')
            return '6';
        else if(j=='P'||j=='R'||j=='S')
            return '7';
        else if(j=='T'||j=='U'||j=='V')
            return '8';
        else if(j=='W'||j=='X'||j=='Y')
            return '9';
        else
            return '0';
    }
    public static boolean isEqual(char[] ab, char[] bc) {
        for(int i=0; i<ab.length; i++) {
            if(ab[i]!=bc[i])
                return false;
        }
        return true;
    }
}
