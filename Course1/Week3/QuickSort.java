package Course1.Week3;

import java.io.*;
import java.util.Arrays;

public class QuickSort {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 10000;
		
		int a[] = new int[n];
		
		for(int i=0; i<n; i++)
		{
			a[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(quickSort(a,0,n-1));
	
		
		System.out.println(Arrays.toString(a));
	}
	
	
	static long quickSort(int a[],int l,int r)
	{
		if(l >= r)
			return 0;
		
		int pivot = partition3(a,l,r);
		
		long ans = 0L;
		
		ans += quickSort(a,l,pivot-1);
		
		ans += quickSort(a,pivot+1,r);
		
		return ans + (r-l) ;
	}
	
	static int partition3(int a[],int l,int r)
	{
		int pivot = -1;
		
		if((a[l] <= a[(l+r)/2]  && a[(l+r)/2] <= a[r]) || (a[l] >= a[(l+r)/2]  && a[(l+r)/2] >= a[r]))
		{
			 pivot = a[(l+r)/2];
			 a[(l+r)/2] = a[l];
			 a[l] = pivot;
		}
		else if((a[r] <= a[(l+r)/2]  && a[r] >= a[l]) || (a[r] >= a[(l+r)/2]  && a[r] <= a[l]))
		{
			 pivot = a[r];
			 a[r] = a[l];
			 a[l] = pivot;
		}
		else
		{
			pivot = a[l];
		}
		
		
		int i = l+1;
		
		for(int j=l+1; j<=r; j++)
		{	
			if(a[j] < pivot)
			{
				int tmp = a[j];
				a[j] = a[i];
				a[i] = tmp;
				i++;
			}
		}
		
		a[l] = a[i-1];
		a[i-1] = pivot;
		
		return i-1;
	}
	
	static int partition2(int a[],int l,int r)
	{
		int pivot = a[r];
		a[r] = a[l];
		a[l] = pivot;
		
		int i = l+1;
		
		for(int j=l+1; j<=r; j++)
		{	
			if(a[j] < pivot)
			{
				int tmp = a[j];
				a[j] = a[i];
				a[i] = tmp;
				i++;
			}
		}
		
		a[l] = a[i-1];
		a[i-1] = pivot;
		
		return i-1;
	}
	
	static int partition1(int a[],int l,int r)
	{
		int pivot = a[l];
		int i = l+1;
		
		for(int j=l+1; j<=r; j++)
		{	
			if(a[j] < pivot)
			{
				int tmp = a[j];
				a[j] = a[i];
				a[i] = tmp;
				i++;
			}
		}
		
		a[l] = a[i-1];
		a[i-1] = pivot;
		
		return i-1;
	}
}
