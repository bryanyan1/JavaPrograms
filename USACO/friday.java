/*
ID: bryanya1
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

public class friday{
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("friday.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
		
		int numberOfYears = Integer.parseInt(f.readLine());
		int freq[] = new int[7];
		Arrays.fill(freq,0);
		
		int calendarDay = 0;
		int[] regularDays = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
		int[] leapDays = new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
		int endYear = 1900+numberOfYears;
		for(int year = 1900; year < endYear; year++) {
			for(int month = 0; month < 12; month++) {
				int day = (calendarDay+12)%7;
				freq[day]++;
				if(isLeapYear(year)==true) {
					calendarDay+=leapDays[month];
				}
				else
					calendarDay+=regularDays[month];
			}
		}
		out.print(freq[5]);
		out.print(" ");
		out.print(freq[6]);
		out.print(" ");
		out.print(freq[0]);
		out.print(" ");
		out.print(freq[1]);
		out.print(" ");
		out.print(freq[2]);
		out.print(" ");
		out.print(freq[3]);
		out.print(" ");
		out.print(freq[4]);
		out.print("\n");
		
		out.close();
	}
	public static boolean isLeapYear(int year) {
		if(year%400==0)
			return true;
		else if(year%100==0)
			return false;
		else if(year%4==0)
			return true;
		else
			return false;
	}
}