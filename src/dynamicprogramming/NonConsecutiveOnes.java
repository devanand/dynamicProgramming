package dynamicprogramming;

public class NonConsecutiveOnes {

	static void findNonConsecutiveOnes(int n) {
		int a[] = new int[n];
		int b[] = new int[n];
		
		a[0] = b[0] = 1;
		for(int i=1;i<n;i++) {
			a[i] = a[i-1]+b[i-1];
			b[i] = a[i-1];
		}
		
		System.out.println(a[n-1]+b[n-1]);
	}
	
	static void findNonConsecutiveSimple(int n) {
		 
		int a1=2;
		int a2 = 3;
		for(int i=2;i<n;i++) {
			int a3=a1+a2;
			a1=a2;
			a2=a3;
		}
		System.out.println(a2);
	}
	public static void main(String[] args) {
		findNonConsecutiveOnes(8);
		findNonConsecutiveSimple(8);
	}
}
