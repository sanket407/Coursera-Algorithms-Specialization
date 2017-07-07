package Course3.Week2;

import java.io.*;
import java.util.*;

public class ClusteringBig {
	static HashMap<Integer,Integer> par;
	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\SAWANT\\Desktop\\clustering2.txt"));
		
		HashSet<Integer> set = new HashSet<Integer>();
		par = new HashMap<Integer,Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++)
		{
			st = new StringTokenizer(br.readLine());
			int node = 0;
			for(int j=23; j>=0; j--)
			{
				int bit = Integer.parseInt(st.nextToken());
				node += bit * ( 1 << j);
			}
			
			set.add(node);
			par.put(node,-1);
		}
		
		Iterator<Integer> ir = set.iterator();
		
		while(ir.hasNext())
		{
			int x = ir.next();
			for(int i=0; i<24; i++)
			{
				int tmp = x;
				tmp ^= (1<<i);
				if(set.contains(tmp))
				{	
					//System.out.println(x+" "+tmp);
					merge(tmp,x);
					
				}
			}
			
			for(int i=0; i<24; i++)
			{
				for(int j=0; j<24; j++)
				{
					if(i == j ) continue;
					int tmp = x;
					
					tmp ^= (1<<i);
					tmp ^= (1<<j);
					
					if(set.contains(tmp))
					{
						
						merge(tmp,x);
						
					}
				}
			}
		}
		
		ir = set.iterator();
		HashSet <Integer> clusters = new HashSet<Integer>();
		
		while(ir.hasNext())
		{
			int x = root(ir.next());
			//System.out.println(x);
			clusters.add(x);
		}
		
		System.out.println(clusters.size());
		
	}
	
	static void merge(int x,int y)
	{
		x = root(x);
		///System.out.println("---");
		y = root(y);
		
		if(x == y) return;
		
		if(par.get(x) < par.get(y))
		{
			int tmp = x;
			x = y;
			y = tmp;
		}
		//System.out.println("(((");
		//System.out.println(x+" "+y);
		//System.out.println(par.get(x)+" "+par.get(y));
		par.put(y, par.get(y)+ par.get(x));
		par.put(x,y);
		//if(y == 5767287)
		//	System.out.println("***");
	}
	
	static int root(int x)
	{	
		//System.out.println(x);
		//System.out.println(par.containsKey(x));
		//System.out.println(x+" "+par.get(x));
		//return par.get(x) < 0 ? x : (par.put(x, root(par.get(x))));
		if(par.get(x) < 0)
			return x;
		else
		{
			int p  = root(par.get(x));
			par.put(x, p);
			return p;
		}
	}
	

}
