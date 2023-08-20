/*
ID: bryanya1
LANG: JAVA
TASK: transform
*/
import java.util.*;
import java.io.*;
public class transform {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("transform.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        int sideLength = Integer.parseInt(f.readLine());
        char[][] initialSquare = new char[sideLength][sideLength];
        char[][] finalSquare = new char[sideLength][sideLength];
        for(int i=0; i<sideLength; i++) {
            for(int j=0; j<sideLength; j++) {
                initialSquare[i][j] = (char) f.read();
            }
            f.readLine();
        }
        for(int i=0; i<sideLength; i++) {
            for(int j=0; j<sideLength; j++) {
                finalSquare[i][j] = (char) f.read();
            }
            f.readLine();
        }
		if(isEqual(rotate(initialSquare, sideLength), finalSquare, sideLength))
            out.println(1);
        else if(isEqual(finalSquare, rotate(rotate(initialSquare, sideLength), sideLength), sideLength))
            out.println(2);
        else if(isEqual(finalSquare, rotate(rotate(rotate(initialSquare, sideLength), sideLength), sideLength), sideLength))
            out.println(3);
        else if(isEqual(finalSquare, flip(initialSquare, sideLength), sideLength))
            out.println(4);
        else if(isEqual(finalSquare, rotate(flip(initialSquare, sideLength), sideLength), sideLength))
            out.println(5);
        else if(isEqual(finalSquare, rotate(rotate(flip(initialSquare, sideLength), sideLength), sideLength), sideLength))
            out.println(5);
        else if(isEqual(finalSquare, rotate(rotate(rotate(flip(initialSquare, sideLength), sideLength), sideLength), sideLength), sideLength))
            out.println(5);
        else if(isEqual(initialSquare, finalSquare, sideLength))
            out.println(6);
        else
            out.println(7);
        
        out.close();

    }
    public static char[][] rotate(char[][] initialSquare, int sideLength) {
        char[][] rotated = new char[sideLength][sideLength];
		for(int i=0; i<sideLength; i++) {
            for(int j=0; j<sideLength; j++) {
               rotated[i][j] = initialSquare[sideLength-j-1][i];
            }
        }
        return rotated;
	}
    public static char[][] flip(char[][] initialSquare, int sideLength) {
		char[][] flipped = new char[sideLength][sideLength];
        for(int i=0; i<sideLength; i++) {
            for(int j=0; j<sideLength; j++) {
                flipped[i][j] = initialSquare[i][sideLength-j-1];
            }
        }
		return flipped;
    }
	public static boolean isEqual(char[][] a, char[][] b, int sideLength) {
		for(int i=0; i<sideLength; i++){
			for(int j=0; j<sideLength; j++) {
				if(a[i][j]!=b[i][j])
					return false;
			}
		}
		return true;
	}
}
