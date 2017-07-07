package Course3.Week4;

import java.io.*;
import java.util.*;

public class Knapsack1 {
	
	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\SAWANT\\Desktop\\knapsack1.txt"));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int capacity = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int w[] = new int[n+1];
		long val[] = new long[n+1];
		
		for(int i=1; i<=n; i++)
		{
			st = new StringTokenizer(br.readLine());
			val[i] = Integer.parseInt(st.nextToken());
			w[i] = Integer.parseInt(st.nextToken());
		}
		
		long dp[][] = new long[n+1][capacity+1];
		
		for(int i=0; i<=n; i++)
			dp[i][0] = 0;
		for(int i=0; i<=capacity; i++)
			dp[0][i] = 0;
		
		for(int i=1; i<=n; i++)
			for(int j=1; j<=capacity; j++)
			{
				if(j < w[i])
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = Math.max(dp[i-1][j], val[i] + dp[i-1][j-w[i]]);
			}
	
		System.out.println(dp[n][capacity]);
		
	}

}
