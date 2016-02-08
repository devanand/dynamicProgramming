package dynamicprogramming;

import java.util.Arrays;

public class CoinChange {

	
	static void coinChange1(int dollars, int coins[]) {
		int memo[]=new int[dollars+1];
		for(int x = 0;x<=dollars;x++) {
			memo[x] = Integer.MAX_VALUE;
		}
		memo[0] = 0;
		for(int i = 1;i<=dollars;i++) {
			for(int coin:coins) {
				if(coin<=i && memo[i-coin]<memo[i]) {
					memo[i] = memo[i-coin]+1;
				}
			}
		}
		System.out.println(memo[dollars]);
		System.out.println(Arrays.toString(memo));
	}
	
	public static void main(String[] args) {
		int coins[]={2, 3, 5};
		coinChange1(11, coins);
	}
}
