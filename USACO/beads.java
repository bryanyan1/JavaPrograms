/*
ID: bryanya1
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;
public class beads {
    public static void main(String[] args)throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		int numberOfBeads = Integer.parseInt(f.readLine());
		String beads = f.readLine();
        char beadarray[] = beads.toCharArray();
        int maximum=0;
        int currentColor;
		//out.println(hastheRed);
        String beads2 = beads + beads;
        char beadString[] = beads2.toCharArray();
		if(hasRed(numberOfBeads, beadString)==true&&hasBlue(numberOfBeads, beadString)==true) {
        ArrayList<Integer> beadCount = new ArrayList<Integer>();
        ArrayList<Integer> beadCount2 = new ArrayList<Integer>();
        for (int i = 1; i < beads2.length(); i++) {
            if (beadString[i] == 'b'||nextColor(i,beadString, numberOfBeads)=='b') {
                int count = 1;
                for (int j = 1; j < ((beads2.length()) - i); j++) {
                    if (beadString[i + j] == 'b' || beadString[i + j] == 'w') {
                        count++;
                    } else
                        break;
                }
                beadCount.add(count);
            } else if (beadString[i] == 'r'||nextColor(i,beadString, numberOfBeads)=='r') {
                int count = 1;
                for (int j = 1; j < ((beads2.length()) - i); j++) {
                    if (beadString[i + j] == 'r' || beadString[i + j] == 'w') {
                        count++;
                    } else
                        break;
                }
                beadCount.add(count);
            } else
                beadCount.add(0);

            //System.out.println("color: "+nextColor(i, beadString, numberOfBeads));
        }
        for (int i = 1; i < beads2.length(); i++) {
            int b=i;
            if (beadString[i-1] == 'b'||lastColor(i-1,beadString, numberOfBeads)=='b') {
                int count = 0;
                for (int j = 1; j <= i; j++) {
                    if (beadString[i - j] == 'b' || beadString[i - j] == 'w') {
                        count++;
                    } else
                        break;
                }
                beadCount2.add(count);
            } else if (beadString[i-1] == 'r'||lastColor(i-1, beadString, numberOfBeads)=='r') {
                int count = 0;
                for (int j = 1; j <=i; j++) {
                    if (beadString[i - j] == 'r' || beadString[i - j] == 'w') {
                        count++;
                    } else
                        break;
                }
                //System.out.println("other: "+lastColor(i, beadString, numberOfBeads));
                beadCount2.add(count);
            }
        }
        //System.out.println(beadCount);
        //System.out.println(beadCount2);
        ArrayList<Integer> size = new ArrayList<Integer>();
        for(int i=0;i<beadCount.size();i++) {
            size.add(beadCount.get(i)+beadCount2.get(i));
        }
        maximum = size.get(0);
        for(int i=1;i<size.size();i++){
            if(size.get(i)>maximum){
                maximum=size.get(i);
            }
        }}
		else{
			maximum=numberOfBeads;
		}
		if(maximum>numberOfBeads) {
			maximum=numberOfBeads;
		}

        out.println(maximum);
        out.close();
	}
    public static char nextColor(int a, char[] beadString, int numberOfBeads) {
            for(int i=a; i<2*numberOfBeads; i++) {
                if(beadString[i]!='w') {
                    return beadString[i];
                }
            }
            return lastColor(a, beadString, numberOfBeads);
    }
    public static char lastColor(int b, char[] beadString, int numberOfBeads) {
            for(int i=b; i>=0; i--) {
                if(beadString[i]!='w')
                    return beadString[i];
            }
        return nextColor(b, beadString, numberOfBeads);
    }
	public static boolean hasRed(int numberOfBeads, char[] beadString) {
		for(int i=0; i<2*numberOfBeads; i++) {
			if(beadString[i]=='r')
				return true;
		}

		return false;
	}
	
	public static boolean hasBlue(int numberOfBeads, char[] beadString) {
		for(int i=0; i<2*numberOfBeads; i++) {
			if(beadString[i]=='b')
				return true;
		}
		return false;
	}
}


