package dynamicprogramming;

public class StockExchange {
	static void findStock(int a[]) {
		long purchased = a[0], stock = 1;
		
		long profit = 0;
		int startIndex = 1, endIndex = a.length-1;
		while(true) {
			endIndex = findMax(a, startIndex, endIndex);
			for(int i=startIndex;i<endIndex;i++) {
				stock++;
				purchased += a[i];
			}
			profit = profit + (stock*a[endIndex]) - purchased;
			startIndex = endIndex+2;
			if(startIndex>a.length-1) break;
			purchased = a[startIndex-1];
		}
		System.out.println(profit<0?0:profit);
	}
	
	static int findMax(int a[], int startIndex, int endIndex) {
		
		int maxVal = a[startIndex], max = startIndex;
		for(int i=startIndex+1;i<=endIndex;i++) {
			if(a[i] >= maxVal) {
				maxVal = a[i];
				max = i;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int a[] = {5};
		findStock(a);
	}
}
