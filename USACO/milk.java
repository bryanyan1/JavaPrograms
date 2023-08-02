/*
ID: bryanya1
LANG: JAVA
TASK: milk
*/
import java.io.*;
import java.util.*;
public class milk {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int amount = Integer.parseInt(st.nextToken());
        int numberOfFarmers = Integer.parseInt(st.nextToken());
        int[] prices = new int[numberOfFarmers];
        int[] amountOfMilk = new int[numberOfFarmers];
        for(int i=0; i<numberOfFarmers; i++) {
            StringTokenizer c = new StringTokenizer(f.readLine());
            prices[i] = Integer.parseInt(c.nextToken());
            amountOfMilk[i] = Integer.parseInt(c.nextToken());
        }
        int moneySpent = 0;
        while(amount>0) {
            if(prices[getMinimum(prices)]<=1000&&amountOfMilk[getMinimum(prices)]<=2000000) {
                if(amount-((amountOfMilk[getMinimum(prices)]))>=0) {
                   moneySpent+=((amountOfMilk[getMinimum(prices)])*prices[getMinimum(prices)]);
                    amount-=((amountOfMilk[getMinimum(prices)]));
                    amountOfMilk[getMinimum(prices)]=2000001;
                    prices[getMinimum(prices)]=1001;
                }
                else {
                    moneySpent += prices[getMinimum(prices)];
                    amountOfMilk[getMinimum(prices)]--;
                    if (amountOfMilk[getMinimum(prices)] == 0) {
                        amountOfMilk[getMinimum(prices)] = 2000001;
                        prices[getMinimum(prices)] = 1001;
                    }

                    amount--;
                }
            }
            else
                break;
        }
        out.println(moneySpent);
        out.close();
    }
    public static int getMinimum(int[] a) {
        int min = a[0];
        int minIndex = 0;
        for(int i=0; i<a.length; i++) {
            if(a[i]<min){
                min = a[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
