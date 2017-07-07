package Course3.Week4;

import java.io.*;
import java.util.*;

public class Knapsack2 {
	static int capacity,n,w[];
	static long  val[];
	static HashMap<Pair,Long> map;
	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\SAWANT\\Desktop\\knapsack2.txt"));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		 capacity = Integer.parseInt(st.nextToken());
		 n = Integer.parseInt(st.nextToken());
		
		 w = new int[n+1];
		 val = new long[n+1];
		
		map = new HashMap<Pair,Long>();
		
		for(int i=1; i<=n; i++)
		{
			st = new StringTokenizer(br.readLine());
			val[i] = Integer.parseInt(st.nextToken());
			w[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(find(n,capacity));
		
		
	}
	
	static long find(int i,int j)
	{
		if(i == 0 || j == 0)
			return 0L;
		
		Pair curr = new Pair(i,j);
		
		if(map.containsKey(curr))
			return map.get(curr);
		
		long ans = -1;
		
		if(j < w[i])
			ans = find(i-1,j);
		else
			ans = Math.max(find(i-1, j), val[i] + find(i-1,j-w[i]));
		
		map.put(curr, ans);
		
		return ans;
			
	}
	
	static class Pair{
		int i,j;
		Pair(int i,int j)
		{
			this.i = i;
			this.j = j;
		}
		
		 @Override
		    public int hashCode() {
		        final int prime = 1000000007;
		        
		        long product = i*j;
		        
		        int result =(int)( product % prime);
		        
		        return result;
		    }

		    @Override
		    public boolean equals(final Object obj) {
		        if (this == obj)
		            return true;
		        if (obj == null)
		            return false;
		        if (getClass() != obj.getClass())
		            return false;
		        final Pair other = (Pair) obj;
		       
		        if(other.hashCode() != this.hashCode())
		        	return false;
		        
		        if(other.i != this.i)
		        	return false;
		        if(other.j != this.j)
		        	return false;
		        
		        return true;
		    }
		
	}

}
