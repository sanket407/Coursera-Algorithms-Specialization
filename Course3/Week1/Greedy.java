package Course3.Week1;

import java.io.*;
import java.util.*;

public class Greedy {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Job a[] = new Job[n];
		
		for(int i=0; i<n; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int w = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());
				a[i] = new Job(w,l);
			}
		
		
		
		System.out.println(compute1(n,a));
		System.out.println(compute2(n,a));
	}

	static long compute2(int n,Job a[])
	{
		Arrays.sort(a,new Comparator<Job>(){
			
			public int compare(Job j1,Job j2)
			{
				double r1 = (double)j1.w/j1.l;
				double r2 = (double)j2.w/j2.l;
				
				if(r1 > r2)
					return -1;
				else if(r1 < r2)
					return 1;
				else return 0;
			}
		});
		
		long ans = 0;
		long time = 0;
		for(int i=0; i<n; i++)
		{
			time += a[i].l;
			ans += a[i].w*time;
		}
		
		return ans;
	}
	
	static long compute1(int n,Job a[])
	{
		Arrays.sort(a,new Comparator<Job>(){
			
			public int compare(Job j1,Job j2)
			{
				if(j1.w - j1.l != j2.w - j2.l)
					return (j2.w - j2.l) - (j1.w - j1.l);
				else
					return j2.w - j1.w;
			}
		});
		
		long ans = 0;
		long time = 0;
		for(int i=0; i<n; i++)
		{
			time += a[i].l;
			ans += a[i].w*time;
		}
		
		return ans;
		
	}
	
	static class Job{
		
		int w,l;
		
		Job(int w,int l)
		{
			this.w = w;
			this.l = l;
		}
	}
}
