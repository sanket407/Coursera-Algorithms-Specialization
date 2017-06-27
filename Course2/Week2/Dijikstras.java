package Course2.Week2;

import java.io.*;
import java.util.*;

public class Dijikstras {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 200;
		
		ArrayList<Integer> adj[] = new ArrayList[n];
		ArrayList<Integer> cost[] = new ArrayList[n];
		for(int i=0; i<n; i++)
		{
			adj[i] = new ArrayList<Integer>();
			cost[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			st.nextToken();
			
			while(st.hasMoreTokens())
			{
				String a[] = st.nextToken().split(",");
				int j = Integer.parseInt(a[0])-1;
				int x = Integer.parseInt(a[1]);
				adj[i].add(j);
				cost[i].add(x);
				adj[j].add(i);
				cost[j].add(x);
			}
		}
			PriorityQueue <State> pq = new PriorityQueue<State>(new Comparator<State>(){
				
				public int compare(State s1,State s2)
				{
					return s1.cost - s2.cost;
				}
				
			});
			
			int ans[] = new int[n];
			Arrays.fill(ans, 1000000);
			ans[0] = 0;
			int prev[] = new int[n];
			pq.add(new State(0,0,-1));
			
			boolean done[] = new boolean[n];
			
			while(!pq.isEmpty())
			{
				State s = pq.poll();
				
				int curr = s.x;
				int cst = s.cost;
				
				if(done[curr]) continue;
				
				done[curr] = true;
				ans[curr] = cst;
				prev[curr] = s.prev;
				
				for(int i = 0; i<adj[curr].size(); i++)
				{
					int next = adj[curr].get(i);
					int m = cost[curr].get(i);
					
					if(!done[next])
						pq.add(new State(next,cst+m,curr));
				}
			}
			
			//for(int i=0; i<n; i++)
			//	System.out.println(ans[i]);
			StringBuilder sb = new StringBuilder("");
		
			String x[] = br.readLine().split(",");
			for(String y:x)
			{
				int m = Integer.parseInt(y)-1;
				sb.append(ans[m]+",");
			}
			System.out.println(sb.toString().substring(0,sb.length()-1));
			
			
			
	}
	static class State{
		
		int x,cost,prev;
		State(int x,int cost,int prev)
		{
			this.x = x;
			this.cost = cost;
			this.prev = prev;
		}
	}
	

}
