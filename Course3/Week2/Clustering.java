package Course3.Week2;

import java.io.*;
import java.util.*;

public class Clustering {
	static int par[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\SAWANT\\Desktop\\clustering1.txt"));
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Edge> e = new ArrayList<Edge>();
		
		while(true)
		{
			String line = br.readLine();
			if(line == null) break;
			
			StringTokenizer st = new StringTokenizer(line);
			
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			
			e.add(new Edge(x,y,c));
			
		}
		
		Collections.sort(e,new Comparator<Edge>(){
			
			public int compare(Edge e1,Edge e2)

			{
				return e1.c - e2.c;
			}
		});
		
		int clusters = n;
		par = new int[n];
		int k = 4;
		int i = 0;
		Arrays.fill(par, -1);
		
		while(clusters > 4)
		{
			Edge next = e.get(i++);
			
			int x = next.x;
			int y = next.y;
			
			if(root(x) == root(y)) continue;
			
			merge(x,y);
			
			clusters--;
		}
		
		int ans = 100000000;
		
		for(Edge c:e)
			{
				if(root(c.x) != root(c.y))
					ans = Math.min(ans, c.c);
			}
		
		System.out.println(ans);
		
	}
	
	static void merge(int x,int y)
	
	{
		
		x = root(x);
		y = root(y);
		
		if(x == y) return;
		
		if(par[x] < par[y])
		{
			int tmp = x;
			x = y;
			y = tmp;
		}
		
		par[y] += par[x];
		par[x] = y;
		
	}
	
	static int root(int x)
	{
		return (par[x] < 0 ? x : (par[x] = root(par[x])));
	}
	
	static class Edge{
		
		int x,y,c;
		Edge(int x,int y,int c)
		{
			this.x = x;
			this.y = y;
			this.c = c ;
		}
	}
}
