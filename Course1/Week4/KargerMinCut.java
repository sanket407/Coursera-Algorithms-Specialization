package Course1.Week4;

import java.io.*;
import java.util.*;

public class KargerMinCut {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int v = 200;
		
		ArrayList<Edge> edges = new ArrayList<Edge>();
		
		int e = 0;
		
		for(int i=0; i<v; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			
			while(st.hasMoreTokens())
			{
				int d = Integer.parseInt(st.nextToken())-1;
				if(d < i) continue;
				edges.add(new Edge(i,d));
				e++;
			}
		}
		
		int min_cut = e + 5;
		Random r = new Random();
		for(int i=1; i<=50000; i++)
		{
			min_cut = Math.min(min_cut, kargers(v,e,edges,r.nextLong()));
		}
		System.out.println(min_cut);
	}

	static int kargers(int v,int e,ArrayList<Edge> edges,long seed)
	{
		int par[] = new int[v];
		Arrays.fill(par, -1);
		Random r = new Random(seed);
		
		while(v > 2)
		{
			int next = r.nextInt(e);
			
			int root1 = root(edges.get(next).s,par);
			int root2 = root(edges.get(next).d,par);
			
			if(root1 == root2)
				continue;
			//System.out.println(edges.get(next).s +" "+edges.get(next).d);
			v--;
			
			merge(edges.get(next).s,edges.get(next).d,par);
			
			
		}
		
		int c = 0;
		for(int i=0; i<e; i++)
		{
			int x = edges.get(i).s;
			int y = edges.get(i).d;
			
			if(root(x,par) !=  root(y,par))
			{	
				//System.out.println(x+" - "+y);
				c++;
			}
		}
		return c;
	}
	
	static void merge(int x,int y,int par[])
	{
		x = root(x,par);
		y = root(y,par);
		
		if(x == y)
			 return;
		
		if(x > y)
		{
			int tmp = x;
			x = y;
			y = tmp;
		}
		
		par[y] += par[x];
		par[x] = y;
		
		return;
	}
	
	static int root(int x,int par[])
	{	//System.out.println(x);
		return (par[x]<0 ? x : (par[x] = root(par[x],par)));
	}
	
	
		static class Edge{
			
			int s,d;
			
			Edge(int s,int d)
			{
				this.s = s;
				this.d = d;
			}
		}
	
}
