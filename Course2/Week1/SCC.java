package Course2.Week1;

import java.io.*;
import java.util.*;

public class SCC {
	public static ArrayList<Integer> adj[],rev[];
	public static int visited[];
	public static int n,time,ft[],leader[];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// br = new BufferedReader(new InputStreamReader(System.in));
		
		
		FileReader fr = new FileReader("C:\\Users\\SAWANT\\Desktop\\scc.txt");
		BufferedReader  br = new BufferedReader(fr);		
		
		
		n = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[n];
		rev = new ArrayList[n];
		for(int i=0; i<n; i++)
			{
				adj[i] = new ArrayList<Integer>();
				rev[i] = new ArrayList<Integer>();
			}
		
		while(true)
		{
			String line = br.readLine();
			if(line == null) break;
			StringTokenizer st = new StringTokenizer(line);
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			adj[x].add(y);
			rev[y].add(x);
		}
		
		visited = new int[n];
		time = 0;
		ft = new int[n];
		
		for(int i=0; i<n; i++)
			if(visited[i] == 0)
				dfs1(i);
		
		visited = new int[n];
		leader = new int[n];
		
		for(int i=n-1; i>=0; i--)
			if(visited[ft[i]] == 0)
				{
				dfs2(ft[i],ft[i]);
				
				}
		
		PriorityQueue <Integer> pq = new PriorityQueue<Integer>();
		
		for(int i=0; i<n; i++)
		{
			pq.add(-1*leader[i]);
		}
		
		for(int i=0; i<5; i++)
		{
			System.out.println(-1*pq.remove());
		}
		
	}
		static void dfs2(int curr,int x)
		{
			
			Stack<Integer> s = new Stack<Integer>();
			s.push(curr);
			
			while(!s.isEmpty())
			{
				curr = s.pop();
				
				if(visited[curr] == 1) continue;
				visited[curr] = 1;
				leader[x]++;
			
				for(int next : rev[curr] )
					if(visited[next] == 0)
						s.push(next);
			}
			
		}
		static void dfs1(int curr)
		{
			Stack<Integer> s = new Stack<Integer>();
			s.push(curr);
			 
			
			//System.out.println("---");
			while(!s.isEmpty())
			{
				curr = s.pop();
				//System.out.println(curr);
				if(visited[curr] == 2) continue;
				if(visited[curr] == 1)
				{
					ft[time++] = curr;
					visited[curr] = 2;
					continue;
				}
				visited[curr] = 1;
				s.push(curr);
				for(int next : adj[curr])
				{	
					if(visited[next] == 0)
					{
						s.push(next);
					}
				}
				
				
			}	
				
			
			
		}
	
}
