package dynamicprogramming;

public class WineProfit {

	
	static int cache[][] = new int[5][5];
	
	public static int profit(int year, int be, int en, int p[]) {
		if(be>en) return 0;
		
		
		int profit1 =  profit(year+1, be+1, en, p)+year*p[be];
		int profit2 =  profit(year+1, be, en-1, p)+year*p[en];
		if(cache[be][en] != 0) return cache[be][en];
		
		return cache[be][en] = Math.max(profit2, profit1);
	}
	
	public static void main(String[] args) {
		int p[] = {2, 3, 5, 1, 4};
		final long start = System.currentTimeMillis();
		System.out.println(profit(1, 0, 4, p));
		final long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
}
