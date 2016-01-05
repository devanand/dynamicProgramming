package dynamicprogramming;

import java.util.Scanner;

public class MaxContiguous {

	public static void maxContiguous(long a[]) {
		long max_sum=0;
		long start_index=-1, end_index=-1;
		int i=0;
		long current_sum=0, current_start_index=-1, current_end_index=-1;
		long max_number = Integer.MIN_VALUE, nonCongruous=0;
		boolean isAllNegative = true;
		while(i<a.length) {
			if(a[i]>max_number) {
				max_number = a[i];
			}
			if(a[i]>0) {
				nonCongruous = nonCongruous + a[i];
				isAllNegative = false;
			}
			
			long val = current_sum +a[i];
			if(val > 0) {
				if(current_sum == 0) {
					current_start_index = i;
				}
				current_sum = val;
			} else {
				current_sum = 0;
			}

			if(current_sum>max_sum) {
				max_sum = current_sum;
				start_index = current_start_index;
				end_index = i;
			}
			i++;
		}
		
		System.out.print((isAllNegative?max_number:max_sum)+" ");
		System.out.print(isAllNegative?max_number:nonCongruous);
		
	}
	public static void main(String[] args) {
		long ar[]={2, -1, 2, 3, 4, -5};
		maxContiguous(ar);
	}
}
