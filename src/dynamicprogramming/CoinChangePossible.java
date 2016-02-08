package dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChangePossible {

	static long coinChange(int coins[], int size, int amount) {
		long memo[] = new long[amount+1];
		memo[0] = 1;
		for(int i=0;i<size;i++) {
			for(int j=coins[i];j<=amount;j++) {
				memo[j] += memo[j-coins[i]];
			}
		}
		System.out.println(Arrays.toString(memo));
		return memo[amount];
		
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String mn[]=s.nextLine().split(" ");
		int amount = Integer.parseInt(mn[0]);
		int coins[] = new int[Integer.parseInt(mn[1])];
		String coinBuffer[] = s.nextLine().split(" ");
		
		for(int i=0;i<coins.length;i++) {
			coins[i] = Integer.parseInt(coinBuffer[i]);
		}
		
		System.out.println(coinChange(coins, coins.length, amount));
	}
}

