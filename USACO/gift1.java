/*
ID: bryanya1
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;
public class gift1 {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		
		int numberOfPlayers = Integer.parseInt(f.readLine());
		
		int[] money = new int[numberOfPlayers];
		String[] players = new String[numberOfPlayers];
		for(int i = 0; i < numberOfPlayers; i++) {
			players[i] = f.readLine();
			money[i] = 0;
		}
		
		for(int i  = 0; i < numberOfPlayers; i++) {
			
			String currentGiver = f.readLine();
			StringTokenizer st = new StringTokenizer(f.readLine());
			int givingAmount = Integer.parseInt(st.nextToken());
			int numberOfFriends = Integer.parseInt(st.nextToken());
			
			int giverPos = getPos(players, currentGiver);
			money[giverPos] -= givingAmount;
			
			
			int individualAmount = 0;
			if(numberOfFriends > 0) individualAmount = givingAmount/numberOfFriends;
			int leftOver = givingAmount - individualAmount*numberOfFriends;
			money[giverPos] += leftOver;
			
		for(int j = 0; j < numberOfFriends; j++) {
			
			String receiver = f.readLine();
			int receiverPos = getPos(players, receiver);
			money[receiverPos] += individualAmount;
			}
		}
		for(int i  = 0; i < numberOfPlayers; i++) 
			out.println(players[i] + " " + money[i]); 
		out.close();
	}
	public static int getPos(String[] players, String inputPlayer) {
		
	for(int i = 0; i < players.length; i++)		
		if(players[i].equalsIgnoreCase(inputPlayer)) return i;
		return -1;
	}
}