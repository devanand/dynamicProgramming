package dynamicprogramming;

public class CountStringsWithoutConsecutiveOnes {

	public static int countStrings(int n) {
		int a[] = new int[n+1];
		int b[] = new int[n+1];
		
		a[1] = b[1] = 1;
		System.out.println(a[1]+b[1]);
		for(int i=2;i<=n;i++) {
			a[i] = a[i-1]+b[i-1];
			b[i] = a[i-1];
			System.out.println(a[i]+b[i]);
		}
		
		return a[n]+b[n];
	}
	
	public static void main(String[] args) {
		
		countStrings(8);
	}
}
