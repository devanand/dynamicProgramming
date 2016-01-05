package dynamicprogramming;
import java.util.Arrays;


public class LongestIncreasingMatrix {

	
	static int longestDecreasing(int mat[][], int memo[][], int i, int j, int sumMemo[][]) {
		if(i<0||i>=memo[0].length||j<0||j>=memo.length) {
			return 0;
		}
		
		if(memo[i][j] != 0) return memo[i][j];
		//int right = 0, left = 0, top = 0, bottom = 0;
		int max = 0, sumMax = mat[i][j];
		if((j+1)<memo.length && mat[i][j+1]<mat[i][j]) {
			int right = longestDecreasing(mat, memo, i, j+1, sumMemo);
			if(right>max) {
				max = right;
			}
			int sumTempRight = mat[i][j]+(sumMemo[i][j+1] == 0?mat[i][j+1]:sumMemo[i][j+1]);
			if(sumTempRight>sumMax) {
				sumMax = sumTempRight;
			}
		}
		
		if(j-1>=0 && mat[i][j-1]<mat[i][j]) {
			
			int left = longestDecreasing(mat, memo, i, j-1, sumMemo);
			if(left>max)
				max = left;
			int sumTempLeft = mat[i][j]+(sumMemo[i][j-1] == 0?mat[i][j-1]:sumMemo[i][j-1]);
			if(sumTempLeft>sumMax) {
				sumMax = sumTempLeft;
			}
		}
		if((i+1)<memo[0].length && mat[i+1][j]<mat[i][j]) {
			int bottom = longestDecreasing(mat, memo, i+1, j, sumMemo);
			if(bottom>max) 
				max = bottom;
			int sumTempBottom = mat[i][j]+(sumMemo[i+1][j] == 0?mat[i+1][j]:sumMemo[i+1][j]);
			if(sumTempBottom>sumMax) {
				sumMax = sumTempBottom;
			}
		}
		if((i-1)>=0 && mat[i-1][j]<mat[i][j]) {
			int top = longestDecreasing(mat, memo, i-1, j, sumMemo);
			if(top>max) 
				max = top;
			int sumTempTop = mat[i][j]+(sumMemo[i-1][j] == 0?mat[i-1][j]:sumMemo[i-1][j]);
			if(sumTempTop>sumMax) {
				sumMax = sumTempTop;
			}
		}
		
		sumMemo[i][j] = sumMax;
 		if(max != 0) {
			return memo[i][j] = max+1;
		}
		
		return memo[i][j] = 1;
	}
	
	static int longestDecreasingDepth(int mat[][], int memo[][], int i, int j, int x, int y, int sumMemo[][]) {

		//int maxPath=0;
		if(memo[i][j] != 0) {
			int temp = (mat[x][y] - mat[i][j])+sumMemo[i][j];
			if(temp>sumMemo[x][y]) {
				 sumMemo[x][y]=temp;
			}
			return memo[i][j];
		}
		int max = 0;
		if((j+1)<memo.length && mat[i][j+1]<mat[i][j]) {
			int right = longestDecreasingDepth(mat, memo, i, j+1, i, j, sumMemo);
			if(right>max) 
				max = right;
		}
		
		if(j-1>=0 && mat[i][j-1]<mat[i][j]) {
			int left = longestDecreasingDepth(mat, memo, i, j-1, i, j, sumMemo);
			if(left>max)
				max = left;
			
		}
		
		if((i+1)<memo[0].length && mat[i+1][j]<mat[i][j]) {
			int bottom = longestDecreasingDepth(mat, memo, i+1, j, i, j, sumMemo);
			if(bottom>max) 
				max = bottom;
			
		}
		if((i-1)>=0 && mat[i-1][j]<mat[i][j]) {
			int top = longestDecreasingDepth(mat, memo, i-1, j, i, j, sumMemo);
			if(top>max) 
				max = top;
		}
		
		
 		if(max != 0) {
 			int temp = (mat[x][y] - mat[i][j])+sumMemo[i][j];
 			if(temp>sumMemo[x][y]) {
				 sumMemo[x][y]=temp;
			}
			return memo[i][j] = max+1;
		}
 		else {
 			int temp = mat[x][y]-mat[i][j];
 			if(temp>sumMemo[x][y]) {
				 sumMemo[x][y]=temp;
			}
 			return memo[i][j] = 1;
 		}
		
	}
	

	
	public static void main(String[] args) {
		int mat[][] = {{4, 8, 7, 3},
					   {2, 5, 9, 3},
					   {6, 3, 2, 5},
					   {4, 4, 1, 6}};
		
		int memoDecrease[][] = new int[mat.length][mat[0].length];
		int sumMemo[][] = new int[mat.length][mat[0].length];
		
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[0].length;j++) {
				//longestDecreasing(mat, memoDecrease, i, j, sumMemo);
				longestDecreasingDepth(mat, memoDecrease, i, j, i, j, sumMemo);
			}
		}
		
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[i].length;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("\n");
		
		for(int i=0;i<memoDecrease.length;i++) {
			for(int j=0;j<memoDecrease[i].length;j++) {
				System.out.print(memoDecrease[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("\n");
		
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[i].length;j++) {
				System.out.print(sumMemo[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
