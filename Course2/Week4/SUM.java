package Course2.Week4;

import java.io.*;
import java.util.*;

public class SUM {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\SAWANT\\Desktop\\hash.txt"));
		
		int n = 1000000;
		boolean possible[] = new boolean[20001];
		
		HashSet<Long> set = new HashSet<Long>();
		
		for(int i=0; i<n; i++)
		{
			long x = Long.parseLong(br.readLine());
			System.out.println(i);
			for(long j=-10000; j<=10000; j++)
			{
				if(x == j/2) continue;
				
				if(set.contains(j-x))
					possible[(int)j+10000] = true;
				
			}
			set.add(x);
		}
		
		int c = 0;
		for(int i=0; i<=20000; i++)
			if(possible[i])
				c++;
	
		System.out.println(c);
	}

}
