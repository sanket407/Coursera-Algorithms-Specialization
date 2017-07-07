package Course3.Week1;

import java.io.*;
import java.util.*;

public class Prims {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> adj[] = new ArrayList[n];
		ArrayList<Long> cost[] = new ArrayList[n];
		
		for(int i=0; i<n; i++)
			{
				adj[i] = new ArrayList<Integer>();
				cost[i] = new ArrayList<Long>();
			}
		
		for(int i=0; i<m; i++)
		{
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			long c = Integer.parseInt(st.nextToken());
			
			adj[u].add(v);
			adj[v].add(u);
			cost[u].add(c);
			cost[v].add(c);
		}
		
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>(new Comparator<Vertex>(){
			
			public int compare(Vertex v1,Vertex v2)
			{
				if(v1.c < v2.c)
					return -1;
				else if(v1.c > v2.c)
					return 1;
				else return 0;
			}
			
		});
		
		pq.add(new Vertex(0,0));
		boolean done[] = new boolean[n];
		long mst = 0;
		
		while(!pq.isEmpty())
		{
			Vertex curr = pq.remove();
			int x = curr.x;
			long c = curr.c;
			
			if(done[x]) continue;
			done[x] = true;
			mst += c;
			
			for(int i=0; i<adj[x].size(); i++)
			{
				if(!done[adj[x].get(i)])
				{
					pq.add(new Vertex(adj[x].get(i),cost[x].get(i)));
				}
			}
		}
		
		System.out.println(mst);
		
	}

	static class Vertex{
		
		int x;
		long c;
		Vertex(int x,long c)
		{
			this.x = x;
			this.c = c;
		}
	}
	
}
