
import java.io.*;
import java.util.Arrays;

public class CountInv {     //Counting Inversions

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 100000;
		int a[] = new int[n];
		for(int i=0; i<n; i++)
			a[i] = Integer.parseInt(br.readLine());
		
		//System.out.println(Arrays.toString(a));
		System.out.println(countInv(a,n));
		//System.out.println(Arrays.toString(a));
		
	}
	
	static long countInv(int a[],int n)
	{
		if(n == 1)
			return 0L;
		
		int mid = (n+1)/2;
		int l[] = new int[mid];
		int r[] = new int[n-mid];
		
		for(int i=0,k=0; i<mid; i++,k++)
			l[k] = a[i];
		
		for(int j=mid,k=0; j<n; j++,k++)
			r[k] = a[j];
		
		long res = 0L;
		
		res += countInv(l,mid);
		res += countInv(r,n-mid);
		res += merge(a,n,l,mid,r,n-mid);
		
	
		
		return res;
	}
	
	static long merge(int a[],int n,int l[],int ln,int r[],int rn)
	{
		int i=0,j=0,k=0;
		long inv = 0L;
		
		while(i<ln && j<rn)
		{
			if(l[i] <= r[j])
				a[k++] = l[i++];
			else
			{
				inv += (ln-i);
				a[k++] = r[j++];
			}
		}
		
		while(i < ln)
		{
			
			a[k++] = l[i++];
		}
		
		while(j < rn)
		{
			a[k++] = r[j++];
		}
		
		return inv;
		
	}
	
}
